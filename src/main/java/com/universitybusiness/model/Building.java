package com.universitybusiness.model;
import lombok.Getter;
import lombok.Setter;

public abstract class Building implements Comparable<Building> {
    /**
     * Object id
     */
    @Getter
    private long id;

    /**
     * Spawn interval
     */
    @Getter
    private static long interval;

    /**
     * Spawn chance
     */
    @Getter
    private static double probability;

    /**
     * X coordinate of object
     */
    @Getter
    @Setter
    private int x;

    /**
     * Y coordinate of object
     */
    @Getter
    @Setter
    private int y;

    /**
     * Creation time
     */
    @Getter
    private long spawnTime;

    /**
     * Member that stores time after which object is being deleted
     */
    @Getter
    private static long lifeTime;

    @Override
    public int compareTo(Building building) {
        return Long.compare(this.id, building.id);
    }
}
