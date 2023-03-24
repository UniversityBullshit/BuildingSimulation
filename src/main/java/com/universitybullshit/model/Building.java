package com.universitybullshit.model;
import java.lang.Integer;
import java.util.ArrayList;

public abstract class Building {
    private static long interval;
    private static double probability;
    private int x;
    private int y;

    public abstract ArrayList<Integer> GetCoordinates();
}
