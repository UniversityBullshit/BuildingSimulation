package com.universitybullshit.view.pages;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.components.ControlButton;
import com.universitybullshit.view.fabrics.ComponentFabric;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InformationPage implements IPage {
    private final JFrame frame;
    private final Map<String, JComponent> components;
    private final WindowManager context;


    // String constants
    private final String MAIN_LABEL_NAME =                   "SimulationInfo";
    private final String SIMULATION_TIME_LABEL_NAME =        "SimulationTime";
    private final String SIMULATION_TIME_NUMBER_NAME =       "SimulationTimeNumber";
    private final String TOTAL_BUILDINGS_COUNT_LABEL_NAME =  "TotalBuildingsCount";
    private final String TOTAL_BUILDINGS_COUNT_NUMBER_NAME = "TotalBuildingsCountNumber";
    private final String WOODEN_BUILDINGS_LABEL_NAME =       "WoodenBuilding";
    private final String WOODEN_BUILDINGS_IMAGE_NAME =       "WoodenBuildingsImage";
    private final String WOODEN_BUILDINGS_COUNT_NAME =       "WoodenBuildingsCount";
    private final String CAPITAL_BUILDINGS_LABEL_NAME =      "CapitalBuildings";
    private final String CAPITAL_BUILDINGS_IMAGE_NAME =      "CapitalBuildingsImage";
    private final String CAPITAL_BUILDINGS_COUNT_NAME =      "CapitalBuildingsCount";
    private final String OK_BUTTON_NAME =                    "OK";

    public InformationPage(JFrame frame, WindowManager context) {
        this.frame = frame;
        this.context = context;
        components = new HashMap<>();

        initializeComponents();
        setupAppearance();
    }

    @Override
    public void initializeComponents() {
        components.put(MAIN_LABEL_NAME, new JLabel("Simulation info"));

        components.put(SIMULATION_TIME_LABEL_NAME, new JLabel("Simulation time: "));
        components.put(SIMULATION_TIME_NUMBER_NAME, new JLabel());
        components.put(TOTAL_BUILDINGS_COUNT_LABEL_NAME, new JLabel("Total buildings count"));
        components.put(TOTAL_BUILDINGS_COUNT_NUMBER_NAME, new JLabel());

        components.put(WOODEN_BUILDINGS_IMAGE_NAME, new JPanel());
        components.put(WOODEN_BUILDINGS_LABEL_NAME, new JLabel("<html>Wooden</br>building</html>"));
        components.put(WOODEN_BUILDINGS_COUNT_NAME, new JLabel("Count: "));

        components.put(CAPITAL_BUILDINGS_IMAGE_NAME, new JPanel());
        components.put(CAPITAL_BUILDINGS_LABEL_NAME, new JLabel("<html>Capital<br>building</html>"));
        components.put(CAPITAL_BUILDINGS_COUNT_NAME, new JLabel("Count: "));

        components.put(OK_BUTTON_NAME, new ControlButton(OK_BUTTON_NAME));
    }

    @Override
    public void setupAppearance() {
        ComponentFabric.setupLabel1((JLabel) components.get(MAIN_LABEL_NAME));

        ComponentFabric.setupLabel2((JLabel) components.get(SIMULATION_TIME_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(SIMULATION_TIME_NUMBER_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(TOTAL_BUILDINGS_COUNT_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(TOTAL_BUILDINGS_COUNT_NUMBER_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(WOODEN_BUILDINGS_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(CAPITAL_BUILDINGS_LABEL_NAME));

        ComponentFabric.setupLabel3((JLabel) components.get(WOODEN_BUILDINGS_COUNT_NAME));
        ComponentFabric.setupLabel3((JLabel) components.get(CAPITAL_BUILDINGS_COUNT_NAME));

        ComponentFabric.setupControlButtonDark((ControlButton) components.get(OK_BUTTON_NAME));
    }

    @Override
    public void draw() {
        // No implementation
    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        dialog.setSize(new Dimension(488, 373));

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(createMainLabelPanel());
        rootPanel.add(createSimulationTimePanel());
        rootPanel.add(createTotalBuildingsCountPanel());
        rootPanel.add(createBuildingsTypesPanel());
        rootPanel.add(createBuildingsCountPanel());
        rootPanel.add(createOKButtonPanel());

        dialog.add(rootPanel);
    }

    private JPanel createMainLabelPanel() {
        JPanel panel = new JPanel();

        panel.add(components.get(MAIN_LABEL_NAME));

        return panel;
    }

    private JPanel createSimulationTimePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(components.get(SIMULATION_TIME_LABEL_NAME), BorderLayout.WEST);
        panel.add(components.get(SIMULATION_TIME_NUMBER_NAME), BorderLayout.EAST);

        return panel;
    }

    private JPanel createTotalBuildingsCountPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(components.get(TOTAL_BUILDINGS_COUNT_LABEL_NAME), BorderLayout.WEST);
        panel.add(components.get(TOTAL_BUILDINGS_COUNT_NUMBER_NAME), BorderLayout.EAST);

        return panel;
    }

    private JPanel createBuildingsTypesPanel() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel createBuildingsCountPanel() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel createOKButtonPanel() {
        JPanel panel = new JPanel();

        return panel;
    }
}
