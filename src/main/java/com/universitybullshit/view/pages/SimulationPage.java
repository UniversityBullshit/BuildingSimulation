package com.universitybullshit.view.pages;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.actions.ShowInfoAction;
import com.universitybullshit.view.actions.StartKeyAction;
import com.universitybullshit.view.actions.StopKeyAction;
import com.universitybullshit.view.components.*;
import com.universitybullshit.view.fabrics.ComponentFabric;
import com.universitybullshit.view.util.KeyboardInput;
import com.universitybullshit.view.util.StyleDto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
    }

    @Override
    public void initializeComponents() {
        final String CONTROLS_LABEL_TEXT = "Controls";
        final String INFORMATION_LABEL_TEXT = "Information";
        final String SHOW_INFO_LABEL_TEXT = "Show info";
        final String SHOW_TIME_LABEL_TEXT = "Show time";
        final String HIDE_TIME_LABEL_TEXT = "Hide time";
        final String START_BUTTON_TEXT = "Start";
        final String STOP_BUTTON_TEXT = "Stop";

        components.put(CONTROLS_LABEL_NAME, new JLabel(CONTROLS_LABEL_TEXT));
        components.put(INFORMATION_LABEL_NAME, new JLabel(INFORMATION_LABEL_TEXT));
        components.put(SHOW_INFO_LABEL_NAME, new JLabel(SHOW_INFO_LABEL_TEXT));
        components.put(SHOW_TIME_LABEL_NAME, new JLabel(SHOW_TIME_LABEL_TEXT));
        components.put(HIDE_TIME_LABEL_NAME, new JLabel(HIDE_TIME_LABEL_TEXT));

        components.put(START_BUTTON_NAME, new ControlButton(START_BUTTON_TEXT));
        components.put(STOP_BUTTON_NAME, new ControlButton(STOP_BUTTON_TEXT));
        components.put(EXIT_BUTTON_NAME, new ControlButton(null));

        components.put(SHOW_INFO_SWITCH_NAME, new SwitchButton());

        components.put(SHOW_TIME_RADIO_BUTTON_NAME, new RadioButton(null, true));
        components.put(HIDE_TIME_RADIO_BUTTON_NAME, new RadioButton(null, false));

        components.put(SIMULATION_AREA_NAME, new Area(context.getController()));

        components.put(GAP_18_NAME, new HorizontalGap(18));
        components.put(GAP_14_NAME, new HorizontalGap(14));
        components.put(GAP_13_NAME, new HorizontalGap(13));
        components.put(GAP_8_NAME, new HorizontalGap(8));
        components.put(GAP_6_NAME, new HorizontalGap(6));

        setupActions();
    }

    private void setupActions() {
        StartKeyAction startKeyAction = new StartKeyAction(
                context.getController(),
                (Area) components.get(SIMULATION_AREA_NAME));

        StopKeyAction stopKeyAction = new StopKeyAction(
                (Area) components.get(SIMULATION_AREA_NAME),
                context);

        ShowInfoAction action = new ShowInfoAction(
                (Area) components.get(SIMULATION_AREA_NAME));

        ItemListener showTimeListener = e -> {
            if (e.getSource() == components.get(SHOW_TIME_RADIO_BUTTON_NAME)) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ((Area) components.get(SIMULATION_AREA_NAME)).setShowTime(true);
                    components.get(SIMULATION_AREA_NAME).repaint();
                }
            } else {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ((Area) components.get(SIMULATION_AREA_NAME)).setShowTime(false);
                    components.get(SIMULATION_AREA_NAME).repaint();
                }
            }
        };

        ((ControlButton) components.get(START_BUTTON_NAME)).addActionListener(startKeyAction);
        ((ControlButton) components.get(STOP_BUTTON_NAME)).addActionListener(stopKeyAction);
        ((RadioButton) components.get(SHOW_TIME_RADIO_BUTTON_NAME)).addItemListener(showTimeListener);
        ((RadioButton) components.get(HIDE_TIME_RADIO_BUTTON_NAME)).addItemListener(showTimeListener);
        ((SwitchButton) components.get(SHOW_INFO_SWITCH_NAME)).setAction(action);
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

        ComponentFabric.setupRadioButton((RadioButton) components.get(SHOW_TIME_RADIO_BUTTON_NAME));
        components.get(SHOW_TIME_RADIO_BUTTON_NAME).setBackground(StyleDto.getPrimaryDarkColor());

        ComponentFabric.setupRadioButton((RadioButton) components.get(HIDE_TIME_RADIO_BUTTON_NAME));
        components.get(HIDE_TIME_RADIO_BUTTON_NAME).setBackground(StyleDto.getPrimaryDarkColor());

        components.get(GAP_18_NAME).setForeground(StyleDto.getPrimaryDarkColor());
        components.get(GAP_14_NAME).setForeground(StyleDto.getPrimaryDarkColor());
        components.get(GAP_13_NAME).setForeground(StyleDto.getPrimaryDarkColor());
        components.get(GAP_8_NAME).setForeground(StyleDto.getPrimaryDarkColor());
        components.get(GAP_6_NAME).setForeground(StyleDto.getPrimaryDarkColor());
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

        components.get(SIMULATION_AREA_NAME).setSize(
                context.getController().getContext().getWidth(),
                context.getController().getContext().getHeight());
        simulationAreaPanel.add(components.get(SIMULATION_AREA_NAME));

        rootPanel.add(controlsPanel);
        rootPanel.add(simulationAreaPanel);

        KeyboardInput.createKeyBindings(rootPanel, context, (Area) components.get(SIMULATION_AREA_NAME));
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

    @Override
    public void drawAsDialog(JDialog dialog) {
        // No implementation
    }
}
