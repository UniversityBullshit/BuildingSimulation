package com.universitybullshit.view.util;

import com.universitybullshit.model.Building;
import com.universitybullshit.model.CapitalBuilding;
import com.universitybullshit.model.WoodenBuilding;
import com.universitybullshit.view.fabrics.ImageFactory;
import lombok.Getter;
import lombok.Setter;

public class BuildingInstance {
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private boolean isCapitalBuilding = false;
    @Getter
    private boolean isWoodenBuilding = false;
    private final ImageFactory imageFactory = new ImageFactory();

    public BuildingInstance(Building building) {
        this.x = building.getX();
        this.y = building.getY();
        setType(building);
    }

    private void setType(Building building) {
        if (building instanceof CapitalBuilding) this.isCapitalBuilding = true;
        if (building instanceof WoodenBuilding) this.isWoodenBuilding = true;
    }

//    public void paint(Graphics g) {
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.drawImage(isCapitalBuilding ? imageFactory.getCapitalBuilding() : imageFactory.getWoodenBuilding(), this.x, this.y, null);
//    }
}
