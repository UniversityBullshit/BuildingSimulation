package com.universitybusiness.view.actions;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.components.Area;
import com.universitybusiness.view.components.ControlButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.CompletableFuture;

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