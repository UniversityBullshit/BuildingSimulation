package com.universitybusiness.view.fabrics;

import com.universitybusiness.view.viewModel.SimulationViewModel;
import lombok.Getter;

public class ApplicationViewModelFactory {
    @Getter
    private SimulationViewModel simulationViewModel;

    public ApplicationViewModelFactory(
            SimulationViewModel simulationViewModel
    ) {
        this.simulationViewModel = simulationViewModel;
    }
}
