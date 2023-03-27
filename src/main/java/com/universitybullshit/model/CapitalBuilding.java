package com.universitybullshit.model;

import com.universitybullshit.model.util.BuildingDto;
import lombok.Getter;

import java.util.ArrayList;

public class CapitalBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    private static long interval = BuildingDto.getCapitalBuildingInterval();
    @Getter
    private static double probability = BuildingDto.getCapitalBuildingProbability();
    private int x;
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
    public static void SetDefaults(long interval, double probability, long lifeTime) {
        CapitalBuilding.interval = interval;
        CapitalBuilding.probability = probability;
        CapitalBuilding.lifeTime = lifeTime;
    }
    @Override
    public ArrayList<Integer> GetCoordinates() {
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(this.x);
        coordinates.add(this.y);
        return coordinates;
    }
}
