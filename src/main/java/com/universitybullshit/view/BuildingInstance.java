package com.universitybullshit.view;

import com.universitybullshit.view.component.ImageFactory;

import javax.swing.*;
import java.awt.*;

public class BuildingInstance extends JPanel {
    private final int x;
    private final int y;
    private final boolean isCapitalBuilding;
    private final ImageFactory imageFactory = new ImageFactory();

    public BuildingInstance(boolean isCapitalBuilding, int x, int y) {
        this.x = x;
        this.y = y;
        this.isCapitalBuilding = isCapitalBuilding;
        this.setLayout(null);
//        this.setSize(new Dimension(20, 20));
        this.setBounds(this.x, this.y, 3, 3);
        if (this.isCapitalBuilding)
            this.setBackground(Color.RED);
        else
            this.setBackground(Color.DARK_GRAY);
    }

//    public void paint(Graphics g) {
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.drawImage(isCapitalBuilding ? imageFactory.getCapitalBuilding() : imageFactory.getWoodenBuilding(), this.x, this.y, null);
//    }
}
