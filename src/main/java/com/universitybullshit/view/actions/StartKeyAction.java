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
        this.controller.startSimulation();
        this.area.setAreaUpdating(true);
        CompletableFuture.runAsync(this::areaUpdating);
    }

    private void areaUpdating() {
        while (this.area.isAreaUpdating()) {
            this.area.update();
            this.area.updateUI();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

