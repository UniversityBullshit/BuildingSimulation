package com.universitybusiness.view.fabrics;

import com.universitybusiness.view.viewModel.PreferencesViewModel;
import com.universitybusiness.view.viewModel.SimulationViewModel;
import com.universitybusiness.view.viewModel.TerminalViewModel;
import lombok.Getter;

public class ApplicationViewModelFactory {
    @Getter
    private final SimulationViewModel simulationViewModel;

    @Getter
    private final PreferencesViewModel preferencesViewModel;

    @Getter
    private final TerminalViewModel terminalViewModel;

    public ApplicationViewModelFactory(
        SimulationViewModel simulationViewModel,
        PreferencesViewModel preferencesViewModel,
        TerminalViewModel terminalViewModel
    ) {
        this.simulationViewModel = simulationViewModel;
        this.preferencesViewModel = preferencesViewModel;
        this.terminalViewModel = terminalViewModel;
    }
}
