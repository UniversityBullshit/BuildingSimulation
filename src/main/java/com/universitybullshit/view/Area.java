package com.universitybullshit.view;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.model.CapitalBuilding;
import com.universitybullshit.view.component.ImageFactory;
import com.universitybullshit.model.Building;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;


public class Area extends JPanel {
    private static final JFrame ctx = MainFrame.getCtx();
    private final int width;
    private final int height;
    private final JPanel root;
    private final ImageFactory imageFactory = new ImageFactory();
    private final HabitatController controller;
    @Setter
    private boolean isAreaUpdating = false;
//    private Vector<Building> buildingsCache = new Vector<>();

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
        while (isAreaUpdating) {
            spawnBuilding();
            this.updateUI();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void spawnBuilding() {
        Vector<Building> buildings = this.controller.getBuildings();
        System.out.println(buildings.size());
        for (Building building : buildings) {
            ArrayList<Integer> coords = building.getCoordinates();
            BuildingInstance buildingInstance = new BuildingInstance(building instanceof CapitalBuilding, coords.get(0), coords.get(1));
            this.add(buildingInstance);
            this.remove(buildingInstance);
        }
//        Vector<Building> buildings = this.controller.getBuildings();
//        if (this.buildingsCache.isEmpty() && !buildings.isEmpty()) {
//            this.buildingsCache = buildings;
//            for (Building building : this.buildingsCache) {
//                ArrayList<Integer> coords = building.getCoordinates();
//                BuildingInstance buildingInstance = new BuildingInstance(building instanceof CapitalBuilding,
//                        coords.get(0),
//                        coords.get(1));
//                this.add(buildingInstance);
//            }
//        } else {
//            System.out.printf("%d %d", buildings, buildingsCache);
//        }
    }
}
