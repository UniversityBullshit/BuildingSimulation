package com.universitybullshit.view.actions;

import com.universitybullshit.view.frames.ControlsFrame;
import com.universitybullshit.view.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsMenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog controlsDialog = ControlsFrame.create(MainMenu.getContext(), "Controls");
        controlsDialog.setVisible(true);
    }
}
