package com.universitybusiness.view.components.simulationView;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.util.BuildingInstance;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.model.Building;
import com.universitybusiness.view.util.BuildingDraw;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;


public class Area extends JPanel {
    private final HabitatController controller;
    @Getter
    @Setter
    private boolean showTime = true;
    @Getter
    @Setter
    private boolean showInfo = false;
    public final HashMap<Long, BuildingInstance> buildingsDictionary = new HashMap<>();
    private final Vector<Long> deletingBuildings = new Vector<>();
    private final Vector<Building> addingBuildings = new Vector<>();
    private final Timer timer;
    private final Integer woodenBuildingSide;
    private final Integer capitalBuildingSide;
    private final Image woodenBuildingImage;
    private final Image capitalBuildingImage;

    public Area(HabitatController controller) {
        this.controller = controller;
        this.setSize(new Dimension(
                this.controller.getContext().getWidth(),
                this.controller.getContext().getHeight()));

        this.woodenBuildingSide = BuildingDraw.getWoodenBuildingSide();
        this.capitalBuildingSide = BuildingDraw.getCapitalBuildingSide();

        this.woodenBuildingImage = WindowManager
                .getImageFactory()
                .getWoodenBuilding()
                .getScaledInstance(this.woodenBuildingSide, this.woodenBuildingSide, Image.SCALE_SMOOTH);

        this.capitalBuildingImage = WindowManager
                .getImageFactory()
                .getCapitalBuilding()
                .getScaledInstance(this.capitalBuildingSide, this.capitalBuildingSide, Image.SCALE_SMOOTH);

        // Create timer that allows async process of update each (1000 / 60)ms (60 fps)
        this.timer = new Timer(1000 / 60, event -> SwingUtilities.invokeLater(this::update));
    }

    public void reset() {
        buildingsDictionary.clear();
        if (!timer.isRunning()) {
            this.timer.start();
        }

        repaint();
    }

    private void update() {
        // Get actual info
        getDeletingInstances();
        getAddingInstances();

        // Accept changes
        removeInstances();
        addInstances();
        moveInstances();

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
                g2d.drawImage(
                        this.capitalBuildingImage,
                        buildingInstance.getX() - (this.capitalBuildingSide / 2),
                        buildingInstance.getY() - (this.capitalBuildingSide / 2),
                        this);
            } else if (buildingInstance.isWoodenBuilding()) {
                g2d.drawImage(
                        this.woodenBuildingImage,
                        buildingInstance.getX() - (this.woodenBuildingSide / 2),
                        buildingInstance.getY() - (this.woodenBuildingSide / 2),
                        this);
            }
        }

        if (showTime) {
            g2d.setColor(Color.BLACK);
            g2d.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 15));
            g2d.drawString("Time: " + Long.toString(controller.getSimulationTime()/1000) + "s", getWidth() - 100,30);
        }
    }
}
