package com.universitybusiness.view.util;

import com.universitybusiness.model.Building;
import com.universitybusiness.model.CapitalBuilding;
import com.universitybusiness.model.WoodenBuilding;
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

    public BuildingInstance(Building building) {
        this.x = building.getX();
        this.y = building.getY();
        setType(building);
    }

    private void setType(Building building) {
        if (building instanceof CapitalBuilding) this.isCapitalBuilding = true;
        if (building instanceof WoodenBuilding) this.isWoodenBuilding = true;
    }
}
