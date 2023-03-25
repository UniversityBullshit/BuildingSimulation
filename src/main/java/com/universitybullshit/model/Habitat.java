package com.universitybullshit.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Random;
import java.util.Iterator;

public class Habitat {
    private final int width;
    private final int height;
    private long time;
    private long lastWoodenBuildingSpawnTime;
    private long lastCapitalBuildingSpawnTime;
    @Getter
    private final Vector<Building> buildings;
    @Getter
    private final HashSet<Long> ids;
    @Getter
    private final TreeMap<Long, Long> spawnTimeMap;
    @Getter
    private int woodenBuildingsCount;
    @Getter
    private int capitalBuildingsCount;
    public Habitat(int width, int height) {
        this.width = width;
        this.height = height;
        this.time = 0;
        this.lastWoodenBuildingSpawnTime = 0;
        this.lastCapitalBuildingSpawnTime = 0;
        this.buildings = new Vector<>();
        this.ids = new HashSet<>();
        this.spawnTimeMap = new TreeMap<>();
        this.woodenBuildingsCount = 0;
        this.capitalBuildingsCount = 0;
    }
    public void Update(long time) {
        this.time = time;
        DeleteExpiredObjects();
        SpawnCapitalBuilding();
        SpawnWoodenBuilding();
    }
    private void SpawnWoodenBuilding() {
        Random generator = new Random();

        double chance = generator.nextDouble();
        if (chance > WoodenBuilding.getProbability()) {
            if (this.time - this.lastWoodenBuildingSpawnTime >= WoodenBuilding.getInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                WoodenBuilding woodenBuilding = new WoodenBuilding(x, y, this.time);

                this.buildings.add(woodenBuilding);
                this.ids.add(woodenBuilding.getId());
                this.spawnTimeMap.put(woodenBuilding.getId(), this.time);
                this.woodenBuildingsCount++;
                this.lastWoodenBuildingSpawnTime = this.time;
            }
        }
    }
    private void SpawnCapitalBuilding() {
        Random generator = new Random();

        double chance = generator.nextDouble();
        if (chance > CapitalBuilding.getProbability()) {
            if (this.time - this.lastCapitalBuildingSpawnTime >= CapitalBuilding.getInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                CapitalBuilding capitalBuilding = new CapitalBuilding(x, y, this.time);

                this.buildings.add(capitalBuilding);
                this.ids.add(capitalBuilding.getId());
                this.spawnTimeMap.put(capitalBuilding.getId(), this.time);
                this.capitalBuildingsCount++;
                this.lastCapitalBuildingSpawnTime = this.time;
            }
        }
    }
    public void DeleteExpiredObjects() {
        for (Building building : this.buildings) {
            boolean shouldDelete = false;
            if (building instanceof WoodenBuilding) {
                if (this.time - building.getSpawnTime() >= WoodenBuilding.getLifeTime()) {
                    shouldDelete = true;
                }
            } else {
                if (this.time - building.getSpawnTime() >= CapitalBuilding.getLifeTime()) {
                    shouldDelete = true;
                }
            }
            if (shouldDelete) {
                RemoveObject(building);
            }
        }
    }
    private void RemoveObject(Building building) {
        this.ids.remove(building.getId());
        this.spawnTimeMap.remove(building.getId());
        this.buildings.remove(building);
    }
}
