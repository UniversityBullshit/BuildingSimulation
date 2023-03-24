package com.universitybullshit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Habitat {
    private int width;
    private int height;
    private long time;
    private long lastWoodenBuildingSpawnTime;
    private long lastCapitalBuildingSpawnTime;
    private List<Building> buildings;
    private int woodenBuildingsCount;
    private int capitalBuildingsCount;
    public Habitat(int width, int height) {
        this.width = width;
        this.height = height;
        this.time = System.currentTimeMillis();
        this.lastWoodenBuildingSpawnTime = this.time;
        this.lastCapitalBuildingSpawnTime = this.time;
        this.buildings = new ArrayList<Building>();
        this.woodenBuildingsCount = 0;
        this.capitalBuildingsCount = 0;
    }
    public void Update(long time) {
        SpawnCapitalBuilding(time);
        SpawnWoodenBuilding(time);
        System.out.println(time);
        this.time = time;
    }
    private void SpawnWoodenBuilding(long time) {
        Random generator = new Random();

        double chance = generator.nextDouble();
        if (chance > WoodenBuilding.GetProbability()) {
            if (time - this.lastWoodenBuildingSpawnTime > WoodenBuilding.GetInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                WoodenBuilding woodenBuilding = new WoodenBuilding(x, y);

                System.out.println("Заспавнили вуден");

                this.buildings.add(woodenBuilding);
                this.woodenBuildingsCount++;
                this.lastWoodenBuildingSpawnTime = time;
            }
        }
    }
    private void SpawnCapitalBuilding(long time) {
        Random generator = new Random();

        double chance = generator.nextDouble();
        if (chance > CapitalBuilding.GetProbability()) {
            if (time - this.lastCapitalBuildingSpawnTime > CapitalBuilding.GetInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                CapitalBuilding capitalBuilding = new CapitalBuilding(x, y);

                System.out.println("Заспавнили капитал");

                this.buildings.add(capitalBuilding);
                this.capitalBuildingsCount++;
                this.lastCapitalBuildingSpawnTime = time;
            }
        }
    }
    public List<Building> GetBuildings() {
        return this.buildings;
    }
    public int GetWoodenBuildingsCount() {
        return this.woodenBuildingsCount;
    }
    public int GetCapitalBuildingsCount() {
        return this.capitalBuildingsCount;
    }
}
