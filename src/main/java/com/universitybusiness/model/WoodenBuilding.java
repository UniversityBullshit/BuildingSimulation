package com.universitybusiness.model;

import com.universitybusiness.model.util.BuildingData;
import lombok.Getter;
import lombok.Setter;

public class WoodenBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    private static long interval = BuildingData.getWoodenBuildingInterval();
    @Getter
    private static double probability = BuildingData.getWoodenBuildingProbability();
    @Getter
    @Setter
    private int x;
    @Setter
    @Getter
    private int y;
    @Getter
    private final long spawnTime;
    @Getter
    private static long lifeTime = BuildingData.getWoodenBuildingLifeTime();

    public WoodenBuilding(int x, int y, long time) {
        this.x = x;
        this.y = y;
        this.spawnTime = time;
        this.id = AtomicIdCounter.nextId();
    }
    public static void setDefaults(long interval, double probability, long lifeTime) {
        WoodenBuilding.interval = interval;
        WoodenBuilding.probability = probability;
        WoodenBuilding.lifeTime = lifeTime;
    }
}
