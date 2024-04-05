package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;

public class CapitalBuilding extends Building {
    @Getter
    private final long id;
    @Getter
    @Setter
    private static long interval;
    @Getter
    @Setter
    private static double probability;
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private final long spawnTime;
    @Getter
    @Setter
    private static long lifeTime;

    public CapitalBuilding(int x, int y, long time) {
        this.x = x;
        this.y = y;
        this.spawnTime = time;
        this.id = AtomicIdCounter.nextId();
    }
}
