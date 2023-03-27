package com.universitybullshit.view.component;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class ImageFactory {
    private static final String WOODEN_BUILDING_ICON_PATH = "./src/main/resources/woodenBuilding.png";
    private static final String CAPITAL_BUILDING_ICON_PATH = "./src/main/resources/capitalBuilding.png";

    @Getter
    private final Image woodenBuilding;
    @Getter
    private final Image capitalBuilding;

    public ImageFactory() {
        this.woodenBuilding = new ImageIcon(WOODEN_BUILDING_ICON_PATH).getImage();
        this.capitalBuilding = new ImageIcon(CAPITAL_BUILDING_ICON_PATH).getImage();
    }
}
