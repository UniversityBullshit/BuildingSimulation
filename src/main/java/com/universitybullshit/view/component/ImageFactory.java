package com.universitybullshit.view.component;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageFactory {
    private static final String WOODEN_BUILDING_ICON_PATH = "./src/main/resources/woodenBuilding.png";
    private static final String CAPITAL_BUILDING_ICON_PATH = "./src/main/resources/capitalBuilding.png";
    private static final String IT_DEPRECATED_PATH = "./src/main/resources/it_deprecated.png";

    @Getter
    private final Image woodenBuilding;
    @Getter
    private final Image capitalBuilding;

    @Getter
    private final Image itDeprecated;

    public ImageFactory() {
        this.woodenBuilding = new ImageIcon(WOODEN_BUILDING_ICON_PATH).getImage();
        this.capitalBuilding = new ImageIcon(CAPITAL_BUILDING_ICON_PATH).getImage();
        this.itDeprecated = new ImageIcon(IT_DEPRECATED_PATH).getImage();
    }
}
