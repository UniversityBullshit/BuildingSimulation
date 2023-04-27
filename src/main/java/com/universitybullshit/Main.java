package com.universitybullshit;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.WindowManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        HabitatController controller = new HabitatController();
        WindowManager windowManager = new WindowManager(controller);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
