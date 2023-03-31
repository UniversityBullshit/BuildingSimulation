package com.universitybullshit.view;

import com.universitybullshit.view.component.ImageFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HelpFrame {
    private static final int width = 240;
    private static final int height = 180;
    private static final ImageFactory imageFactory = new ImageFactory();

    public static JDialog create(JFrame frame, String title) {
        JDialog dialog = new JDialog(frame, title, true);
        JPanel imgPanel = new JPanel();
        JPanel panel = new JPanel();
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(width, height));
        imgPanel.setBorder(new EmptyBorder(new Insets(15, 0, 0, 0)));
        imgPanel.add(new JLabel(new ImageIcon(imageFactory.getItDeprecated().getScaledInstance(115, 42, Image.SCALE_SMOOTH))));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 0, 0)));
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.add(imgPanel, BorderLayout.NORTH);
        dialog.add(panel, BorderLayout.CENTER);
        panel.add(new JLabel("BuildingSpawner"));
        panel.add(new JLabel("Version: 1.0"));
        panel.add(new JLabel("Authors: Sergei Cheremisin, Arounte"));
        return dialog;
    }
}
