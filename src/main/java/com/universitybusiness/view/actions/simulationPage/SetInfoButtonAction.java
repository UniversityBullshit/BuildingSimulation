package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.components.controls.SwitchButton;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SetInfoButtonAction extends AbstractAction {
    private final SimulationViewModel model;
    private final SwitchButton button;

    public SetInfoButtonAction(
        SimulationViewModel model,
        SwitchButton button
    ) {
        this.model = model;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setActive(model.isShowInfo());
    }
}
