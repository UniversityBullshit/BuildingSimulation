package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.Habitat;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchCapitalAI extends AbstractAction {
    private final HabitatController controller;
    private final SimulationViewModel model;

    public SwitchCapitalAI(HabitatController controller, SimulationViewModel model) {
        this.controller = controller;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.isCapitalAI()) {
            controller.getSimulationService().sleepAI(
                Habitat.BuildingType.CAPITAL
            );
        } else {
            controller.getSimulationService().resumeAI(
                Habitat.BuildingType.CAPITAL
            );
        }
    }
}
