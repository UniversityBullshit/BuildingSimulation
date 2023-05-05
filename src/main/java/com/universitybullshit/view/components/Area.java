package com.universitybullshit.view.components;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.util.BuildingInstance;
import com.universitybullshit.view.WindowManager;
import com.universitybullshit.model.Building;
import com.universitybullshit.view.util.BuildingDrawDto;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;


public class Area extends JPanel {
    private final HabitatController controller;
    @Getter
    @Setter
    private boolean isAreaUpdating = false;
    @Getter
    @Setter
    private boolean showTime = true;
    @Getter
    @Setter
    private boolean showInfo = false;
    public final HashMap<Long, BuildingInstance> buildingsDictionary = new HashMap<>();
    private final Vector<Long> deletingBuildings = new Vector<>();
    private final Vector<Building> addingBuildings = new Vector<>();

    public Area(HabitatController controller) {
        this.controller = controller;
        this.setSize(new Dimension(
                this.controller.getContext().getWidth(),
                this.controller.getContext().getHeight()));
    }

    public void update() {
        // Get actual info
        getDeletingInstances();
        getAddingInstances();

        // Accept changes
        removeInstances();
        addInstances();
        //moveInstances();

        // Delete temporary info
        this.deletingBuildings.clear();
        this.addingBuildings.clear();

        repaint();
    }

    private void getDeletingInstances() {
        HashSet<Long> actualBuildingsIds = this.controller.getIds();
        for (Long id : this.buildingsDictionary.keySet()) {
            if (!actualBuildingsIds.contains(id)) {
                this.deletingBuildings.add(id);
            }
        }
    }

    private void getAddingInstances() {
        Vector<Building> actualBuildings = this.controller.getBuildings();
        for (Building building : new CopyOnWriteArrayList<>(actualBuildings)) {
            if (!this.buildingsDictionary.containsKey(building.getId())) {
                this.addingBuildings.add(building);
            }
        }
    }

    private void removeInstances() {
        for (Long id : this.deletingBuildings) {
            this.buildingsDictionary.remove(id);
        }
    }

    private void addInstances() {
        for (Building building : this.addingBuildings) {
            this.buildingsDictionary.put(building.getId(), new BuildingInstance(building));
        }
    }

    private void moveInstances() {
        Vector<Building> actualBuildings = this.controller.getBuildings();
        for (Building building : new CopyOnWriteArrayList<>(actualBuildings)) {
            if (!this.addingBuildings.contains(building)) {
                Long id = building.getId();
                int currentX = this.buildingsDictionary.get(id).getX();
                int currentY = this.buildingsDictionary.get(id).getY();
                if (isDifferentCoordinates(currentX, currentY, building.getX(), building.getY())) {
                    this.buildingsDictionary.get(id).setX(currentX);
                    this.buildingsDictionary.get(id).setY(currentY);
                }
            }
        }
    }

    private boolean isDifferentCoordinates(int currentX, int currentY, int actualX, int actualY) {
        return currentX != actualX || currentY != actualY;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (BuildingInstance buildingInstance : this.buildingsDictionary.values()) {
            if (buildingInstance.isCapitalBuilding()) {
                Integer side = BuildingDrawDto.getCapitalBuildingSide();
                g2d.setColor(BuildingDrawDto.getCapitalBuildingColor());
                g2d.fillRect(buildingInstance.getX(), buildingInstance.getY(), side, side);
            } else if (buildingInstance.isWoodenBuilding()) {
                Integer side = BuildingDrawDto.getWoodenBuildingSide();
                g2d.setColor(BuildingDrawDto.getWoodenBuildingColor());
                g2d.fillRect(buildingInstance.getX(), buildingInstance.getY(), side, side);
            }
        }

        if (showTime) {
            g2d.setColor(Color.BLACK);
            g2d.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 15));
            g2d.drawString("Time: " + Long.toString(controller.getSimulationTime()/1000) + "s", getWidth() - 100,30);
        }
    }
}
