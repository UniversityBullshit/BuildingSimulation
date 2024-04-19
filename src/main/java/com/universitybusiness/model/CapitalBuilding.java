package com.universitybusiness.model;

import java.awt.*;

public class CapitalBuilding extends Building {
    public CapitalBuilding(int x, int y, long time, Point finishPoint) {
        super(x, y, time, finishPoint);
        this.interval = Preferences.getInstance().getCapitalBuildingInterval();
        this.lifeTime = Preferences.getInstance().getCapitalBuildingLifeTime();
        this.probability = Preferences.getInstance().getCapitalBuildingProbability();
        this.speed = Preferences.getInstance().getCapitalBuildingSpeed();
    }
}
