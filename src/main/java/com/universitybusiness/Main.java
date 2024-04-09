package com.universitybusiness;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.Habitat;
import com.universitybusiness.model.Preferences;
import com.universitybusiness.service.SimulationService;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Setup default preferences
        Preferences.getInstance().restoreDefaults();

        SimulationService simulation = new SimulationService(Habitat.getInstance());
        HabitatController controller = new HabitatController(simulation);

        ApplicationViewModelFactory factory = new ApplicationViewModelFactory(
            new SimulationViewModel(controller)
        );

        WindowManager windowManager = new WindowManager(controller, factory);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
