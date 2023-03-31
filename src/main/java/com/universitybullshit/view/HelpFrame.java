package com.universitybullshit.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HelpFrame {
    private static final int width = 240;
    private static final int height = 120;
    public static JDialog create(JFrame frame, String title) {
        JDialog dialog = new JDialog(frame, title, true);
        JPanel panel = new JPanel();
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(width, height));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 0, 0)));
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.add(panel);
        panel.add(new JLabel("BuildingSpawner"));
        panel.add(new JLabel("Version: 1.0-SNAPSHOT"));
        panel.add(new JLabel("Authors: Sergei Cheremisin, Arounte"));
        return dialog;
    }
}
