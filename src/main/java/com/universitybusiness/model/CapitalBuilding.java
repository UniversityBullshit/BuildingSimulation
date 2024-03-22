package com.universitybusiness.model;

import com.universitybusiness.model.util.BuildingData;
import lombok.Getter;
import lombok.Setter;

public class CapitalBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    private static long interval = BuildingData.getCapitalBuildingInterval();
    @Getter
    private static double probability = BuildingData.getCapitalBuildingProbability();
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private final long spawnTime;
    @Getter
    private static long lifeTime = BuildingData.getCapitalBuildingLifeTime();

    public CapitalBuilding(int x, int y, long time) {
        this.x = x;
        this.y = y;
        this.spawnTime = time;
        this.id = AtomicIdCounter.nextId();
    }
    public static void setDefaults(long interval, double probability, long lifeTime) {
        CapitalBuilding.interval = interval;
        CapitalBuilding.probability = probability;
        CapitalBuilding.lifeTime = lifeTime;
    }
}
