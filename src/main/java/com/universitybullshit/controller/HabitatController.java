package com.universitybullshit.controller;

import com.universitybullshit.model.Habitat;

public class HabitatController {
    private boolean isSimulationStarted = false;
    private long time;
    public void StartSimulation() {
        Habitat habitat = new Habitat(800, 600);
    }
    public void StartSimulation(int width, int height) {
        Habitat habitat = new Habitat(width, height);
    }
    public void StopSimulation() {

    }
}
