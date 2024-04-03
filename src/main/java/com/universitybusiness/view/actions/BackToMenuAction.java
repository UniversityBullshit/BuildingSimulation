package com.universitybusiness.view.actions;

import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToMenuAction implements ActionListener {
    private final WindowManager context;

    public BackToMenuAction(WindowManager context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        context.swapPage(WindowManager.getMAIN_MENU_PAGE());
    }
}
