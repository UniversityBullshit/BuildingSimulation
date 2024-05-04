package com.universitybusiness.view.components.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.mainMenu.LoadMenuItemListener;
import com.universitybusiness.view.actions.mainMenu.SaveMenuItemListener;
import com.universitybusiness.view.actions.simulationPage.*;
import com.universitybusiness.view.util.Style;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SimulationMenuBar extends CustomMenuBar {

    public SimulationMenuBar(WindowManager context) {
        super(context);
        this.add(createActionsMenu());
        this.add(createFileMenu());
    }

    private JMenu createActionsMenu() {
        JMenu actions = new JMenu("Actions");
        actions.setForeground(Style.getPrimaryLightColor());

        // Set up menu items
        JMenuItem terminal = new JMenuItem("Terminal");
        JMenuItem start = new JMenuItem("Start");
        JMenuItem stop = new JMenuItem("Stop");
        JMenuItem toggleTime = new JMenuItem("Show/Hide time");
        JMenuItem toggleWoodenAI = new JMenuItem("Start/Stop WoodenAI");
        JMenuItem toggleCapitalAI = new JMenuItem("Start/Stop CapitalAI");

        // Set up actions
        terminal.addActionListener(
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    context.swapPage(WindowManager.Pages.TERMINAL);
                }
            }
        );
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
        toggleWoodenAI.addActionListener(
            new SwitchWoodenAI(
                context.getController(),
                context.getViewModelFactory().getSimulationViewModel()
            )
        );
        toggleCapitalAI.addActionListener(
            new SwitchCapitalAI(
                context.getController(),
                context.getViewModelFactory().getSimulationViewModel()
            )
        );

        // Add menu items
        actions.add(terminal);
        actions.add(start);
        actions.add(stop);
        actions.add(toggleTime);
        actions.add(toggleWoodenAI);
        actions.add(toggleCapitalAI);

        return actions;
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");
        file.setForeground(Style.getPrimaryLightColor());

        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        load.addActionListener(new LoadMenuItemListener(context));
        save.addActionListener(new SaveMenuItemListener());

        file.add(load);
        file.add(save);

        return file;
    }
}
