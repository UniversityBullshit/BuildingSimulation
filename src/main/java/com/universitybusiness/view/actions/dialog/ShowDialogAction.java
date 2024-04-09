package com.universitybusiness.view.actions.dialog;

import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowDialogAction extends AbstractAction {
    private final WindowManager context;
    private final String pageName;
    public ShowDialogAction(
        WindowManager context,
        String pageName
    ) {
        this.context = context;
        this.pageName = pageName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        context.showDialog(pageName);
    }
}
