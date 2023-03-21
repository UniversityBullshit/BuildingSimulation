package com.universitybullshit.model;

public abstract class Building {
    private long interval;
    private double probability;
    private int size;
    private int x;
    private int y;

    public abstract long GetInterval();
    public abstract double GetProbability();
    public abstract int GetSize();
}
