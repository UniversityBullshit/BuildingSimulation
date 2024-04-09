package com.universitybusiness.view.components.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.simulationPage.ToggleTimeAction;
import com.universitybusiness.view.actions.simulationPage.StartKeyAction;
import com.universitybusiness.view.actions.simulationPage.StopKeyAction;
import com.universitybusiness.view.util.Style;

import javax.swing.*;

public class SimulationMenuBar extends CustomMenuBar {

    public SimulationMenuBar(WindowManager context) {
        super(context);
        this.add(createActionsMenu());
    }

    private JMenu createActionsMenu() {
        JMenu actions = new JMenu("Actions");
        actions.setForeground(Style.getPrimaryLightColor());

        JMenuItem start = new JMenuItem("Start");
        JMenuItem stop = new JMenuItem("Stop");
        JMenuItem toggleTime = new JMenuItem("Show/Hide time");

        start.addActionListener(
            new StartKeyAction(
                context.getController()
            )
        );
        stop.addActionListener(
            new StopKeyAction(
                context
            )
        );
        toggleTime.addActionListener(
            new ToggleTimeAction(
                context.getViewModelFactory().getSimulationViewModel()
            )
        );

        actions.add(start);
        actions.add(stop);
        actions.add(toggleTime);

        return actions;
    }
}
