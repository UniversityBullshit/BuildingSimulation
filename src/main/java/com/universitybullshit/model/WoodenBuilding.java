package com.universitybullshit.model;

import com.universitybullshit.model.util.BuildingDto;
import lombok.Getter;

public class WoodenBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    private static long interval = BuildingDto.getWoodenBuildingInterval();
    @Getter
    private static double probability = BuildingDto.getWoodenBuildingProbability();
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private final long spawnTime;
    @Getter
    private static long lifeTime = BuildingDto.getWoodenBuildingLifeTime();

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
