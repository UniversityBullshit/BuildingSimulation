package com.universitybusiness.view.actions.preferences;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.common.BackToMenuAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RestoreDefaultsAction extends AbstractAction {
    private final BackToMenuAction backToMenuAction;

    public RestoreDefaultsAction(WindowManager windowManager) {
        backToMenuAction = new BackToMenuAction(windowManager);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Preferences.restoreDefaults();
        backToMenuAction.actionPerformed(e);
    }
}
