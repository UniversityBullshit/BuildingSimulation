package com.universitybusiness.view.actions;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.components.Area;

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
        startUpdating();
    }

    private void startUpdating() {
        this.controller.startSimulation();
        if (!this.area.isAreaUpdating()) {
            CompletableFuture.runAsync(this::areaUpdating);
        }
        this.area.setAreaUpdating(true);
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

            if (Thread.currentThread().isInterrupted()) {
                startUpdating();
            }
        }
    }
}