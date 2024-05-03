package com.universitybusiness.model.simulation;

import com.universitybusiness.model.util.AtomicIdCounter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;

public abstract class Building extends BaseAI implements Comparable<Building>, Serializable {
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
    protected double x;

    /**
     * Y coordinate of object
     */
    @Getter
    @Setter
    protected double y;

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

    public Building(int x, int y, long time, Point finishPoint) {
        super(finishPoint);
        this.id = AtomicIdCounter.nextId();
        this.x = x;
        this.y = y;
        this.spawnTime = time;
    }

    @Override
    protected void move() {
        if ((Math.abs(x - finishPoint.getX()) > 0.5)
                && (Math.abs(y - finishPoint.getY()) > 0.5)) {
            double angle = Math.atan((Math.abs((finishPoint.y - y) / (finishPoint.x - x))));

            double moveX = ((double) speed) / multiplier / TIMER_TICK_VALUE * Math.cos(angle);
            moveX *= (x > finishPoint.getX()) ? -1 : 1;
            double moveY = ((double) speed) / multiplier / TIMER_TICK_VALUE * Math.sin(angle);
            moveY *= (y > finishPoint.getY()) ? -1 : 1;

            if (moveX < Math.abs(x - finishPoint.getX())) {
                x += moveX;
            } else {
                x = finishPoint.getX();
            }

            if (moveY < Math.abs(y - finishPoint.getY())) {
                y += moveY;
            } else {
                y = finishPoint.getY();
            }

        } else {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public int compareTo(Building building) {
        return Long.compare(this.id, building.id);
    }
}
