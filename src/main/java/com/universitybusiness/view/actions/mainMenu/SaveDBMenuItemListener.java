package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SaveDBMenuItemListener implements ActionListener {
    private final WindowManager context;

    public SaveDBMenuItemListener(WindowManager context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (context.getController().getSimulationStatus()) {
            context.getController().stopSimulation();
        }

        try {
            context.getDbController().saveToDatabase();
        } catch (SQLException ex) {
            System.out.println("Cannot save to db: " + ex.getMessage());
        }

        context.getController().startSimulation();
    }
}
