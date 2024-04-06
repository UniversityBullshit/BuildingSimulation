package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;


public class Preferences {
    public static class Defaults {
        public static final long WOODEN_BUILDING_INTERVAL = 2000;
        public static final double WOODEN_BUILDING_PROBABILITY = 0.7;
        public static final long WOODEN_BUILDING_LIFE_TIME = 30000;
        public static final long WOODEN_BUILDING_SPEED = 5;
        public static final long CAPITAL_BUILDING_INTERVAL = 3000;
        public static final double CAPITAL_BUILDING_PROBABILITY = 0.3;
        public static final long CAPITAL_BUILDING_LIFE_TIME = 90000;
        public static final long CAPITAL_BUILDING_SPEED = 5;
    }

    private static Preferences instance;

    @Getter
    @Setter
    private long woodenBuildingInterval = Defaults.WOODEN_BUILDING_INTERVAL;
    @Getter
    @Setter
    private double woodenBuildingProbability = Defaults.WOODEN_BUILDING_PROBABILITY;
    @Getter
    @Setter
    private long woodenBuildingLifeTime = Defaults.WOODEN_BUILDING_LIFE_TIME;
    @Getter
    @Setter
    private long woodenBuildingSpeed = Defaults.WOODEN_BUILDING_SPEED;
    @Getter
    @Setter
    private long capitalBuildingInterval = Defaults.CAPITAL_BUILDING_INTERVAL;
    @Getter
    @Setter
    private double capitalBuildingProbability = Defaults.CAPITAL_BUILDING_PROBABILITY;
    @Getter
    @Setter
    private long capitalBuildingLifeTime = Defaults.CAPITAL_BUILDING_LIFE_TIME;
    @Getter
    @Setter
    private long capitalBuildingSpeed = Defaults.CAPITAL_BUILDING_SPEED;

    private Preferences() {
        restoreDefaults();
    }

    public static Preferences getInstance() {
        if (instance == null) {
            instance = new Preferences();
        }

        return instance;
    }

    public void restoreDefaults() {
        setWoodenBuildingInterval(Defaults.WOODEN_BUILDING_INTERVAL);
        setWoodenBuildingProbability(Defaults.WOODEN_BUILDING_PROBABILITY);
        setWoodenBuildingLifeTime(Defaults.WOODEN_BUILDING_LIFE_TIME);
        setWoodenBuildingSpeed(Defaults.WOODEN_BUILDING_SPEED);
        setCapitalBuildingInterval(Defaults.CAPITAL_BUILDING_INTERVAL);
        setCapitalBuildingProbability(Defaults.CAPITAL_BUILDING_PROBABILITY);
        setCapitalBuildingLifeTime(Defaults.CAPITAL_BUILDING_LIFE_TIME);
        setCapitalBuildingSpeed(Defaults.CAPITAL_BUILDING_SPEED);
    }
}
