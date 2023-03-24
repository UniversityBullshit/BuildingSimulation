package com.universitybullshit.view.actions;

import com.universitybullshit.view.AboutFrame;
import com.universitybullshit.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aboutDialog = AboutFrame.create(MainFrame.getCtx());
        aboutDialog.setVisible(true);
    }
}
