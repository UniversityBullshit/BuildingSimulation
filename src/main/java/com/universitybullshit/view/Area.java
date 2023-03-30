package com.universitybullshit.view;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.model.CapitalBuilding;
import com.universitybullshit.view.component.ImageFactory;
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
    private static final JFrame ctx = MainFrame.getCtx();
    private final int width;
    private final int height;
    private final JPanel root;
    private final ImageFactory imageFactory = new ImageFactory();
    private final HabitatController controller;
    @Getter
    @Setter
    private boolean isAreaUpdating = false;
    public final HashMap<Long, BuildingInstance> buildingsDictionary = new HashMap<>();
    private final Vector<Long> deletingBuildings = new Vector<>();
    private final Vector<Building> addingBuildings = new Vector<>();

    public Area(int width, int height, JPanel root, HabitatController controller) {
        this.width = width;
        this.height = height;
        this.root = root;
        this.controller = controller;
    }

    public void create() {
        this.root.setLayout(null);
        ctx.add(this.root, BorderLayout.CENTER);
        this.setSize(new Dimension(this.width, this.height));
        this.setBorder(BorderFactory.createTitledBorder("Area"));
        this.setLayout(null);
        this.root.add(this);
        this.root.updateUI();
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
        for (BuildingInstance buildingInstance : this.buildingsDictionary.values()) {
            if (buildingInstance.isCapitalBuilding()) {
                Integer side = BuildingDrawDto.getCapitalBuildingSide();
                g.setColor(BuildingDrawDto.getCapitalBuildingColor());
                g.fillRect(buildingInstance.getX(), buildingInstance.getY(), side, side);
            } else if (buildingInstance.isWoodenBuilding()) {
                Integer side = BuildingDrawDto.getWoodenBuildingSide();
                g.setColor(BuildingDrawDto.getWoodenBuildingColor());
                g.fillRect(buildingInstance.getX(), buildingInstance.getY(), side, side);
            }
        }
    }
}
