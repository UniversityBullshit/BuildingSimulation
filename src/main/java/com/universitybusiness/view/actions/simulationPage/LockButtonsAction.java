package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.components.controls.ControlButton;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LockButtonsAction extends AbstractAction {
    private final SimulationViewModel model;
    private final ControlButton startButton;
    private final ControlButton stopButton;

    public LockButtonsAction(
        SimulationViewModel model,
        ControlButton startButton,
        ControlButton stopButton
    ) {
        this.model = model;
        this.startButton = startButton;
        this.stopButton = stopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startButton.setEnabled(!model.isAreaUpdating());
        stopButton.setEnabled(model.isAreaUpdating());
    }
}
