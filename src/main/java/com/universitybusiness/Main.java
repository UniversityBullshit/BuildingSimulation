package com.universitybusiness;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.model.Preferences;
import com.universitybusiness.service.SimulationService;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;
import com.universitybusiness.view.viewModel.PreferencesViewModel;
import com.universitybusiness.view.viewModel.SimulationViewModel;
import com.universitybusiness.view.viewModel.TerminalViewModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Load preferences
        Preferences.getInstance().load();

        SimulationService simulation = new SimulationService(Habitat.getInstance());
        HabitatController controller = new HabitatController(simulation);

        ApplicationViewModelFactory modelFactory = new ApplicationViewModelFactory(
            new SimulationViewModel(controller),
            new PreferencesViewModel(Preferences.getInstance()),
            new TerminalViewModel()
        );

        WindowManager windowManager = new WindowManager(controller, modelFactory);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));

        // Save preferences on exit
        try {
            SwingUtilities.invokeAndWait(() -> {
                Preferences.getInstance().save();
            });
        } catch (Exception ignored) {}
    }
}
