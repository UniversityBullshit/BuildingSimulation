package com.universitybullshit.view;

import javax.swing.*;
import java.awt.*;

public class Area {
    private static final JFrame ctx = MainFrame.getCtx();
    private final int width;
    private final int height;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void create(JPanel root) {
//        JPanel root = new JPanel();
        JPanel area = new JPanel();
        root.setLayout(null);
//        root.setBackground(Color.PINK);
        ctx.add(root, BorderLayout.CENTER);
        area.setSize(new Dimension(this.width, this.height));
        area.setBorder(BorderFactory.createTitledBorder("Area"));
//        area.setBackground(Color.CYAN);
        root.add(area);
        root.updateUI();
//        System.out.printf("%d %d\n", this.width, this.height);
    }
}
