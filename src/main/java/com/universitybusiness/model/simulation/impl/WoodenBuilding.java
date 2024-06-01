package com.universitybusiness.model.simulation.impl;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.model.simulation.Building;

import java.awt.*;
import java.io.Serializable;

public class WoodenBuilding extends Building {
    public WoodenBuilding(int x, int y, long time, Point finishPoint) {
        super(x, y, time, finishPoint);
        this.interval = Preferences.getInstance().getWoodenBuildingInterval();
        this.lifeTime = Preferences.getInstance().getWoodenBuildingLifeTime();
        this.probability = Preferences.getInstance().getWoodenBuildingProbability();
        this.speed = Preferences.getInstance().getWoodenBuildingSpeed();
    }

    public WoodenBuilding(long id, double x, double y, Point finishPoint) {
        super(id, x, y,  finishPoint);
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
