package com.universitybusiness.view.util;

import com.universitybusiness.model.Building;
import com.universitybusiness.model.CapitalBuilding;
import com.universitybusiness.model.WoodenBuilding;
import lombok.Getter;
import lombok.Setter;

public class BuildingInstance {
    public enum Type {
        WOODEN,
        CAPITAL
    }

    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private Type type;

    public BuildingInstance(Building building) {
        this.x = (int) building.getX();
        this.y = (int) building.getY();
        setType(building);
    }

    private void setType(Building building) {
        if (building instanceof CapitalBuilding) type = Type.CAPITAL;
        if (building instanceof WoodenBuilding) type = Type.WOODEN;
    }
}
