package com.universitybusiness.model.simulation.impl;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.model.simulation.Building;

import java.awt.*;

public class CapitalBuilding extends Building {
    public CapitalBuilding(int x, int y, long time, Point finishPoint) {
        super(x, y, time, finishPoint);
        this.interval = Preferences.getInstance().getCapitalBuildingInterval();
        this.lifeTime = Preferences.getInstance().getCapitalBuildingLifeTime();
        this.probability = Preferences.getInstance().getCapitalBuildingProbability();
        this.speed = Preferences.getInstance().getCapitalBuildingSpeed();
    }

    public CapitalBuilding(long id, double x, double y, Point finishPoint) {
        super(id, x, y, finishPoint);
        this.interval = Preferences.getInstance().getCapitalBuildingInterval();
        this.lifeTime = Preferences.getInstance().getCapitalBuildingLifeTime();
        this.probability = Preferences.getInstance().getCapitalBuildingProbability();
        this.speed = Preferences.getInstance().getCapitalBuildingSpeed();
    }

    @Override
    protected void updatePriority() {
        priority = Preferences.getInstance().getCapitalBuildingAIPriority();
    }
}
