package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;


public class Preferences {
    public static class Defaults {
        public static final long WOODEN_BUILDING_INTERVAL = 2000;
        public static final double WOODEN_BUILDING_PROBABILITY = 0.7;
        public static final long WOODEN_BUILDING_LIFE_TIME = 30000;
        public static final long WOODEN_BUILDING_SPEED = 50;
        public static final long CAPITAL_BUILDING_INTERVAL = 3000;
        public static final double CAPITAL_BUILDING_PROBABILITY = 0.3;
        public static final long CAPITAL_BUILDING_LIFE_TIME = 90000;
        public static final long CAPITAL_BUILDING_SPEED = 50;
        public static final int WOODEN_BUILDING_AI_PRIORITY = Thread.NORM_PRIORITY;
        public static final int CAPITAL_BUILDING_AI_PRIORITY = Thread.NORM_PRIORITY;
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
    @Getter
    @Setter
    private int woodenBuildingAIPriority = Defaults.WOODEN_BUILDING_AI_PRIORITY;
    @Getter
    @Setter
    private int capitalBuildingAIPriority = Defaults.CAPITAL_BUILDING_AI_PRIORITY;

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
        setWoodenBuildingAIPriority(Defaults.WOODEN_BUILDING_AI_PRIORITY);
        setCapitalBuildingAIPriority(Defaults.CAPITAL_BUILDING_AI_PRIORITY);
    }
}
