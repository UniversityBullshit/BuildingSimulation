package com.universitybusiness.view.actions;

import com.universitybusiness.view.menubar.HelpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMenuItemListener implements ActionListener {
    private final JFrame frame;
    public AboutMenuItemListener(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aboutDialog = HelpFrame.create(frame, "About");
        aboutDialog.setVisible(true);
    }
}
