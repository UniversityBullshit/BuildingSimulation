package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;

public class Preferences {
    public static final long DEFAULT_WOODEN_BUILDING_INTERVAL = 2000;
    public static final double DEFAULT_WOODEN_BUILDING_PROBABILITY = 0.7;
    public static final long DEFAULT_WOODEN_BUILDING_LIFE_TIME = 30000;
    public static final long DEFAULT_WOODEN_BUILDING_SPEED = 5;
    public static final long DEFAULT_CAPITAL_BUILDING_INTERVAL = 3000;
    public static final double DEFAULT_CAPITAL_BUILDING_PROBABILITY = 0.3;
    public static final long DEFAULT_CAPITAL_BUILDING_LIFE_TIME = 90000;
    public static final long DEFAULT_CAPITAL_BUILDING_SPEED = 5;

    @Getter
    private static long woodenBuildingInterval = DEFAULT_WOODEN_BUILDING_INTERVAL;
    @Getter
    private static double woodenBuildingProbability = DEFAULT_WOODEN_BUILDING_PROBABILITY;
    @Getter
    private static long woodenBuildingLifeTime = DEFAULT_WOODEN_BUILDING_LIFE_TIME;
    @Getter
    private static long woodenBuildingSpeed = DEFAULT_WOODEN_BUILDING_SPEED;
    @Getter
    private static long capitalBuildingInterval = DEFAULT_CAPITAL_BUILDING_INTERVAL;
    @Getter
    private static double capitalBuildingProbability = DEFAULT_CAPITAL_BUILDING_PROBABILITY;
    @Getter
    private static long capitalBuildingLifeTime = DEFAULT_CAPITAL_BUILDING_LIFE_TIME;
    @Getter
    private static long capitalBuildingSpeed = DEFAULT_CAPITAL_BUILDING_SPEED;

    public static void restoreDefaults() {
        setWoodenBuildingInterval(DEFAULT_WOODEN_BUILDING_INTERVAL);
        setWoodenBuildingProbability(DEFAULT_WOODEN_BUILDING_PROBABILITY);
        setWoodenBuildingLifeTime(DEFAULT_WOODEN_BUILDING_LIFE_TIME);
        setWoodenBuildingSpeed(DEFAULT_WOODEN_BUILDING_SPEED);
        setCapitalBuildingInterval(DEFAULT_CAPITAL_BUILDING_INTERVAL);
        setCapitalBuildingProbability(DEFAULT_CAPITAL_BUILDING_PROBABILITY);
        setCapitalBuildingLifeTime(DEFAULT_CAPITAL_BUILDING_LIFE_TIME);
        setCapitalBuildingSpeed(DEFAULT_CAPITAL_BUILDING_SPEED);
    }

    public static void setWoodenBuildingInterval(long value) {
        woodenBuildingInterval = value;
        WoodenBuilding.setInterval(woodenBuildingInterval);
    }

    public static void setCapitalBuildingInterval(long value) {
        capitalBuildingInterval = value;
        CapitalBuilding.setInterval(capitalBuildingInterval);
    }

    public static void setWoodenBuildingLifeTime(long value) {
        woodenBuildingLifeTime = value;
        WoodenBuilding.setLifeTime(woodenBuildingLifeTime);
    }

    public static void setCapitalBuildingLifeTime(long value) {
        capitalBuildingLifeTime = value;
        CapitalBuilding.setLifeTime(capitalBuildingLifeTime);
    }

    public static void setWoodenBuildingProbability(double value) {
        woodenBuildingProbability = value;
        WoodenBuilding.setProbability(woodenBuildingProbability);
    }

    public static void setCapitalBuildingProbability(double value) {
        capitalBuildingProbability = value;
        CapitalBuilding.setProbability(capitalBuildingProbability);
    }

    public static void setWoodenBuildingSpeed(long value) {
        woodenBuildingSpeed = value;
    }

    public static void setCapitalBuildingSpeed(long value) {
        capitalBuildingSpeed = value;
    }
}
