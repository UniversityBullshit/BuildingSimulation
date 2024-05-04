package com.universitybusiness.view.pages;

import com.universitybusiness.model.terminal.impl.Terminal;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.viewModel.TerminalViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TerminalPage extends Page implements IPage {
    private final String HISTORY = "History";
    private final String INPUT = "Input";

    private final Terminal terminal = Terminal.getInstance();

    public TerminalPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }

    @Override
    public void initializeComponents() {
        JTextArea history = new JTextArea();
        history.setEditable(false);
        components.put(HISTORY, history);
        components.put(INPUT, new JTextField());

        clearHistory();

        setupActions();
    }

    private void setupActions() {
        TerminalViewModel viewModel = context.getViewModelFactory().getTerminalViewModel();

        ((JTextField) components.get(INPUT)).addActionListener(e -> {
            String command = ((JTextField) components.get(INPUT)).getText();

            if (command.equals("exit")) {
                clearHistory();
                ((JTextField) components.get(INPUT)).setText("");
                context.swapPage(WindowManager.Pages.SIMULATION);
                return;
            }

            ((JTextArea) components.get(HISTORY)).append("> " + command + "\n");
            ((JTextArea) components.get(HISTORY)).append(terminal.execute(command) + "\n");
            ((JTextField) components.get(INPUT)).setText("");

            viewModel.addCommand(command);
        });


        ActionListener upAction = e -> {
            ((JTextField) components.get(INPUT)).setText(viewModel.getPreviousCommand());
        };

        ActionListener downAction = e -> {
            ((JTextField) components.get(INPUT)).setText(viewModel.getNextCommand());
        };

        components.get(INPUT).addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upAction.actionPerformed(null);
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downAction.actionPerformed(null);
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void clearHistory() {
        ((JTextArea) components.get(HISTORY)).setText("Use 'help' program to get list of available programs\n");
        ((JTextArea) components.get(HISTORY)).append("Use 'exit' program to close terminal\n");
    }

    @Override
    public void setupAppearance() {
        ((JTextArea) components.get(HISTORY)).setBackground(Color.BLACK);
        ((JTextArea) components.get(HISTORY)).setForeground(Color.WHITE);
    }

    @Override
    public void draw() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());

        rootPanel.add(new JScrollPane(components.get(HISTORY)), BorderLayout.CENTER);
        rootPanel.add(components.get(INPUT), BorderLayout.SOUTH);

        frame.add(rootPanel);
    }

    @Override
    public void drawAsDialog(JDialog dialog) {

    }
}
