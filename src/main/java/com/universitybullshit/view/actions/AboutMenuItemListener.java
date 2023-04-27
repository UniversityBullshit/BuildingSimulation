package com.universitybullshit.view.actions;

import com.universitybullshit.view.frames.HelpFrame;
import com.universitybullshit.view.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aboutDialog = HelpFrame.create(MainMenu.getContext(), "About");
        aboutDialog.setVisible(true);
    }
}
