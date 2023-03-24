package com.universitybullshit.view;

import javax.swing.*;
import java.awt.*;

public class AboutFrame {
    private static final int width = 240;
    private static final int height = 120;
    private static final String title = "About";
    public static JDialog create(JFrame frame) {
        JDialog dialog = new JDialog(frame, title, true);
        JPanel panel = new JPanel();
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(width, height));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.add(panel);
        panel.add(new JLabel("BuildingSpawner"));
        panel.add(new JLabel("Version: 1.0-SNAPSHOT"));
        panel.add(new JLabel("Authors: cheremshin, Arounte"));
        return dialog;
    }
}
