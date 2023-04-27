package com.universitybullshit.view;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.actions.*;
import com.universitybullshit.view.components.*;
import com.universitybullshit.view.fabrics.ComponentFabric;
import com.universitybullshit.view.fabrics.FontFactory;
import com.universitybullshit.view.util.*;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SimulationWindow {
    @Getter
    private static JFrame frame;
    private static final JPanel rootPanel = new JPanel();
    private static final FontFactory fontFactory = new FontFactory();
    private static int simulationAreaWidth;
    private static int simulationAreaHeight;
    private static Area simulationArea;
    private static HabitatController controller;
    @Getter
    @Setter
    private static boolean showInfoDialog = false;

    public static void draw(JFrame context, int width, int height) {
        frame = context;
        simulationAreaWidth = width;
        simulationAreaHeight = height;
        frame.setSize(simulationAreaWidth + 220, simulationAreaHeight + 20);
        frame.setLocationRelativeTo(null);
        generateSimulationWindow();

        frame.requestFocusInWindow();
        frame.setVisible(true);
    }

    private static void generateSimulationWindow() {
        controller = new HabitatController(simulationAreaWidth - 10, simulationAreaHeight - 10);
        simulationArea = new Area(simulationAreaWidth - 10, simulationAreaHeight - 10, controller);

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.setBackground(Color.WHITE);

        rootPanel.add(createControls());
        rootPanel.add(createSimulationArea());

        frame.setContentPane(rootPanel);
    }

    private static JPanel createControls() {
        JPanel controls = new JPanel();
        controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));
        controls.setPreferredSize(new Dimension(200, simulationAreaHeight + 20));
        controls.setMaximumSize(new Dimension(200, simulationAreaHeight + 20));
        controls.setBorder(new EmptyBorder(20, 0, simulationAreaHeight - 200, 0));
        controls.setBackground(Color.BLACK);

        controls.add(createControlsLabel());
        controls.add(createStartButton());
        controls.add(createStopButton());
        controls.add(createShowInfo());
        controls.add(createShowTime());

        return controls;
    }

    private static JPanel createControlsLabel() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0,0,10,50));
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel("Controls");

        label.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 24));
        label.setForeground(Color.WHITE);

        panel.add(label);

        return panel;
    }

    private static JPanel createStartButton() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        ControlButton startButton = new ControlButton("Start");
        ComponentFabric.setupControlButtonLight(startButton);

        startButton.addActionListener(new StartKeyAction(controller, simulationArea));

        panel.add(startButton);

        return panel;
    }

    private static JPanel createStopButton() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        ControlButton stopButton = new ControlButton("Stop");
        ComponentFabric.setupControlButtonLight(stopButton);

        stopButton.addActionListener(new StopKeyAction(controller, simulationArea));

        HorizontalGap emptySpace = new HorizontalGap(25);
        emptySpace.setForeground(Color.BLACK);

        panel.add(stopButton);
        panel.add(emptySpace);

        return panel;
    }

    private static JPanel createShowInfo() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel("Show info");
        label.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0,0,0,10));

        SwitchButton button = new SwitchButton();
        button.setAction(new ShowInfoAction());

        panel.add(label);
        panel.add(button);

        return panel;
    }

    private static JPanel createShowTime() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        RadioButton showTimeButton = new RadioButton("Show time", true);
        RadioButton hideTimeButton = new RadioButton("Hide time", false);
        ButtonGroup timeButtons = new ButtonGroup();

        showTimeButton.setBackground(Color.BLACK);
        showTimeButton.setActiveColor(new Color(6,183,23));
        showTimeButton.setUnactiveColor(new Color(125,125,125));
        hideTimeButton.setBackground(Color.BLACK);
        hideTimeButton.setActiveColor(new Color(6,183,23));
        hideTimeButton.setUnactiveColor(new Color(125,125,125));

        ItemListener showTimeListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == showTimeButton) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        simulationArea.setShowTime(true);
                        simulationArea.repaint();
                    }
                } else {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        simulationArea.setShowTime(false);
                        simulationArea.repaint();
                    }
                }
            }
        };

        showTimeButton.addItemListener(showTimeListener);
        hideTimeButton.addItemListener(showTimeListener);

        timeButtons.add(showTimeButton);
        timeButtons.add(hideTimeButton);

        panel.add(showTimeButton, timeButtons);
        panel.add(hideTimeButton, timeButtons);

        return panel;
    }

    public static JPanel createSimulationArea() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JRootPane rootPane = frame.getRootPane();
        KeyboardInput.createKeyBindings(rootPane, controller, simulationArea);

        panel.add(simulationArea);

        return panel;
    }
}
