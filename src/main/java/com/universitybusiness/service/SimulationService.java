package com.universitybusiness.service;

import com.universitybusiness.model.simulation.impl.Habitat;
import lombok.Getter;
import lombok.Setter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

public class SimulationService {
    @Getter
    @Setter
    private Habitat habitat;
    @Getter
    @Setter
    private long time;
    @Getter
    private Boolean isSimulationRunning;
    private Timer timer;

    private CompletableFuture<Void> future;

    // Constants
    private final long TIMER_TICK_VALUE = 200;

    public SimulationService(Habitat habitat) {
        this.habitat = habitat;
        time = 0;
        isSimulationRunning = false;
    }

    public void startSimulation() {
        if (!isSimulationRunning) {
            isSimulationRunning = true;
            habitat.resumeAI();
            future = CompletableFuture.runAsync(this::simulation);
        }
    }

    public void stopSimulation() {
        isSimulationRunning = false;
        habitat.sleepAI();
        if (future != null) future.cancel(true);
        if (timer != null) timer.cancel();
    }

    public void resetSimulation() {
        try {
            stopSimulation();
            time = 0;
            habitat.reset();
        } catch (Exception ignored) {}
    }

    private void simulation() {
        long TIMER_DELAY_VALUE = 0;

        timer = new Timer();
        time = habitat.getTime();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time += TIMER_TICK_VALUE;
                habitat.update(time);
            }
        }, TIMER_DELAY_VALUE, TIMER_TICK_VALUE);
    }

    public boolean isWoodenBuildingAISleeping() {
        return habitat.isWoodenBuildingAISleeping();
    }

    public boolean isCapitalBuildingAISleeping() {
        return habitat.isCapitalBuildingAISleeping();
    }
}
