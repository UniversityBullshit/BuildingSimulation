package com.universitybusiness.view.actions.dialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CloseDialogAction extends AbstractAction {
    private final JDialog dialog;
    public CloseDialogAction(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }
}
