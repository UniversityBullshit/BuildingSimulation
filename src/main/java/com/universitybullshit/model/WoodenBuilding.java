package com.universitybullshit.model;

import java.util.ArrayList;

public class WoodenBuilding extends Building {
    private static final long interval = 2000;
    private static final double probability = 0.3;
    private int x;
    private int y;

    public WoodenBuilding(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static long GetInterval() {
        return interval;
    }
    public static double GetProbability() {
        return probability;
    }
    @Override
    public ArrayList<Integer> GetCoordinates() {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        coordinates.add(this.x);
        coordinates.add(this.y);
        return coordinates;
    }
}
