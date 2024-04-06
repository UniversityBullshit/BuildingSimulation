package com.universitybusiness.model;

import lombok.Getter;

import java.util.*;

public class Habitat implements IHabitat {
    private static Habitat instance;
    @Getter
    private int width;
    @Getter
    private int height;
    private long time;
    private long lastWoodenBuildingSpawnTime;
    private long lastCapitalBuildingSpawnTime;
    @Getter
    private Vector<Building> buildings;
    @Getter
    private HashSet<Long> ids;
    @Getter
    private TreeMap<Long, Long> spawnTimeMap;
    @Getter
    private int woodenBuildingsCount;
    @Getter
    private int capitalBuildingsCount;

    private Habitat() {
        reset();
    }

    public static Habitat getInstance() {
        if (instance == null) {
            instance = new Habitat();
        }

        return instance;
    }

    @Override
    public void update(long time) {
        this.time = time;
        removeExpiredObjects(findExpiredObjects());
        spawnCapitalBuilding();
        spawnWoodenBuilding();
    }

    @Override
    public void reset() {
        this.time = 0;
        this.lastWoodenBuildingSpawnTime = 0;
        this.lastCapitalBuildingSpawnTime = 0;
        this.buildings = new Vector<>();
        this.ids = new HashSet<>();
        this.spawnTimeMap = new TreeMap<>();
        this.woodenBuildingsCount = 0;
        this.capitalBuildingsCount = 0;
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void spawnWoodenBuilding() {
        Random generator = new Random();
        long currentTime = this.time;

        double chance = generator.nextDouble();
        if (chance > 1.0 - Preferences.getInstance().getWoodenBuildingProbability()) {
            if (currentTime - this.lastWoodenBuildingSpawnTime >= Preferences.getInstance().getWoodenBuildingInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                WoodenBuilding woodenBuilding = new WoodenBuilding(x, y, currentTime);

                this.buildings.add(woodenBuilding);
                this.ids.add(woodenBuilding.getId());
                this.spawnTimeMap.put(woodenBuilding.getId(), currentTime);
                this.woodenBuildingsCount++;
                this.lastWoodenBuildingSpawnTime = currentTime;
            }
        }
    }

    private void spawnCapitalBuilding() {
        Random generator = new Random();
        long currentTime = this.time;

        double chance = generator.nextDouble();
        if (chance > 1.0 - Preferences.getInstance().getCapitalBuildingProbability()) {
            if (currentTime - this.lastCapitalBuildingSpawnTime >= Preferences.getInstance().getCapitalBuildingInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                CapitalBuilding capitalBuilding = new CapitalBuilding(x, y, currentTime);

                buildings.add(capitalBuilding);
                ids.add(capitalBuilding.getId());
                spawnTimeMap.put(capitalBuilding.getId(), currentTime);
                capitalBuildingsCount++;
                lastCapitalBuildingSpawnTime = currentTime;
            }
        }
    }

    private Vector<Building> findExpiredObjects() {
        Vector<Building> expired = new Vector<>();
        long currentTime = this.time;

        for (Building building : buildings) {
            if (building instanceof WoodenBuilding) {
                if (currentTime - building.getSpawnTime() >= Preferences.getInstance().getWoodenBuildingLifeTime()) {
                    expired.add(building);
                }
            } else if (building instanceof CapitalBuilding) {
                if (currentTime - building.getSpawnTime() >= Preferences.getInstance().getCapitalBuildingLifeTime()) {
                    expired.add(building);
                }
            }
        }

        return expired;
    }
    private void removeExpiredObjects(Vector<Building> expired) {
        for (Building building : expired) {
            ids.remove(building.getId());
            spawnTimeMap.remove(building.getId());
            buildings.remove(building);

            if (building instanceof WoodenBuilding) {
                woodenBuildingsCount--;
            } else if (building instanceof CapitalBuilding) {
                capitalBuildingsCount--;
            }
        }
    }
}
