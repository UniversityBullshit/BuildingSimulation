package com.universitybusiness;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.Habitat;
import com.universitybusiness.service.SimulationService;
import com.universitybusiness.view.WindowManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SimulationService simulation = new SimulationService(new Habitat(100,100));
        HabitatController controller = new HabitatController(simulation);
        WindowManager windowManager = new WindowManager(controller);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
