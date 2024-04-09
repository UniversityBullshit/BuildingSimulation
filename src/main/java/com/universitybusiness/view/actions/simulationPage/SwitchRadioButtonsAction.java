package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.components.controls.RadioButton;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchRadioButtonsAction extends AbstractAction {
    private final SimulationViewModel model;
    private final RadioButton firstOption;
    private final RadioButton secondOption;

    public SwitchRadioButtonsAction(
        SimulationViewModel model,
        RadioButton firstOption,
        RadioButton secondOption
    ) {
        this.model = model;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.isShowTime()) {
            firstOption.doClick();
        } else {
            secondOption.doClick();
        }
    }
}
