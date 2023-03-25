package com.universitybullshit.model;

import lombok.Getter;

import java.util.ArrayList;

public class WoodenBuilding extends Building {
    @Getter
    private long id;
    @Getter
    private static long interval;
    @Getter
    private static double probability;
    private int x;
    private int y;
    @Getter
    private long spawnTime;
    @Getter
    private static long lifeTime;

    public WoodenBuilding(int x, int y, long time) {
        this.x = x;
        this.y = y;
        this.spawnTime = time;
        this.id = AtomicIdCounter.nextId();
    }
    public static void SetDefaults(long interval, double probability, long lifeTime) {
        WoodenBuilding.interval = interval;
        WoodenBuilding.probability = probability;
        WoodenBuilding.lifeTime = lifeTime;
    }
    @Override
    public ArrayList<Integer> GetCoordinates() {
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(this.x);
        coordinates.add(this.y);
        return coordinates;
    }
}
