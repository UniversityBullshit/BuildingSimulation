package com.universitybullshit.view.actions;

import com.universitybullshit.view.SimulationWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowInfoAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        SimulationWindow.setShowInfoDialog(!SimulationWindow.isShowInfoDialog());
        System.out.println(SimulationWindow.isShowInfoDialog());
    }
}
