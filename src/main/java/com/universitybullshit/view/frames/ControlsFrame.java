package com.universitybullshit.view.frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ControlsFrame {
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
        panel.add(new JLabel("Controls"));
        panel.add(new JLabel("'b' to start"));
        panel.add(new JLabel("'e' to stop"));
        return dialog;
    }
}
