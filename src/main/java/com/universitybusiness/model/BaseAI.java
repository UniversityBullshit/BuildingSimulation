package com.universitybusiness.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class BaseAI implements Runnable {
    protected long speed;
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
                    while (!isMoving) {
                        this.wait();
                    }

                    move();
                }
            }

            Thread.sleep(TIMER_TICK_VALUE);
        } catch (Exception ignored) {}
    }

    public void stopMoving() {
        isMoving = false;
    }

    public void resumeMoving() {
        synchronized (this) {
            isMoving = true;
            this.notify();
        }
    }
}
