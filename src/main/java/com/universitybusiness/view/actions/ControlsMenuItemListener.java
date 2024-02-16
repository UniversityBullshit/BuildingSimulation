package com.universitybusiness.view.actions;

import com.universitybusiness.view.menubar.ControlsFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsMenuItemListener implements ActionListener {
    private final JFrame frame;
    public ControlsMenuItemListener(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog controlsDialog = ControlsFrame.create(frame, "Controls");
        controlsDialog.setVisible(true);
    }
}
