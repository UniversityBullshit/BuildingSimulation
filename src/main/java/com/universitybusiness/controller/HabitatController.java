package com.universitybusiness.controller;

import com.universitybusiness.model.Building;
import com.universitybusiness.model.Habitat;
import com.universitybusiness.service.SimulationService;

import java.util.*;

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
    private final SimulationService simulationService;

    /**
     * Constructor creates Habitat instance and provides interaction with it.
     */
    public HabitatController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    /**
     * Starts an endless process of simulation that runs asynchronously.
     */
    public void startSimulation() {
        simulationService.startSimulation();
    }

    /**
     * Interrupts simulation process.
     */
    public void stopSimulation() {
        try {
            simulationService.stopSimulation();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean getSimulationStatus() {
        return simulationService.getIsSimulationRunning();
    }

    /**
     * Set context to default state
     */
    public void resetSimulation() {
        simulationService.resetSimulation();
    }

    public Habitat getSimulationService() {
        return simulationService.getHabitat();
    }

    public void setSimulationService(Habitat habitat) {
        simulationService.setHabitat(habitat);
    }

    /**
     * Method that allows getting actual list of buildings in any time of application lifecycle.
     * @return Habitat.buildings
     */
    public Vector<Building> getBuildings() {
        return simulationService.getHabitat().getBuildings();
    }

    /**
     * Method that allows getting actual list of ids in any time of application lifecycle.
     * @return Habitat.ids
     */
    public HashSet<Long> getIds() {
        return simulationService.getHabitat().getIds();
    }

    /**
     * Method that allows getting actual list of alive objects with their spawn time
     * in any time of application lifecycle.
     * @return Habitat.spawnTimeMap
     */
    public TreeMap<Long, Long> getSpawnTimeMap() {
        return simulationService.getHabitat().getSpawnTimeMap();
    }

    /**
     * Method that allows getting actual count of wooden buildings in any time of application lifecycle.
     * @return Habitat.woodenBuildingsCount
     */
    public int getWoodenBuildingsCount() {
        return simulationService.getHabitat().getWoodenBuildingsCount();
    }

    /**
     * Method that allows getting actual count of capital buildings in any time of application lifecycle.
     * @return Habitat.capitalBuildingsCount
     */
    public int getCapitalBuildingsCount() {
        return simulationService.getHabitat().getCapitalBuildingsCount();
    }

    /**
     * Method that allows getting time spent from simulation start in any time of application lifecycle.
     * @return time spent from simulation start
     */
    public long getSimulationTime() {
        return simulationService.getTime();
    }
}
