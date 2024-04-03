package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.components.simulationView.Area;
import com.universitybusiness.view.components.controls.ControlButton;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartKeyAction extends AbstractAction {
    private final HabitatController controller;
    private final Area area;
    private ControlButton startButton = null;
    private ControlButton stopButton = null;

    public StartKeyAction(
        HabitatController controller,
        Area area
    ) {
        this.controller = controller;
        this.area = area;
    }

    public StartKeyAction(
        HabitatController controller,
        Area area,
        ControlButton startButton,
        ControlButton stopButton
    ) {
        this(controller, area);
        this.startButton = startButton;
        this.stopButton = stopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startUpdating();

        if (this.startButton != null) {
            startButton.setEnabled(false);
        }

        if (this.stopButton != null) {
            stopButton.setEnabled(true);
        }
    }

    private void startUpdating() {
        this.controller.startSimulation();
        this.area.startUpdating();
    }
}