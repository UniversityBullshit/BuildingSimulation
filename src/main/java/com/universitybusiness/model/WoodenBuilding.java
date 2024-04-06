package com.universitybusiness.model;

public class WoodenBuilding extends Building {
    public WoodenBuilding(int x, int y, long time) {
        super(x, y, time);
        this.interval = Preferences.getInstance().getWoodenBuildingInterval();
        this.lifeTime = Preferences.getInstance().getWoodenBuildingLifeTime();
        this.probability = Preferences.getInstance().getWoodenBuildingProbability();
    }
}
