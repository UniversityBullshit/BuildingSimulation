package com.universitybullshit.view;

import com.universitybullshit.view.actions.AboutMenuItemListener;
//import com.universitybullshit.view.actions.ConfigureMenuItemListener;
import com.universitybullshit.view.actions.ControlsMenuItemListener;
import com.universitybullshit.view.actions.CreateButtonListener;
import com.universitybullshit.view.component.ComponentFabric;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainFrame {
    private static final String title = "BuildingSpawner";
    private static final JFrame frame = new JFrame(title);
    private static final JPanel root = new JPanel();

    public static JFrame getCtx() {
        return frame;
    }

    public static void mainMenu() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 600));
        frame.setLayout(new GridBagLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.add(createSimulationSettings());
        createMenu();
        frame.setVisible(true);
    }

    public static void simulationWindow(int width, int height) {
        frame.setMinimumSize(new Dimension(width + 20, height + 60));
        frame.setLayout(new BorderLayout());

        frame.getContentPane().removeAll();

        ((JPanel)frame.getContentPane()).revalidate();
    }

    private static void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu help = new JMenu("Help");
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

    private static JPanel createSimulationSettings() {
        ComponentFabric componentFabric = new ComponentFabric();

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Simulation settings"));

        rootPanel.setLayout(new GridBagLayout());

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

        componentFabric.createComponent(new JTextField("800",8), "width_textfield");
        HashMap<String, Integer> widthFieldMap = new HashMap<>();
        widthFieldMap.put("gridx", 0);
        widthFieldMap.put("gridy", 1);
        componentFabric.setupConstraints("width_textfield", widthFieldMap);
        JTextField widthTextField = componentFabric.getComponent("width_textfield");
        GridBagConstraints widthTextFieldConstraints = componentFabric.getConstraints("width_textfield");

        componentFabric.createComponent(new JTextField("600",8), "height_textfield");
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
        rootPanel.add(widthLabel, widthLabelConstraints);
        rootPanel.add(heightLabel, heightLabelConstraints);
        rootPanel.add(widthTextField, widthTextFieldConstraints);
        rootPanel.add(heightTextField, heightTextFieldConstraints);
        rootPanel.add(createButton, createButtonConstraints);
        //
        // "Create" button action
        CreateButtonListener actionListener = new CreateButtonListener(widthTextField, heightTextField, root);
        createButton.addActionListener(actionListener);
        //
        return rootPanel;
    }
}
