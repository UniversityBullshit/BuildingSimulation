package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.components.controls.ControlButton;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartKeyAction extends AbstractAction {
    private final HabitatController controller;
    private ControlButton currentObjectsButton = null;

    public StartKeyAction(
        HabitatController controller
    ) {
        this.controller = controller;
    }

    public StartKeyAction(
        HabitatController controller,
        ControlButton currentObjectsButton
    ) {
        this(controller);
        this.currentObjectsButton = currentObjectsButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startUpdating();

        if (this.currentObjectsButton != null) {
            currentObjectsButton.setEnabled(true);
        }
    }

    private void startUpdating() {
        this.controller.startSimulation();
    }
}