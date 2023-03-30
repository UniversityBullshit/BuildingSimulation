package com.universitybullshit.view;

import com.universitybullshit.view.actions.AboutMenuItemListener;
import com.universitybullshit.view.actions.ConfigureMenuItemListener;
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
        JMenu options = new JMenu("Options");
        JMenuItem config = new JMenuItem("Configure");
        JMenuItem controls = new JMenuItem("Controls");
        JMenuItem about = new JMenuItem("About");
        AboutMenuItemListener aboutListener = new AboutMenuItemListener();
        ConfigureMenuItemListener configListener = new ConfigureMenuItemListener();
        help.add(controls);
        help.add(about);
        options.add(config);
        menuBar.add(options);
        menuBar.add(help);
        config.addActionListener(configListener);
        about.addActionListener(aboutListener);
        frame.setJMenuBar(menuBar);
    }

    private static JPanel createTopPane() {
        ComponentFabric componentFabric = new ComponentFabric();

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
        componentFabric.createComponent(new JLabel("Width"), "width_label");
        componentFabric.setupConstraints("width_label", 0, 0, null, null, null, GridBagConstraints.FIRST_LINE_START);
        JLabel widthLabel = componentFabric.getComponent("width_label");
        GridBagConstraints widthLabelConstraints = componentFabric.getConstraints("width_label");

        componentFabric.createComponent(new JLabel("Height"), "height_label");
        componentFabric.setupConstraints("height_label", 1, 0, null, null, null, GridBagConstraints.FIRST_LINE_START);
        JLabel heightLabel = componentFabric.getComponent("height_label");
        GridBagConstraints heightLabelConstraints = componentFabric.getConstraints("height_label");

        componentFabric.createComponent(new JTextField(8), "width_textfield");
        componentFabric.setupConstraints("width_textfield", 0, 1, null, null, null, null);
        JTextField widthTextField = componentFabric.getComponent("width_textfield");
        GridBagConstraints widthTextFieldConstraints = componentFabric.getConstraints("width_textfield");

        componentFabric.createComponent(new JTextField(8), "height_textfield");
        componentFabric.setupConstraints("height_textfield", 1, 1, null, null, null, null);
        JTextField heightTextField = componentFabric.getComponent("height_textfield");
        GridBagConstraints heightTextFieldConstraints = componentFabric.getConstraints("height_textfield");

        componentFabric.createComponent(new JButton("Create"), "create_button");
        componentFabric.setupConstraints("create_button", null, 2, 2, null, GridBagConstraints.HORIZONTAL, null);
        JButton createButton = componentFabric.getComponent("create_button");
        GridBagConstraints createButtonConstraints = componentFabric.getConstraints("create_button");
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
