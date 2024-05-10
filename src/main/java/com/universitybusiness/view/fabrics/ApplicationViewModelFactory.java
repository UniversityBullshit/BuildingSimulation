package com.universitybusiness.view.fabrics;

import com.universitybusiness.view.viewModel.PreferencesViewModel;
import com.universitybusiness.view.viewModel.SimulationViewModel;
import com.universitybusiness.view.viewModel.TerminalViewModel;
import com.universitybusiness.view.viewModel.UsersViewModel;
import lombok.Getter;

public class ApplicationViewModelFactory {
    @Getter
    private final SimulationViewModel simulationViewModel;

    @Getter
    private final PreferencesViewModel preferencesViewModel;

    @Getter
    private final TerminalViewModel terminalViewModel;

    @Getter
    private final UsersViewModel usersViewModel;

    public ApplicationViewModelFactory(
        SimulationViewModel simulationViewModel,
        PreferencesViewModel preferencesViewModel,
        TerminalViewModel terminalViewModel,
        UsersViewModel usersViewModel
    ) {
        this.simulationViewModel = simulationViewModel;
        this.preferencesViewModel = preferencesViewModel;
        this.terminalViewModel = terminalViewModel;
        this.usersViewModel = usersViewModel;
    }
}
