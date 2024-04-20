package com.universitybusiness.view.viewModel;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.Building;
import com.universitybusiness.view.util.BuildingInstance;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;


public class SimulationViewModel implements ViewModel {
    private final HabitatController controller;
    private final Timer timer;
    @Getter
    @Setter
    private int fps = 60;

    @Getter
    private boolean isAreaUpdating = false;
    @Getter
    private long simulationTime = 0;
    @Getter
    private boolean showTime = true;
    @Getter
    private boolean showInfo = true;
    @Getter
    private boolean woodenAI = false;
    @Getter
    private boolean capitalAI = false;
    @Getter
    private final HashMap<Long, BuildingInstance> buildingsDictionary;
    private final HashSet<ActionListener> updateListeners;

    public SimulationViewModel(HabitatController controller) {
        this.controller = controller;
        buildingsDictionary = new HashMap<>();
        timer = new Timer(
            1000 / fps,
            event -> SwingUtilities.invokeLater(this::update));
        timer.start();
        updateListeners = new HashSet<>();
    }

    public void addUpdateListener(ActionListener listener) {
        updateListeners.add(listener);
    }

    public void removeUpdateListener(ActionListener listener) {
        updateListeners.remove(listener);
    }

    private void setAreaUpdating(boolean status) {
        if (isAreaUpdating != status) {
            isAreaUpdating = status;
        }
    }

    private void setSimulationTime(long time) {
        if (simulationTime != time) {
            simulationTime = time;
        }
    }

    public void setShowTime(boolean status) {
        if (showTime != status) {
            showTime = status;
        }
    }

    public void setShowInfo(boolean status) {
        if (showInfo != status) {
            showInfo = status;
        }
    }

    public void setWoodenAI(boolean status) {
        if (woodenAI != status) {
            woodenAI = status;
        }
    }

    public void setCapitalAI(boolean status) {
        if (capitalAI != status) {
            capitalAI = status;
        }
    }

    private void update() {
        setAreaUpdating(controller.getSimulationStatus());
        setSimulationTime(controller.getSimulationTime());
        setWoodenAI(!controller.getIsWoodenBuildingAISleeping());
        setCapitalAI(!controller.getIsCapitalBuildingAISleeping());

        buildingsDictionary.clear();
        addInstances();

        for (ActionListener listener : updateListeners) {
            listener.actionPerformed(null);
        }
    }

    private void addInstances() {
        Vector<Building> actualBuildings = controller.getBuildings();

        for (Building building : actualBuildings) {
            buildingsDictionary.put(building.getId(), new BuildingInstance(building));
        }
    }
}
