package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoadDBMenuItemListener implements ActionListener {
    private final WindowManager context;

    public LoadDBMenuItemListener(WindowManager context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (context.getController().getSimulationStatus()) {
            context.getController().stopSimulation();
        }

        try {
            context.getDbController().loadFromDatabase();
        } catch (SQLException ex) {
            System.out.printf("Cannot load from db: %s", ex.getMessage());
        }

        context.getController().setSimulationService(Habitat.getInstance());
        context.swapPage(WindowManager.Pages.SIMULATION);
        context.getController().startSimulation();
    }
}
