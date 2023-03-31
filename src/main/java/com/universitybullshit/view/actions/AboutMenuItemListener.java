package com.universitybullshit.view.actions;

import com.universitybullshit.view.HelpFrame;
import com.universitybullshit.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aboutDialog = HelpFrame.create(MainFrame.getCtx(), new String("About"));
        aboutDialog.setVisible(true);
    }
}
