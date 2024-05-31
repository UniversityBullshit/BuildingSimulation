package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        context.getDbController().saveToDatabase();
    }
}
