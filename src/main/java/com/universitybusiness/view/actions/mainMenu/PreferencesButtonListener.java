package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreferencesButtonListener implements ActionListener {
    private final WindowManager context;

    public PreferencesButtonListener(WindowManager context) {
        this.context = context;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        nextScreen();
    }

    private void nextScreen() {
        context.swapPage(WindowManager.getPREFERENCES_PAGE());
    }
}
