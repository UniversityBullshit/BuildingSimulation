package com.universitybusiness.model.simulation;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class BaseAI implements Runnable {
    protected long speed;
    protected int priority = Thread.NORM_PRIORITY;
    protected long multiplier = 100000;
    protected boolean isMoving = true;
    protected Point finishPoint;
    protected final long TIMER_TICK_VALUE = 200;

    public BaseAI(Point finishPoint) {
        this.finishPoint = finishPoint;
    }

    protected abstract void move();

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    updatePriority();
                    Thread.currentThread().setPriority(priority);

                    while (!isMoving) {
                        this.wait();
                    }

                    move();
                }
            }

            Thread.sleep(TIMER_TICK_VALUE);
        } catch (Exception ignored) {}
    }

    protected abstract void updatePriority();

    public void stopMoving() {
        isMoving = false;
    }

    public void resumeMoving() {
        synchronized (this) {
            isMoving = true;
            this.notify();
        }
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean value) {
        if (isMoving != value) {
            isMoving = value;
        }
    }
}
