package com.universitybullshit.controller;

import com.universitybullshit.model.Building;
import com.universitybullshit.model.Habitat;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;

/**
 * Controller, representing a component that controls simulation process.
 * <p>
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
        this.simulationCurrentTime = 0;
    }

    /**
     * Starts an endless process of simulation that runs asynchronously.
     */
    public void startSimulation() {
        this.isSimulationRunning = true;
        CompletableFuture.runAsync(this::simulation);
    }

    /**
     * Interrupts simulation process.
     */
    public void stopSimulation() {
        this.isSimulationRunning = false;
    }

    /**
     * Set context to default state
     */
    public void resetSimulation() {
        this.context.reset();
    }

    /**
     * Method that allows getting actual list of buildings in any time of application lifecycle.
     * @return Habitat.buildings
     */
    public Vector<Building> getBuildings() {
        return this.context.getBuildings();
    }

    /**
     * Method that allows getting actual list of ids in any time of application lifecycle.
     * @return Habitat.ids
     */
    public HashSet<Long> getIds() {
        return this.context.getIds();
    }

    /**
     * Method that allows getting actual list of alive objects with their spawn time
     * in any time of application lifecycle.
     * @return Habitat.spawnTimeMap
     */
    public TreeMap<Long, Long> getSpawnTimeMap() {
        return this.context.getSpawnTimeMap();
    }

    /**
     * Method that allows getting actual count of wooden buildings in any time of application lifecycle.
     * @return Habitat.woodenBuildingsCount
     */
    public int getWoodenBuildingsCount() {
        return this.context.getWoodenBuildingsCount();
    }

    /**
     * Method that allows getting actual count of capital buildings in any time of application lifecycle.
     * @return Habitat.capitalBuildingsCount
     */
    public int getCapitalBuildingsCount() {
        return this.context.getCapitalBuildingsCount();
    }

    /**
     * Method that allows getting time spent from simulation start in any time of application lifecycle.
     * @return time spent from simulation start
     */
    public long getSimulationTime() {
        return this.simulationCurrentTime;
    }

    private void simulation() {
        while (this.isSimulationRunning) {
            this.context.update(this.simulationCurrentTime);
            this.simulationCurrentTime = System.currentTimeMillis() - this.simulationStartTime;
            try {
                Thread.sleep(50); // 25 updates per second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
