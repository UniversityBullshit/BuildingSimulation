package com.universitybullshit.view.actions;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.Area;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.CompletableFuture;

public class StartKeyAction extends AbstractAction {
    private final HabitatController controller;
    private final Area area;

    public StartKeyAction(HabitatController controller, Area area) {
        this.controller = controller;
        this.area = area;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.StartSimulation();
        this.area.setAreaUpdating(true);
        CompletableFuture.runAsync(this.area::update);
    }
}

