package com.universitybullshit.view;

import com.universitybullshit.view.actions.AboutMenuItemListener;
import com.universitybullshit.view.actions.CreateButtonListener;
import com.universitybullshit.view.component.ComponentFabric;

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
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.setBorder(BorderFactory.createTitledBorder("Menu"));

        JPanel leftPanel = new JPanel();

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rootPanel.add(leftPanel, BorderLayout.WEST);
        rootPanel.add(rightPanel, BorderLayout.EAST);

        rightPanel.add(new JLabel("FPS: 25"));
        rightPanel.add(new JLabel("Simulation time: 228"));

        leftPanel.setLayout(new GridBagLayout());

        // Create components
        ComponentFabric.createComponent(new JLabel("Width"), "width_label");
        ComponentFabric.setupConstraints("width_label", 0, 0, null, null, null, GridBagConstraints.FIRST_LINE_START);
        JLabel widthLabel = ComponentFabric.getComponent("width_label");
        GridBagConstraints widthLabelConstraints = ComponentFabric.getConstraints("width_label");

        ComponentFabric.createComponent(new JLabel("Height"), "height_label");
        ComponentFabric.setupConstraints("height_label", 1, 0, null, null, null, GridBagConstraints.FIRST_LINE_START);
        JLabel heightLabel = ComponentFabric.getComponent("height_label");
        GridBagConstraints heightLabelConstraints = ComponentFabric.getConstraints("height_label");

        ComponentFabric.createComponent(new JTextField(8), "width_textfield");
        ComponentFabric.setupConstraints("width_textfield", 0, 1, null, null, null, null);
        JTextField widthTextField = ComponentFabric.getComponent("width_textfield");
        GridBagConstraints widthTextFieldConstraints = ComponentFabric.getConstraints("width_textfield");

        ComponentFabric.createComponent(new JTextField(8), "height_textfield");
        ComponentFabric.setupConstraints("height_textfield", 1, 1, null, null, null, null);
        JTextField heightTextField = ComponentFabric.getComponent("height_textfield");
        GridBagConstraints heightTextFieldConstraints = ComponentFabric.getConstraints("height_textfield");

        ComponentFabric.createComponent(new JButton("Create"), "create_button");
        ComponentFabric.setupConstraints("create_button", null, 2, 2, null, GridBagConstraints.HORIZONTAL, null);
        JButton createButton = ComponentFabric.getComponent("create_button");
        GridBagConstraints createButtonConstraints = ComponentFabric.getConstraints("create_button");
        //
        // Adding components
        leftPanel.add(widthLabel, widthLabelConstraints);
        leftPanel.add(heightLabel, heightLabelConstraints);
        leftPanel.add(widthTextField, widthTextFieldConstraints);
        leftPanel.add(heightTextField, heightTextFieldConstraints);
        leftPanel.add(createButton, createButtonConstraints);
        //
        // "Create" button action
        CreateButtonListener actionListener = new CreateButtonListener(widthTextField, heightTextField, root);
        createButton.addActionListener(actionListener);
        //
        return rootPanel;
    }

}
