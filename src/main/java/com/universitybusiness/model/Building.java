package com.universitybusiness.model;
import com.universitybusiness.model.util.AtomicIdCounter;
import lombok.Getter;
import lombok.Setter;

public abstract class Building implements Comparable<Building> {
    /**
     * Object id
     */
    @Getter
    protected long id;

    /**
     * Spawn interval
     */
    @Getter
    protected long interval;

    /**
     * Spawn chance
     */
    @Getter
    protected double probability;

    /**
     * X coordinate of object
     */
    @Getter
    @Setter
    protected int x;

    /**
     * Y coordinate of object
     */
    @Getter
    @Setter
    protected int y;

    /**
     * Creation time
     */
    @Getter
    protected long spawnTime;

    /**
     * Member that stores time after which object is being deleted
     */
    @Getter
    protected long lifeTime;

    Building(int x, int y, long time) {
        this.id = AtomicIdCounter.nextId();
        this.x = x;
        this.y = y;
        this.spawnTime = time;
    }

    @Override
    public int compareTo(Building building) {
        return Long.compare(this.id, building.id);
    }
}
