package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StopKeyAction extends AbstractAction {
    private final WindowManager windowManager;
    private final ShowInfoAction showInfoAction;

    public StopKeyAction(
        WindowManager windowManager
    ) {
       this.windowManager = windowManager;
       showInfoAction = new ShowInfoAction(windowManager);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        windowManager.getController().stopSimulation();
        if (windowManager.getViewModelFactory().getSimulationViewModel().isShowInfo()) {
            showInfoAction.actionPerformed(e);
        }
    }
}
