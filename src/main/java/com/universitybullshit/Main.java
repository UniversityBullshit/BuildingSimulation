package com.universitybullshit;

import com.universitybullshit.view.WindowManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        WindowManager windowManager = new WindowManager();
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
