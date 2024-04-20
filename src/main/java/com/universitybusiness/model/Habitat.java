package com.universitybusiness.model;

import lombok.Getter;

import java.awt.*;
import java.util.*;

public class Habitat implements IHabitat {
    public enum BuildingType {
        ANY,
        WOODEN,
        CAPITAL
    }

    private static Habitat instance;
    @Getter
    private int width;
    @Getter
    private int height;
    private long time;
    private long lastWoodenBuildingSpawnTime;
    private long lastCapitalBuildingSpawnTime;
    private Vector<Building> buildings;
    private HashMap<Long, Thread> threads;
    @Getter
    private HashSet<Long> ids;
    @Getter
    private TreeMap<Long, Long> spawnTimeMap;
    @Getter
    private int woodenBuildingsCount;
    @Getter
    private int capitalBuildingsCount;
    @Getter
    private boolean isWoodenBuildingAISleeping = false;
    @Getter
    private boolean isCapitalBuildingAISleeping = false;

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
        time = 0;
        lastWoodenBuildingSpawnTime = 0;
        lastCapitalBuildingSpawnTime = 0;
        buildings = new Vector<>();
        if (threads != null) {
            threads.forEach((key, thread) -> thread.interrupt());
            threads.clear();
        }
        threads = new HashMap<>();
        ids = new HashSet<>();
        spawnTimeMap = new TreeMap<>();
        woodenBuildingsCount = 0;
        capitalBuildingsCount = 0;
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public final synchronized Vector<Building> getBuildings() {
        return buildings;
    }

    public void sleepAI() {
        for (Building building : buildings) {
            building.stopMoving();
            isWoodenBuildingAISleeping = true;
            isCapitalBuildingAISleeping = true;
        }
    }

    public void sleepAI(BuildingType type) {
        for (Building building : buildings) {
            if (type == BuildingType.WOODEN) {
                if (building instanceof WoodenBuilding) {
                    building.stopMoving();
                    isWoodenBuildingAISleeping = true;
                }
            }

            if (type == BuildingType.CAPITAL) {
                if (building instanceof CapitalBuilding) {
                    building.stopMoving();
                    isCapitalBuildingAISleeping = true;
                }
            }
        }
    }

    public void resumeAI() {
        for (Building building : buildings) {
            building.resumeMoving();
            isWoodenBuildingAISleeping = false;
            isCapitalBuildingAISleeping = false;
        }
    }

    public void resumeAI(BuildingType type) {
        for (Building building : buildings) {
            if (type == BuildingType.WOODEN) {
                if (building instanceof WoodenBuilding) {
                    building.resumeMoving();
                    isWoodenBuildingAISleeping = false;
                }
            }

            if (type == BuildingType.CAPITAL) {
                if (building instanceof CapitalBuilding) {
                    building.resumeMoving();
                    isCapitalBuildingAISleeping = false;
                }
            }
        }
    }

    private void spawnWoodenBuilding() {
        Random generator = new Random();
        long currentTime = this.time;

        double chance = generator.nextDouble();
        if (chance > 1.0 - Preferences.getInstance().getWoodenBuildingProbability()) {
            if (currentTime - this.lastWoodenBuildingSpawnTime >= Preferences.getInstance().getWoodenBuildingInterval()) {
                int x = generator.nextInt(this.width - 10);
                int y = generator.nextInt(this.height - 10);
                int finishX = this.width / 2 + generator.nextInt(this.width / 2) - 10;
                int finishY = this.height / 2 + generator.nextInt(this.height / 2) - 10;

                WoodenBuilding woodenBuilding = new WoodenBuilding(x, y, currentTime, new Point(finishX, finishY));
                if (x < width / 2 || y < height / 2 ) {
                    Thread thread = new Thread(woodenBuilding);
                    thread.start();
                    threads.put(woodenBuilding.getId(), thread);
                }

                buildings.add(woodenBuilding);
                ids.add(woodenBuilding.getId());
                spawnTimeMap.put(woodenBuilding.getId(), currentTime);
                woodenBuildingsCount++;
                lastWoodenBuildingSpawnTime = currentTime;
            }
        }
    }

    private void spawnCapitalBuilding() {
        Random generator = new Random();
        long currentTime = this.time;

        double chance = generator.nextDouble();
        if (chance > 1.0 - Preferences.getInstance().getCapitalBuildingProbability()) {
            if (currentTime - this.lastCapitalBuildingSpawnTime >= Preferences.getInstance().getCapitalBuildingInterval()) {
                int x = generator.nextInt(this.width - 10);
                int y = generator.nextInt(this.height - 10);
                int finishX = generator.nextInt(this.width / 2);
                int finishY = generator.nextInt(this.height / 2);

                CapitalBuilding capitalBuilding = new CapitalBuilding(x, y, currentTime, new Point(finishX, finishY));
                if (x > width / 2 || y > height / 2) {
                    Thread thread = new Thread(capitalBuilding);
                    thread.start();
                    threads.put(capitalBuilding.getId(), thread);
                }

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
