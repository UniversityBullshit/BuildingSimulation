package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentObjectsButtonListener implements ActionListener {
    private final WindowManager context;

    public CurrentObjectsButtonListener(WindowManager context) { this.context = context; };

    @Override
    public void actionPerformed(ActionEvent e) { nextScreen(); }

    private void nextScreen() { context.showDialog(WindowManager.Pages.CURRENT_OBJECTS); }
}
