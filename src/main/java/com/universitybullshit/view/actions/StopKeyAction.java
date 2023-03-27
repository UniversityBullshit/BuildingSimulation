package com.universitybullshit.view.actions;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.Area;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StopKeyAction extends AbstractAction {
    private final HabitatController controller;
    private final Area area;

    public StopKeyAction(HabitatController controller, Area area) {
        this.controller = controller;
        this.area = area;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.StopSimulation();
        this.area.setAreaUpdating(false);
    }
}
