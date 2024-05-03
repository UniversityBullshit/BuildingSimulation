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
    private long woodenBuildingInterval = Defaults.WOODEN_BUILDING_INTERVAL;
    @Getter
    private double woodenBuildingProbability = Defaults.WOODEN_BUILDING_PROBABILITY;
    @Getter
    private long woodenBuildingLifeTime = Defaults.WOODEN_BUILDING_LIFE_TIME;
    @Getter
    private long woodenBuildingSpeed = Defaults.WOODEN_BUILDING_SPEED;
    @Getter
    private long capitalBuildingInterval = Defaults.CAPITAL_BUILDING_INTERVAL;
    @Getter
    private double capitalBuildingProbability = Defaults.CAPITAL_BUILDING_PROBABILITY;
    @Getter
    private long capitalBuildingLifeTime = Defaults.CAPITAL_BUILDING_LIFE_TIME;
    @Getter
    private long capitalBuildingSpeed = Defaults.CAPITAL_BUILDING_SPEED;
    @Getter
    private int woodenBuildingAIPriority = Defaults.WOODEN_BUILDING_AI_PRIORITY;
    @Getter
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

    /**
     * Set wooden building interval
     * @param interval interval in milliseconds
     * @throws IllegalArgumentException if interval is not between 500 and 10000
     */
    public void setWoodenBuildingInterval(long interval) throws IllegalArgumentException {
        if (woodenBuildingInterval != interval) {
            if (interval < 500 || interval > 10000) {
                throw new IllegalArgumentException("Wooden building interval must be between 500 and 10000");
            }

            woodenBuildingInterval = interval;
        }
    }

    /**
     * Set capital building interval
     * @param interval interval in milliseconds
     * @throws IllegalArgumentException if interval is not between 500 and 10000
     */
    public void setCapitalBuildingInterval(long interval) throws IllegalArgumentException {
        if (capitalBuildingInterval != interval) {
            if (interval < 500 || interval > 10000) {
                throw new IllegalArgumentException("Capital building interval must be between 500 and 10000");
            }

            capitalBuildingInterval = interval;
        }
    }

    /**
     * Set wooden building probability
     * @param probability probability between 0 and 1
     * @throws IllegalArgumentException if probability is not between 0 and 1
     */
    public void setWoodenBuildingProbability(double probability) throws IllegalArgumentException {
        if (woodenBuildingProbability != probability) {
            if (probability < 0 || probability > 1) {
                throw new IllegalArgumentException("Wooden building probability must be between 0 and 1");
            }

            woodenBuildingProbability = probability;
        }
    }

    /**
     * Set capital building probability
     * @param probability probability between 0 and 1
     * @throws IllegalArgumentException if probability is not between 0 and 1
     */
    public void setCapitalBuildingProbability(double probability) throws IllegalArgumentException {
        if (capitalBuildingProbability != probability) {
            if (probability < 0 || probability > 1) {
                throw new IllegalArgumentException("Capital building probability must be between 0 and 1");
            }

            capitalBuildingProbability = probability;
        }
    }

    /**
     * Set wooden building lifetime
     * @param lifeTime lifetime in milliseconds
     * @throws IllegalArgumentException if lifetime is not between 1 and 1000
     */
    public void setWoodenBuildingLifeTime(long lifeTime) throws IllegalArgumentException {
        if (woodenBuildingLifeTime != lifeTime) {
            if (lifeTime < 1 || lifeTime > 1000) {
                throw new IllegalArgumentException("Wooden building lifetime must be between 1 and 1000");
            }

            woodenBuildingLifeTime = lifeTime;
        }
    }

    /**
     * Set capital building lifetime
     * @param lifeTime lifetime in milliseconds
     * @throws IllegalArgumentException if lifetime is not between 1 and 1000
     */
    public void setCapitalBuildingLifeTime(long lifeTime) throws IllegalArgumentException {
        if (capitalBuildingLifeTime != lifeTime) {
            if (lifeTime < 1 || lifeTime > 1000) {
                throw new IllegalArgumentException("Capital building lifetime must be between 1 and 1000");
            }

            capitalBuildingLifeTime = lifeTime;
        }
    }

    /**
     * Set wooden building speed
     * @param speed speed between 1 and 100
     * @throws IllegalArgumentException if speed is not between 1 and 100
     */
    public void setWoodenBuildingSpeed(long speed) throws IllegalArgumentException {
        if (woodenBuildingSpeed != speed) {
            if (speed < 1 || speed > 100) {
                throw new IllegalArgumentException("Wooden building speed must be between 1 and 100");
            }

            woodenBuildingSpeed = speed;
        }
    }

    /**
     * Set capital building speed
     * @param speed speed between 1 and 100
     * @throws IllegalArgumentException if speed is not between 1 and 100
     */
    public void setCapitalBuildingSpeed(long speed) throws IllegalArgumentException {
        if (capitalBuildingSpeed != speed) {
            if (speed < 1 || speed > 100) {
                throw new IllegalArgumentException("Capital building speed must be between 1 and 100");
            }

            capitalBuildingSpeed = speed;
        }
    }

    /**
     * Set wooden building AI priority
      * @param priority priority between Thread.MIN_PRIORITY and Thread.MAX_PRIORITY
     * @throws IllegalArgumentException if priority is not between Thread.MIN_PRIORITY and Thread.MAX_PRIORITY
     */
    public void setWoodenBuildingAIPriority(int priority) throws IllegalArgumentException {
        if (woodenBuildingAIPriority != priority) {
            if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
                throw new IllegalArgumentException("Wooden building AI priority must be between " + Thread.MIN_PRIORITY + " and " + Thread.MAX_PRIORITY);
            }

            woodenBuildingAIPriority = priority;
        }
    }

    /**
     * Set capital building AI priority
     * @param priority priority between Thread.MIN_PRIORITY and Thread.MAX_PRIORITY
     * @throws IllegalArgumentException if priority is not between Thread.MIN_PRIORITY and Thread.MAX_PRIORITY
     */
    public void setCapitalBuildingAIPriority(int priority) throws IllegalArgumentException {
        if (capitalBuildingAIPriority != priority) {
            if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
                throw new IllegalArgumentException("Capital building AI priority must be between " + Thread.MIN_PRIORITY + " and " + Thread.MAX_PRIORITY);
            }

            capitalBuildingAIPriority = priority;
        }
    }
}
