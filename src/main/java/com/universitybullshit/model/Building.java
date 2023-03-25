package com.universitybullshit.model;
import lombok.Getter;

import java.lang.Integer;
import java.util.ArrayList;

public abstract class Building {
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

    public abstract ArrayList<Integer> GetCoordinates();
}
