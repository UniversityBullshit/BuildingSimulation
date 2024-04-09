package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.dialog.ShowDialogAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowInfoAction extends AbstractAction {
    private final ShowDialogAction showDialogAction;

    public ShowInfoAction(
        WindowManager windowManager
    ) {
        showDialogAction = new ShowDialogAction(windowManager, WindowManager.Pages.INFORMATION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showDialogAction.actionPerformed(e);
    }
}
