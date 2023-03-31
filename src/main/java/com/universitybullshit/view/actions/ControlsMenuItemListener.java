package com.universitybullshit.view.actions;

import com.universitybullshit.view.ControlsFrame;
import com.universitybullshit.view.HelpFrame;
import com.universitybullshit.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsMenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog controlsDialog = ControlsFrame.create(MainFrame.getCtx(), new String("Controls"));
        controlsDialog.setVisible(true);
    }
}
