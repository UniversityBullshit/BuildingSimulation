package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.controller.HabitatController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartKeyAction extends AbstractAction {
    private final HabitatController controller;

    public StartKeyAction(
        HabitatController controller
    ) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.startSimulation();
    }
}
