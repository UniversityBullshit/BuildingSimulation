package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.common.SwapPageAction;
import com.universitybusiness.view.actions.dialog.CloseDialogAction;
import com.universitybusiness.view.components.controls.ControlButton;
import com.universitybusiness.view.components.menubar.CustomMenuBar;
import com.universitybusiness.view.fabrics.ComponentFabric;
import com.universitybusiness.view.util.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class InformationPage extends Page implements IPage {
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
    private final String CONTINUE_BUTTON_NAME =              "Continue";
    private final String EXIT_BUTTON_NAME =                  "Exit";

    public InformationPage(JFrame frame, WindowManager context) {
        super(frame, context);
        this.menuBar = new CustomMenuBar(context);
    }

    @Override
    public void initializeComponents() {
        components.put(MAIN_LABEL_NAME, new JLabel("Simulation info"));

        components.put(SIMULATION_TIME_LABEL_NAME, new JLabel("Simulation time: "));
        components.put(SIMULATION_TIME_NUMBER_NAME, new JLabel());
        components.put(TOTAL_BUILDINGS_COUNT_LABEL_NAME, new JLabel("Total buildings count"));
        components.put(TOTAL_BUILDINGS_COUNT_NUMBER_NAME, new JLabel());

        components.put(WOODEN_BUILDINGS_IMAGE_NAME, new JPanel());
        components.put(WOODEN_BUILDINGS_LABEL_NAME, new JLabel("<html><p>Wooden</p><p>building</p></html>"));
        components.put(WOODEN_BUILDINGS_COUNT_NAME, new JLabel("Count: "));

        components.put(CAPITAL_BUILDINGS_IMAGE_NAME, new JPanel());
        components.put(CAPITAL_BUILDINGS_LABEL_NAME, new JLabel("<html>Capital<br>building</html>"));
        components.put(CAPITAL_BUILDINGS_COUNT_NAME, new JLabel("Count: "));

        components.put(CONTINUE_BUTTON_NAME, new ControlButton(CONTINUE_BUTTON_NAME));
        components.put(EXIT_BUTTON_NAME, new ControlButton(EXIT_BUTTON_NAME));
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public void setupAppearance() {
        ComponentFabric.setupLabel1((JLabel) components.get(MAIN_LABEL_NAME));
        components.get(MAIN_LABEL_NAME).setBorder(new EmptyBorder(0,0,-20,0));

        ComponentFabric.setupLabel2((JLabel) components.get(SIMULATION_TIME_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(SIMULATION_TIME_NUMBER_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(TOTAL_BUILDINGS_COUNT_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(TOTAL_BUILDINGS_COUNT_NUMBER_NAME));

        ComponentFabric.setupLabel2((JLabel) components.get(WOODEN_BUILDINGS_LABEL_NAME));
        components.get(WOODEN_BUILDINGS_LABEL_NAME).setBorder(new EmptyBorder(0,21,0,0));
        ComponentFabric.setupLabel2((JLabel) components.get(CAPITAL_BUILDINGS_LABEL_NAME));
        components.get(CAPITAL_BUILDINGS_LABEL_NAME).setBorder(new EmptyBorder(0,21,0,0));

        components.get(WOODEN_BUILDINGS_IMAGE_NAME).add(new JLabel(new ImageIcon(
                WindowManager.
                        getImageFactory().
                        getWoodenBuilding().
                        getScaledInstance(50,50, Image.SCALE_SMOOTH))));
        components.get(WOODEN_BUILDINGS_IMAGE_NAME).setBackground(Style.getPrimaryLightColor());

        components.get(CAPITAL_BUILDINGS_IMAGE_NAME).add(new JLabel(new ImageIcon(
                WindowManager.
                        getImageFactory().
                        getCapitalBuilding().
                        getScaledInstance(50,50,Image.SCALE_SMOOTH))));
        components.get(CAPITAL_BUILDINGS_IMAGE_NAME).setBackground(Style.getPrimaryLightColor());

        ComponentFabric.setupLabel3((JLabel) components.get(WOODEN_BUILDINGS_COUNT_NAME));
        ComponentFabric.setupLabel3((JLabel) components.get(CAPITAL_BUILDINGS_COUNT_NAME));

        ComponentFabric.setupControlButtonDark((ControlButton) components.get(CONTINUE_BUTTON_NAME));
        ComponentFabric.setupControlButtonDark((ControlButton) components.get(EXIT_BUTTON_NAME));
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
        rootPanel.add(createOKButtonPanel(dialog));

        dialog.add(rootPanel);
    }

    private JPanel createMainLabelPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);

        panel.add(components.get(MAIN_LABEL_NAME));

        return panel;
    }

    private JPanel createSimulationTimePanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(0,50,0,41));

        panel.add(components.get(SIMULATION_TIME_LABEL_NAME), BorderLayout.WEST);
        panel.add(components.get(SIMULATION_TIME_NUMBER_NAME), BorderLayout.EAST);

        ((JLabel) components.get(SIMULATION_TIME_NUMBER_NAME)).setText(
                (context.getController().getSimulationTime() / 1000) + "s");

        return panel;
    }

    private JPanel createTotalBuildingsCountPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(0,50,0,41));

        panel.add(components.get(TOTAL_BUILDINGS_COUNT_LABEL_NAME), BorderLayout.WEST);
        panel.add(components.get(TOTAL_BUILDINGS_COUNT_NUMBER_NAME), BorderLayout.EAST);

        ((JLabel) components.get(TOTAL_BUILDINGS_COUNT_NUMBER_NAME)).setText(Integer.toString(
                context.getController().getWoodenBuildingsCount() + context.getController().getCapitalBuildingsCount()));

        return panel;
    }

    private JPanel createBuildingsTypesPanel() {
        JPanel panel = new JPanel();
        JPanel woodenBuildingPanel = new JPanel();
        JPanel capitalBuildingPanel = new JPanel();

        ComponentFabric.setupLightPanel(panel);
        ComponentFabric.setupLightPanel(woodenBuildingPanel);
        ComponentFabric.setupLightPanel(capitalBuildingPanel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(0,50,0,0));
        woodenBuildingPanel.setLayout(new BoxLayout(woodenBuildingPanel, BoxLayout.X_AXIS));
        capitalBuildingPanel.setLayout(new BoxLayout(capitalBuildingPanel, BoxLayout.X_AXIS));

        woodenBuildingPanel.add(components.get(WOODEN_BUILDINGS_IMAGE_NAME));
        woodenBuildingPanel.add(components.get(WOODEN_BUILDINGS_LABEL_NAME));

        capitalBuildingPanel.add(components.get(CAPITAL_BUILDINGS_IMAGE_NAME));
        capitalBuildingPanel.add(components.get(CAPITAL_BUILDINGS_LABEL_NAME));

        panel.add(woodenBuildingPanel);
        panel.add(capitalBuildingPanel);

        return panel;
    }

    private JPanel createBuildingsCountPanel() {
        JPanel panel = new JPanel();
        JPanel woodenBuildingPanel = new JPanel();
        JPanel capitalBuildingPanel = new JPanel();

        ComponentFabric.setupLightPanel(panel);
        ComponentFabric.setupLightPanel(woodenBuildingPanel);
        ComponentFabric.setupLightPanel(capitalBuildingPanel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(0,60,0,0));
        woodenBuildingPanel.setLayout(new BorderLayout());
        capitalBuildingPanel.setLayout(new BorderLayout());

        ((JLabel) components.get(WOODEN_BUILDINGS_COUNT_NAME)).setText(
                "Count: " + context.getController().getWoodenBuildingsCount());

        ((JLabel) components.get(CAPITAL_BUILDINGS_COUNT_NAME)).setText(
                "Count: " + context.getController().getCapitalBuildingsCount());

        woodenBuildingPanel.add(components.get(WOODEN_BUILDINGS_COUNT_NAME), BorderLayout.WEST);
        capitalBuildingPanel.add(components.get(CAPITAL_BUILDINGS_COUNT_NAME), BorderLayout.WEST);

        panel.add(woodenBuildingPanel);
        panel.add(capitalBuildingPanel);

        return panel;
    }

    private JPanel createOKButtonPanel(JDialog dialog) {
        JPanel panel = new JPanel();
        panel.setBackground(Style.getPrimaryLightColor());

        panel.add(components.get(CONTINUE_BUTTON_NAME));
        panel.add(components.get(EXIT_BUTTON_NAME));

        ActionListener closeDialogAction = new CloseDialogAction(dialog);

        ((ControlButton) components.get(CONTINUE_BUTTON_NAME)).addActionListener(closeDialogAction);
        ((ControlButton) components.get(EXIT_BUTTON_NAME)).addActionListener(closeDialogAction);
        ((ControlButton) components.get(EXIT_BUTTON_NAME)).addActionListener(new SwapPageAction(context, WindowManager.Pages.MAIN_MENU));

        return panel;
    }
}
