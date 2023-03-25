package com.universitybullshit.model;

import java.util.ArrayList;

public class CapitalBuilding extends Building {
    private static final long interval = 3000;
    private static final double probability = 0.7;
    private int x;
    private int y;

    public CapitalBuilding(int x, int y) {
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
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(this.x);
        coordinates.add(this.y);
        return coordinates;
    }
}
