package com.universitybusiness.model;
import lombok.Getter;
import lombok.Setter;

public abstract class Building {
    @Getter
    private long id;
    @Getter
    private static long interval;
    @Getter
    private static double probability;
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private long spawnTime;
    @Getter
    private static long lifeTime;
}
