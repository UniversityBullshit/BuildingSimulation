package com.universitybusiness.model;

import java.awt.*;

public class WoodenBuilding extends Building {
    public WoodenBuilding(int x, int y, long time, Point finishPoint) {
        super(x, y, time, finishPoint);
        this.interval = Preferences.getInstance().getWoodenBuildingInterval();
        this.lifeTime = Preferences.getInstance().getWoodenBuildingLifeTime();
        this.probability = Preferences.getInstance().getWoodenBuildingProbability();
        this.speed = Preferences.getInstance().getWoodenBuildingSpeed();
    }

    @Override
    protected void updatePriority() {
        priority = Preferences.getInstance().getWoodenBuildingAIPriority();
    }
}
