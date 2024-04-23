package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.BuildingType;
import com.universitybusiness.model.Habitat;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchWoodenAI extends AbstractAction {
    private final HabitatController controller;
    private final SimulationViewModel model;

    public SwitchWoodenAI(HabitatController controller, SimulationViewModel model) {
        this.controller = controller;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.isWoodenAI()) {
            controller.getSimulationService().sleepAI(
                BuildingType.WOODEN
            );
        } else {
            controller.getSimulationService().resumeAI(
                BuildingType.WOODEN
            );
        }
    }
}
