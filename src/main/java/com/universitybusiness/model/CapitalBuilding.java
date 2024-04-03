package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;

public class CapitalBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    private static long interval = Preferences.getCapitalBuildingInterval();
    @Getter
    private static double probability = 1.0 - Preferences.getCapitalBuildingProbability();
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private final long spawnTime;
    @Getter
    private static long lifeTime = Preferences.getCapitalBuildingLifeTime();

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
