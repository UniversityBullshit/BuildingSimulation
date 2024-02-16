package com.universitybullshit;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.model.Habitat;
import com.universitybullshit.service.SimulationService;
import com.universitybullshit.view.WindowManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SimulationService simulation = new SimulationService(new Habitat(100,100));
        HabitatController controller = new HabitatController(simulation);
        WindowManager windowManager = new WindowManager(controller);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
