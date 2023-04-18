package com.universitybullshit.view;

import com.universitybullshit.view.util.ControlButton;

import javax.swing.*;
import java.awt.*;

public class SimulationWindow {
    private static JFrame frame;
    private static JPanel rootPanel = new JPanel();
    private static int simulationAreaWidth;
    private static int simulationAreaHeight;

    public static void draw(JFrame context, int width, int height) {
        frame = context;
        simulationAreaWidth = width;
        simulationAreaHeight = height;
        frame.setSize(simulationAreaWidth + 270, simulationAreaHeight + 20);
        frame.setLocationRelativeTo(null);
        generateSimulationWindow();

        frame.requestFocusInWindow();
        frame.setVisible(true);
    }

    public static void generateSimulationWindow() {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.setBackground(Color.WHITE);

        rootPanel.add(createControls());
        rootPanel.add(createSimulationArea());

//        frame.setContentPane(rootPanel);
    }

    public static JPanel createControls() {
        JPanel controls = new JPanel();

        controls.add((new ControlButton("Start")));
        controls.add(new ControlButton("Stop"));

        return controls;
    }

    public static JPanel createSimulationArea() {
        JPanel simulationArea = new JPanel();

        simulationArea.add(new JLabel("Simulation area"));

        return simulationArea;
    }

    public static JFrame getContext() {
        return frame;
    }
}
