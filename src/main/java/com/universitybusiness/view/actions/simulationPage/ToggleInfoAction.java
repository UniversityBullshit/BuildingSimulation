package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleInfoAction extends AbstractAction {
    private final SimulationViewModel model;
    public ToggleInfoAction(
        SimulationViewModel model
    ) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setShowInfo(!model.isShowInfo());
    }
}
