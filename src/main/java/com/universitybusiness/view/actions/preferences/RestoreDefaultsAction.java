package com.universitybusiness.view.actions.preferences;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.common.SwapPageAction;
import com.universitybusiness.view.viewModel.PreferencesViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RestoreDefaultsAction extends AbstractAction {
    private final WindowManager windowManager;
    private final SwapPageAction backToMenuAction;

    public RestoreDefaultsAction(WindowManager windowManager) {
        this.windowManager = windowManager;
        backToMenuAction = new SwapPageAction(windowManager, WindowManager.Pages.MAIN_MENU);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        windowManager.getViewModelFactory().getPreferencesViewModel().restoreDefaults();
        backToMenuAction.actionPerformed(e);
    }
}
