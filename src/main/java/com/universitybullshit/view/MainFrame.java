package com.universitybullshit.view;

import com.universitybullshit.view.actions.AboutMenuItemListener;
import com.universitybullshit.view.actions.CreateButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static final int width = 800;
    private static final int height = 600;
    private static final String title = "BuildingSpawner";
    private static final JFrame frame = new JFrame(title);
    private static final JPanel root = new JPanel();

    public static JFrame getCtx() {
        return frame;
    }
    public static void createFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLayout(new BorderLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.add(createTopPane(), BorderLayout.NORTH);
        frame.add(root, BorderLayout.CENTER);
        createMenu();
        frame.setVisible(true);
    }

    private static void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu help = new JMenu("Help");
        JMenuItem controls = new JMenuItem("Controls");
        JMenuItem about = new JMenuItem("About");
        AboutMenuItemListener actionListener = new AboutMenuItemListener();
        help.add(controls);
        help.add(about);
        menuBar.add(help);
        about.addActionListener(actionListener);
        frame.setJMenuBar(menuBar);
    }

    private static JPanel createTopPane() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, frame.getWidth(), 150);

//        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Menu"));
        // Width label
        GridBagConstraints wLabelConstraint = new GridBagConstraints();
        wLabelConstraint.gridx = 0;
        wLabelConstraint.gridy = 0;
        wLabelConstraint.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(new JLabel("Width"), wLabelConstraint);
        //
        // Height label
        GridBagConstraints hLabelConstraint = new GridBagConstraints();
        hLabelConstraint.gridx = 1;
        hLabelConstraint.gridy = 0;
        hLabelConstraint.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(new JLabel("Height"), hLabelConstraint);
        //
        // Width text-field
        JTextField width = new JTextField(8);
        GridBagConstraints widthConstraint = new GridBagConstraints();
        widthConstraint.gridx = 0;
        widthConstraint.gridy = 1;
        panel.add(width, widthConstraint);
        //
        // Height text-field
        JTextField height = new JTextField(8);
        GridBagConstraints heightConstraint = new GridBagConstraints();
        heightConstraint.gridx = 1;
        heightConstraint.gridy = 1;
        panel.add(height, heightConstraint);
        //
        // "Create" button
        JButton submitBtn = new JButton("Create");
        CreateButtonListener actionListener = new CreateButtonListener(width, height, root);
        submitBtn.addActionListener(actionListener);
        GridBagConstraints btnConstraint = new GridBagConstraints();
        btnConstraint.gridy = 2;
        btnConstraint.gridwidth = 2;
        btnConstraint.fill = GridBagConstraints.HORIZONTAL;
        panel.add(submitBtn, btnConstraint);
        //
        return panel;
    }

}
