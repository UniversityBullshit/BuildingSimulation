package com.universitybullshit.controller;

import com.universitybullshit.model.Building;
import com.universitybullshit.model.Habitat;

import java.util.concurrent.CompletableFuture;
import java.util.List;

/**
 * Controller, representing a component that controls simulation process.
 *
 * Simulation is an endless process that runs asynchronously via StartSimulation method and can only be interrupted
 * by the StopSimulation method. Also provides getters with some information about habitat state.
 *
 * @author Sergei Cheremisin
 * @version 1.0
 */
public class HabitatController {
    private boolean isSimulationRunning = false;
    private long simulationStartTime;
    private long simulationCurrentTime;
    private Habitat context;

    /**
     * Constructor gets Habitat instance and provides interaction with it.
     * @param width simulation field width
     * @param height simulation field height
     */
    public HabitatController(int width, int height) {
        this.context = new Habitat(width, height);
        this.simulationStartTime = System.currentTimeMillis();
        this.simulationCurrentTime = this.simulationStartTime;
    }

    /**
     * Starts an endless process of simulation that runs asynchronously.
     */
    public void StartSimulation() {
        this.isSimulationRunning = true;

        CompletableFuture.runAsync(() -> Simulation());
    }

    /**
     * Interrupts simulation process.
     */
    public void StopSimulation() {
        this.isSimulationRunning = false;
    }

    /**
     * Method that allows getting actual list of buildings in any time of application lifecycle.
     * @return Habitat.buildings
     */
    public List<Building> GetBuildings() {
        return this.context.GetBuildings();
    }

    /**
     * Method that allows getting actual count of wooden buildings in any time of application lifecycle.
     * @return Habitat.woodenBuildingsCount
     */
    public int GetWoodenBuildingsCount() {
        return this.context.GetWoodenBuildingsCount();
    }

    /**
     * Method that allows getting actual count of capital buildings in any time of application lifecycle.
     * @return Habitat.capitalBuildingsCount
     */
    public int GetCapitalBuildingsCount() {
        return this.context.GetCapitalBuildingsCount();
    }

    /**
     * Method that allows getting time spent from simulation start in any time of application lifecycle.
     * @return time spent from simulation start
     */
    public long GetSimulationTime() {
        return this.simulationCurrentTime - this.simulationStartTime;
    }

    private void Simulation() {
        while (this.isSimulationRunning) {
            this.context.Update(this.simulationCurrentTime);
            this.simulationCurrentTime = System.currentTimeMillis();
            try {
                Thread.sleep(1000); // 25 updates per second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
