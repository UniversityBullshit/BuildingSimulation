package com.universitybullshit.view;

import com.universitybullshit.view.component.ImageFactory;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
//import java.awt.geom.AffineTransform;
//import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImageOp;
//import java.awt.image.ImageObserver;

public class Area extends JPanel {
    private static final JFrame ctx = MainFrame.getCtx();
    private final int width;
    private final int height;
    private final JPanel root;
    private final ImageFactory imageFactory = new ImageFactory();
    @Setter
    private boolean isAreaUpdating = false;

    public Area(int width, int height, JPanel root) {
        this.width = width;
        this.height = height;
        this.root = root;
    }

//    private void paint(Graphics g) {
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.drawImage(imageFactory.getCapitalBuilding(), 0, 0, null);
//    }
    
    public void create() {
        this.root.setLayout(null);
        ctx.add(this.root, BorderLayout.CENTER);
        this.setSize(new Dimension(this.width, this.height));
        this.setBorder(BorderFactory.createTitledBorder("Area"));
        this.setLayout(null);
        this.root.add(this);
        this.root.updateUI();
    }

    public void update() {
        while (isAreaUpdating) {
//            area.add(new JLabel(imageFactory.getWoodenBuilding()));
            this.updateUI();
            System.out.println("Area updated!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
