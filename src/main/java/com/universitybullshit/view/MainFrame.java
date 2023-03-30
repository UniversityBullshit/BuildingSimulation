package com.universitybullshit.view;

import com.universitybullshit.view.actions.AboutMenuItemListener;
import com.universitybullshit.view.actions.ConfigureMenuItemListener;
import com.universitybullshit.view.actions.CreateButtonListener;
import com.universitybullshit.view.component.ComponentFabric;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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
        HashMap<String, Integer> widthMap = new HashMap<>();
        widthMap.put("gridx", 0);
        widthMap.put("gridy", 0);
        widthMap.put("anchor", GridBagConstraints.FIRST_LINE_START);
        componentFabric.setupConstraints("width_label", widthMap);
        JLabel widthLabel = componentFabric.getComponent("width_label");
        GridBagConstraints widthLabelConstraints = componentFabric.getConstraints("width_label");

        componentFabric.createComponent(new JLabel("Height"), "height_label");
        HashMap<String, Integer> heightMap = new HashMap<>();
        heightMap.put("gridx", 1);
        heightMap.put("gridy", 0);
        heightMap.put("anchor", GridBagConstraints.FIRST_LINE_START);
        componentFabric.setupConstraints("height_label", heightMap);
        JLabel heightLabel = componentFabric.getComponent("height_label");
        GridBagConstraints heightLabelConstraints = componentFabric.getConstraints("height_label");

        componentFabric.createComponent(new JTextField(8), "width_textfield");
        HashMap<String, Integer> widthFieldMap = new HashMap<>();
        widthFieldMap.put("gridx", 0);
        widthFieldMap.put("gridy", 1);
        componentFabric.setupConstraints("width_textfield", widthFieldMap);
        JTextField widthTextField = componentFabric.getComponent("width_textfield");
        GridBagConstraints widthTextFieldConstraints = componentFabric.getConstraints("width_textfield");

        componentFabric.createComponent(new JTextField(8), "height_textfield");
        HashMap<String, Integer> heightFieldMap = new HashMap<>();
        heightFieldMap.put("gridx", 1);
        heightFieldMap.put("gridy", 1);
        componentFabric.setupConstraints("height_textfield", heightFieldMap);
        JTextField heightTextField = componentFabric.getComponent("height_textfield");
        GridBagConstraints heightTextFieldConstraints = componentFabric.getConstraints("height_textfield");

        componentFabric.createComponent(new JButton("Create"), "create_button");
        HashMap<String, Integer> createButtonMap = new HashMap<>();
        createButtonMap.put("gridy", 2);
        createButtonMap.put("gridwidth", 2);
        createButtonMap.put("fill", GridBagConstraints.HORIZONTAL);
        componentFabric.setupConstraints("create_button", createButtonMap);
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
