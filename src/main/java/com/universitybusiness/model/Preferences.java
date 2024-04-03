package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;

public class Preferences {
    private static final long DEFAULT_WOODEN_BUILDING_INTERVAL = 2000;
    private static final double DEFAULT_WOODEN_BUILDING_PROBABILITY = 0.7;
    private static final long DEFAULT_WOODEN_BUILDING_LIFE_TIME = 30000;
    private static final long DEFAULT_WOODEN_BUILDING_SPEED = 5;
    private static final long DEFAULT_CAPITAL_BUILDING_INTERVAL = 3000;
    private static final double DEFAULT_CAPITAL_BUILDING_PROBABILITY = 0.3;
    private static final long DEFAULT_CAPITAL_BUILDING_LIFE_TIME = 90000;
    private static final long DEFAULT_CAPITAL_BUILDING_SPEED = 5;

    @Getter
    @Setter
    private static long woodenBuildingInterval = DEFAULT_WOODEN_BUILDING_INTERVAL;
    @Getter
    @Setter
    private static double woodenBuildingProbability = DEFAULT_WOODEN_BUILDING_PROBABILITY;
    @Getter
    @Setter
    private static long woodenBuildingLifeTime = DEFAULT_WOODEN_BUILDING_LIFE_TIME;
    @Getter
    @Setter
    private static long woodenBuildingSpeed = DEFAULT_WOODEN_BUILDING_SPEED;
    @Getter
    @Setter
    private static long capitalBuildingInterval = DEFAULT_CAPITAL_BUILDING_INTERVAL;
    @Getter
    @Setter
    private static double capitalBuildingProbability = DEFAULT_CAPITAL_BUILDING_PROBABILITY;
    @Getter
    @Setter
    private static long capitalBuildingLifeTime = DEFAULT_CAPITAL_BUILDING_LIFE_TIME;
    @Getter
    @Setter
    private static long capitalBuildingSpeed = DEFAULT_CAPITAL_BUILDING_SPEED;

    public static void restoreDefaults() {
        woodenBuildingInterval = DEFAULT_WOODEN_BUILDING_INTERVAL;
        woodenBuildingProbability = DEFAULT_WOODEN_BUILDING_PROBABILITY;
        woodenBuildingLifeTime = DEFAULT_WOODEN_BUILDING_LIFE_TIME;
        woodenBuildingSpeed = DEFAULT_WOODEN_BUILDING_SPEED;
        capitalBuildingInterval = DEFAULT_CAPITAL_BUILDING_INTERVAL;
        capitalBuildingProbability = DEFAULT_CAPITAL_BUILDING_PROBABILITY;
        capitalBuildingLifeTime = DEFAULT_CAPITAL_BUILDING_LIFE_TIME;
        capitalBuildingSpeed = DEFAULT_CAPITAL_BUILDING_SPEED;
    }
}
