package com.universitybullshit.model;

import com.universitybullshit.model.util.BuildingDto;
import lombok.Getter;

public class CapitalBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    private static long interval = BuildingDto.getCapitalBuildingInterval();
    @Getter
    private static double probability = BuildingDto.getCapitalBuildingProbability();
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private final long spawnTime;
    @Getter
    private static long lifeTime = BuildingDto.getCapitalBuildingLifeTime();

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
