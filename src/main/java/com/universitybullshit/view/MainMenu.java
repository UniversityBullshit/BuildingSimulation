package com.universitybullshit.view;

import com.universitybullshit.view.actions.AboutMenuItemListener;
import com.universitybullshit.view.actions.ControlsMenuItemListener;
import com.universitybullshit.view.actions.CreateButtonListener;
import com.universitybullshit.view.component.FontFactory;
import com.universitybullshit.view.component.ImageFactory;
import com.universitybullshit.view.util.ControlButton;
import com.universitybullshit.view.util.HintTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainMenu {
    private static final String title = "BuildingSpawner";
    private static final JFrame frame = new JFrame(title);
    private static final JPanel root = new JPanel();
    private static final ImageFactory imageFactory = new ImageFactory();
    private static final FontFactory fontFactory = new FontFactory();
    private static JPanel WidthPanel;
    private static JPanel HeightPanel;
    public static void Draw() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 650);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(imageFactory.getIcon());
        GenerateMenu();

        frame.pack();
        frame.requestFocusInWindow();
        frame.setVisible(true);
    }

    private static void GenerateMenu() {
        createMenuBar();
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        rootPanel.setBackground(Color.WHITE);

        rootPanel.add(createEmptyButton());
        rootPanel.add(createMainLabel());
        rootPanel.add(createMainImage());
        rootPanel.add(createSetupFields());
        rootPanel.add(createCreationButton());
        rootPanel.add(createAdditionalsButton());

        frame.add(rootPanel);
    }

    private static void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        UIManager.put("MenuBar.background", Color.BLACK);

        JMenu help = new JMenu("Help");
        help.setForeground(Color.WHITE);

        JMenuItem controls = new JMenuItem("Controls");
        JMenuItem about = new JMenuItem("About");

        ControlsMenuItemListener controlsListener = new ControlsMenuItemListener();
        AboutMenuItemListener aboutListener = new AboutMenuItemListener();

        help.add(controls);
        help.add(about);
        menuBar.add(help);

        controls.addActionListener(controlsListener);
        about.addActionListener(aboutListener);
        frame.setJMenuBar(menuBar);
    }

    private static JButton createEmptyButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0,0));
        return button;
    }

    private static JPanel createMainLabel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setMaximumSize(new Dimension(400,50));

        JLabel label = new JLabel("Main menu");

        label.setForeground(Color.BLACK);
        label.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 36));

        panel.add(label);

        return panel;
    }

    private static JPanel createMainImage() {
        JPanel imgPanel = new JPanel();

        imgPanel.setBackground(Color.WHITE);
        imgPanel.setMaximumSize(new Dimension(420, 280));
        imgPanel.add(new JLabel(new ImageIcon(imageFactory.getMainMenuImage().getScaledInstance(420, 280, Image.SCALE_SMOOTH))));

        return imgPanel;
    }
    private static JPanel createSetupFields() {
        JPanel setup = new JPanel();

        setup.setMinimumSize(new Dimension(400, 200));
        setup.setBackground(Color.WHITE);

        WidthPanel = createField("Width");
        setup.add(WidthPanel);

        setup.add(Box.createHorizontalStrut(8));

        HeightPanel = createField("Height");
        setup.add(HeightPanel);

        return setup;
    }

    private static JPanel createField(String fieldName) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(0,20,0,20));

        JLabel label = new JLabel(fieldName);
        label.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 18));

        HintTextField textField = new HintTextField("500-1000",9);
        textField.setPreferredSize(new Dimension(160,30));
        textField.setRadius(15);
        textField.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 15));
        textField.setForeground(new Color(113,113,113));
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(2,20,2,5)
        ));

        panel.add(label);
        panel.add(textField);

        return panel;
    }

    private static JPanel createCreationButton() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20,0,0,0));
        panel.setBackground(Color.WHITE);

        ControlButton button = new ControlButton("Create");
        button.setColorOver(new Color(20,20,20));
        button.setColor(Color.BLACK);
        button.setColorClick(new Color(80,80,80));
        button.setRadius(20);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBorder(new EmptyBorder(5,10,5,10));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 18));

        CreateButtonListener createButtonListener = new CreateButtonListener(
                (JTextField) WidthPanel.getComponent(1),
                (JTextField) HeightPanel.getComponent(1),
                root);

        button.addActionListener(createButtonListener);
        panel.add(button);

        return panel;
    }

    private static JPanel createAdditionalsButton() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0,0,20,0));
        panel.setBackground(Color.WHITE);

        ControlButton button = new ControlButton("Additional settings");
        button.setColorOver(new Color(90,90,90));
        button.setColor(new Color(80,80,80));
        button.setColorClick(new Color(100,100,100));
        button.setRadius(20);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBorder(new EmptyBorder(5,10,5,10));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 18));

        panel.add(button);

        return panel;
    }
}
