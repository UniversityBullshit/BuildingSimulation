package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;

public class CapitalBuilding extends Building {
    public CapitalBuilding(int x, int y, long time) {
        super(x, y, time);
        this.interval = Preferences.getInstance().getCapitalBuildingInterval();
        this.lifeTime = Preferences.getInstance().getCapitalBuildingLifeTime();
        this.probability = Preferences.getInstance().getCapitalBuildingProbability();
    }
}
