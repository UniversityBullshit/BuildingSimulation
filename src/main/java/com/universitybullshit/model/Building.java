package com.universitybullshit.model;
import lombok.Getter;

public abstract class Building {
    @Getter
    private long id;
    @Getter
    private static long interval;
    @Getter
    private static double probability;
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private long spawnTime;
    @Getter
    private static long lifeTime;
}
