package com.universitybusiness;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.model.Preferences;
import com.universitybusiness.service.SimulationService;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;
import com.universitybusiness.view.viewModel.PreferencesViewModel;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Setup default preferences
        Preferences.getInstance().restoreDefaults();

        SimulationService simulation = new SimulationService(Habitat.getInstance());
        HabitatController controller = new HabitatController(simulation);

        ApplicationViewModelFactory modelFactory = new ApplicationViewModelFactory(
            new SimulationViewModel(controller),
            new PreferencesViewModel(Preferences.getInstance())
        );

        WindowManager windowManager = new WindowManager(controller, modelFactory);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
