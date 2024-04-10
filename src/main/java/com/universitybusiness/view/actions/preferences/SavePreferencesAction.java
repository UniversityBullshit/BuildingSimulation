package com.universitybusiness.view.actions.preferences;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.common.SwapPageAction;
import com.universitybusiness.view.components.combobox.ComboBox;
import com.universitybusiness.view.components.textFilelds.HintTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;

public class SavePreferencesAction extends AbstractAction {
    private final WindowManager windowManager;
    private final SwapPageAction swapPageAction;

    public SavePreferencesAction(WindowManager windowManager) {
        this.windowManager = windowManager;
        swapPageAction = new SwapPageAction(windowManager, WindowManager.Pages.MAIN_MENU);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (windowManager.getViewModelFactory().getPreferencesViewModel().savePreferences()) {
            swapPageAction.actionPerformed(e);
        } else {
            showErrorMessage();
        }
    }

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(windowManager.getMainFrame(),
                new String[] {"Incorrect values:\n" +
                        "Spawn Interval: 500-10000(ms)\n" +
                        "Life Time: 1-1000(s)\n"+
                        "Movement Speed 1-100(pts/s)"});
    }
}
