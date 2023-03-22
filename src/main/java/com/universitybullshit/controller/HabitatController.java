package com.universitybullshit.controller;

import com.universitybullshit.model.Building;
import com.universitybullshit.model.Habitat;

import java.util.concurrent.CompletableFuture;
import java.util.List;

public class HabitatController {
    private boolean isSimulationRunning = false;
    private long time;
    private Habitat context;
    public HabitatController(Habitat context) {
        this.context = context;
        this.time = System.currentTimeMillis();
    }
    public void StartSimulation() {
        this.isSimulationRunning = true;

        CompletableFuture.runAsync(() -> Simulation());
    }
    public void StopSimulation() {
        this.isSimulationRunning = false;
    }
    public List<Building> GetBuildings() {
        return this.context.GetBuildings();
    }
    private void Simulation() {
        while (this.isSimulationRunning) {
            this.context.Update(this.time);
            this.time = System.currentTimeMillis();
            try {
                Thread.sleep(1000); // 25 updates per second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
