package com.universitybusiness.view.fabrics;

import com.universitybusiness.view.viewModel.PreferencesViewModel;
import com.universitybusiness.view.viewModel.SimulationViewModel;
import lombok.Getter;

public class ApplicationViewModelFactory {
    @Getter
    private SimulationViewModel simulationViewModel;

    @Getter
    private PreferencesViewModel preferencesViewModel;

    public ApplicationViewModelFactory(
        SimulationViewModel simulationViewModel,
        PreferencesViewModel preferencesViewModel
    ) {
        this.simulationViewModel = simulationViewModel;
        this.preferencesViewModel = preferencesViewModel;
    }
}
