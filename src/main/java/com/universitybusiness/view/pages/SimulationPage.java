package com.universitybusiness.view.pages;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.dialog.ShowDialogAction;
import com.universitybusiness.view.actions.simulationPage.*;
import com.universitybusiness.view.components.controls.ControlButton;
import com.universitybusiness.view.components.controls.RadioButton;
import com.universitybusiness.view.components.controls.SwitchButton;
import com.universitybusiness.view.components.layout.HorizontalGap;
import com.universitybusiness.view.components.menubar.SimulationMenuBar;
import com.universitybusiness.view.components.simulationView.Area;
import com.universitybusiness.view.fabrics.ComponentFabric;
import com.universitybusiness.view.util.KeyboardInput;
import com.universitybusiness.view.util.Style;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationPage extends Page implements IPage {
    // String constants
    private final String CONTROLS_LABEL_NAME =         "ControlsLabel";
    private final String INFORMATION_LABEL_NAME =      "Information";
    private final String SHOW_INFO_LABEL_NAME =        "ShowInfoLabel";
    private final String SHOW_TIME_LABEL_NAME =        "ShowTimeLabel";
    private final String HIDE_TIME_LABEL_NAME =        "HideTimeLabel";
    private final String START_BUTTON_NAME =           "StartButton";
    private final String STOP_BUTTON_NAME =            "StopButton";
    private final String EXIT_BUTTON_NAME =            "ExitButton";
    private final String CURRENT_OBJECTS_NAME =        "CurrentObjectsButton";
    private final String SHOW_INFO_SWITCH_NAME =       "ShowInfoSwitch";
    private final String SHOW_TIME_RADIO_BUTTON_NAME = "ShowTimeRadioButton";
    private final String HIDE_TIME_RADIO_BUTTON_NAME = "HideTimeRadioButton";
    private final String SIMULATION_AREA_NAME =        "SimulationArea";
    private final String GAP_18_NAME =                 "Gap18";
    private final String GAP_14_NAME =                 "Gap14";
    private final String GAP_13_NAME =                 "Gap13";
    private final String GAP_8_NAME =                  "Gap8";
    private final String GAP_6_NAME =                  "Gap6";

    public SimulationPage(JFrame frame, WindowManager context) {
        super(frame, context);
        this.menuBar = new SimulationMenuBar(context);
    }

    @Override
    public void initializeComponents() {
        components.put(CONTROLS_LABEL_NAME, new JLabel("Controls"));
        components.put(INFORMATION_LABEL_NAME, new JLabel("Information"));
        components.put(SHOW_INFO_LABEL_NAME, new JLabel("Show info"));
        components.put(SHOW_TIME_LABEL_NAME, new JLabel("Show time"));
        components.put(HIDE_TIME_LABEL_NAME, new JLabel("Hide time"));

        components.put(START_BUTTON_NAME, new ControlButton("Start"));
        components.put(STOP_BUTTON_NAME, new ControlButton("Stop", false));
        components.put(EXIT_BUTTON_NAME, new ControlButton(null));
        components.put(CURRENT_OBJECTS_NAME, new ControlButton("Current objects"));

        components.put(SHOW_INFO_SWITCH_NAME, new SwitchButton());

        components.put(SHOW_TIME_RADIO_BUTTON_NAME, new RadioButton(null, true));
        components.put(HIDE_TIME_RADIO_BUTTON_NAME, new RadioButton(null, false));

        components.put(SIMULATION_AREA_NAME, new Area(context.getViewModelFactory().getSimulationViewModel()));

        components.put(GAP_18_NAME, new HorizontalGap(18));
        components.put(GAP_14_NAME, new HorizontalGap(14));
        components.put(GAP_13_NAME, new HorizontalGap(13));
        components.put(GAP_8_NAME, new HorizontalGap(8));
        components.put(GAP_6_NAME, new HorizontalGap(6));

        setupActions();
    }

    @Override
    public void reset() {
        super.reset();

        ((Area) components.get(SIMULATION_AREA_NAME)).reset();
    }

    private void setupActions() {
        HabitatController controller = context.getController();
        SimulationViewModel model = context.getViewModelFactory().getSimulationViewModel();

        model.addUpdateListener(new RepaintAreaAction(
            ((Area) components.get(SIMULATION_AREA_NAME))
        ));

        model.addUpdateListener(new SetInfoButtonAction(
            model,
            ((SwitchButton) components.get(SHOW_INFO_SWITCH_NAME))
        ));

        model.addUpdateListener(new LockButtonsAction(
            model,
            ((ControlButton) components.get(START_BUTTON_NAME)),
            ((ControlButton) components.get(STOP_BUTTON_NAME))
        ));

        model.addUpdateListener(new SwitchRadioButtonsAction(
            model,
            ((RadioButton) components.get(SHOW_TIME_RADIO_BUTTON_NAME)),
            ((RadioButton) components.get(HIDE_TIME_RADIO_BUTTON_NAME))
        ));

        ((ControlButton) components.get(START_BUTTON_NAME)).addActionListener(
            new StartKeyAction(controller)
        );

        ((ControlButton) components.get(STOP_BUTTON_NAME)).addActionListener(
            new StopKeyAction(context)
        );

        ((ControlButton) components.get(CURRENT_OBJECTS_NAME)).addActionListener(
            new ShowDialogAction(context, WindowManager.Pages.CURRENT_OBJECTS)
        );

        ((SwitchButton) components.get(SHOW_INFO_SWITCH_NAME)).addActionListener(
            new ToggleInfoAction(model)
        );

        AbstractAction radioButtonsToggle = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == components.get(SHOW_TIME_RADIO_BUTTON_NAME)) {
                    model.setShowTime(true);
                } else if (e.getSource() == components.get(HIDE_TIME_RADIO_BUTTON_NAME)) {
                    model.setShowTime(false);
                }
            }
        };

        ((RadioButton) components.get(SHOW_TIME_RADIO_BUTTON_NAME)).addActionListener(radioButtonsToggle);
        ((RadioButton) components.get(HIDE_TIME_RADIO_BUTTON_NAME)).addActionListener(radioButtonsToggle);
    }

    @Override
    public void setupAppearance() {
        ComponentFabric.setupLabel2((JLabel) components.get(CONTROLS_LABEL_NAME));
        ComponentFabric.setupLightLabel((JLabel) components.get(CONTROLS_LABEL_NAME));

        ComponentFabric.setupLabel2((JLabel) components.get(INFORMATION_LABEL_NAME));
        ComponentFabric.setupLightLabel((JLabel) components.get(INFORMATION_LABEL_NAME));

        ComponentFabric.setupLabel3((JLabel) components.get(SHOW_INFO_LABEL_NAME));
        ComponentFabric.setupLightLabel((JLabel) components.get(SHOW_INFO_LABEL_NAME));

        ComponentFabric.setupLabel3((JLabel) components.get(SHOW_TIME_LABEL_NAME));
        ComponentFabric.setupLightLabel((JLabel) components.get(SHOW_TIME_LABEL_NAME));

        ComponentFabric.setupLabel3((JLabel) components.get(HIDE_TIME_LABEL_NAME));
        ComponentFabric.setupLightLabel((JLabel) components.get(HIDE_TIME_LABEL_NAME));

        ComponentFabric.setupControlButtonLight((ControlButton) components.get(START_BUTTON_NAME));
        ComponentFabric.setupControlButtonLight((ControlButton) components.get(STOP_BUTTON_NAME));
        ComponentFabric.setupControlButtonLight((ControlButton) components.get(CURRENT_OBJECTS_NAME));

        ComponentFabric.setupRadioButton((RadioButton) components.get(SHOW_TIME_RADIO_BUTTON_NAME));
        components.get(SHOW_TIME_RADIO_BUTTON_NAME).setBackground(Style.getPrimaryDarkColor());

        ComponentFabric.setupRadioButton((RadioButton) components.get(HIDE_TIME_RADIO_BUTTON_NAME));
        components.get(HIDE_TIME_RADIO_BUTTON_NAME).setBackground(Style.getPrimaryDarkColor());

        components.get(GAP_18_NAME).setForeground(Style.getPrimaryDarkColor());
        components.get(GAP_14_NAME).setForeground(Style.getPrimaryDarkColor());
        components.get(GAP_13_NAME).setForeground(Style.getPrimaryDarkColor());
        components.get(GAP_8_NAME).setForeground(Style.getPrimaryDarkColor());
        components.get(GAP_6_NAME).setForeground(Style.getPrimaryDarkColor());
    }

    @Override
    public void draw() {
        JPanel rootPanel = new JPanel();
        JPanel controlsPanel = new JPanel();
        JPanel simulationAreaPanel = new JPanel();

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));
        simulationAreaPanel.setLayout(null);

        controlsPanel.setBorder(new EmptyBorder(0,0, context.getHeight() - 200, 0));
        controlsPanel.setPreferredSize(new Dimension(200, context.getHeight()));
        controlsPanel.setMaximumSize(new Dimension(200, context.getHeight()));

        ComponentFabric.setupDarkPanel(rootPanel);
        ComponentFabric.setupDarkPanel(controlsPanel);
        ComponentFabric.setupLightPanel(simulationAreaPanel);

        controlsPanel.add(createControlsLabelPanel());
        controlsPanel.add(createStartButtonPanel());
        controlsPanel.add(createStopButtonPanel());
        controlsPanel.add(createInformationLabelPanel());
        controlsPanel.add(createShowInfoPanel());
        controlsPanel.add(createShowTimePanel());
        controlsPanel.add(createCurrentObjectsButtonPanel());

        components.get(SIMULATION_AREA_NAME).setSize(
                context.getController().getSimulationService().getWidth(),
                context.getController().getSimulationService().getHeight());
        simulationAreaPanel.add(components.get(SIMULATION_AREA_NAME));

        rootPanel.add(controlsPanel);
        rootPanel.add(simulationAreaPanel);

        KeyboardInput.createKeyBindings(rootPanel, context);
        frame.add(rootPanel);
        frame.requestFocusInWindow();
    }

    private JPanel createControlsLabelPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupDarkPanel(panel);

        panel.setBorder(new EmptyBorder(30,0,0,0));

        panel.add(components.get(CONTROLS_LABEL_NAME));
        panel.add(components.get(GAP_18_NAME));

        return panel;
    }

    private JPanel createStartButtonPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupDarkPanel(panel);

        panel.add(components.get(START_BUTTON_NAME));

        return panel;
    }

    private JPanel createStopButtonPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupDarkPanel(panel);

        panel.add(components.get(STOP_BUTTON_NAME));

        return panel;
    }

    private JPanel createInformationLabelPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupDarkPanel(panel);

        panel.setBorder(new EmptyBorder(20,0,0,0));

        panel.add(components.get(INFORMATION_LABEL_NAME));
        panel.add(components.get(GAP_8_NAME));

        return panel;
    }

    private JPanel createShowInfoPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupDarkPanel(panel);

        panel.add(components.get(SHOW_INFO_LABEL_NAME));
        panel.add(components.get(GAP_6_NAME));
        panel.add(components.get(SHOW_INFO_SWITCH_NAME));

        return panel;
    }

    private JPanel createShowTimePanel() {
        JPanel panel = new JPanel();
        JPanel showPanel = new JPanel();
        JPanel hidePanel = new JPanel();

        ComponentFabric.setupDarkPanel(panel);
        ComponentFabric.setupDarkPanel(showPanel);
        ComponentFabric.setupDarkPanel(hidePanel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ButtonGroup timeButtons = new ButtonGroup();
        timeButtons.add((RadioButton) components.get(SHOW_TIME_RADIO_BUTTON_NAME));
        timeButtons.add((RadioButton) components.get(HIDE_TIME_RADIO_BUTTON_NAME));

        showPanel.add(components.get(SHOW_TIME_LABEL_NAME));
        showPanel.add(components.get(GAP_13_NAME));
        showPanel.add(components.get(SHOW_TIME_RADIO_BUTTON_NAME));

        hidePanel.add(components.get(HIDE_TIME_LABEL_NAME));
        hidePanel.add(components.get(GAP_14_NAME));
        hidePanel.add(components.get(HIDE_TIME_RADIO_BUTTON_NAME));

        panel.add(showPanel);
        panel.add(hidePanel);

        return panel;
    }

    private JPanel createCurrentObjectsButtonPanel() {
        JPanel panel = new JPanel();

        ComponentFabric.setupDarkPanel(panel);

        panel.add(components.get(CURRENT_OBJECTS_NAME));

        return panel;
    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        // No implementation
    }
}
