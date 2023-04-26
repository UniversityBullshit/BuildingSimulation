package com.universitybullshit.view.fabrics;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageFactory {
//    private static final String WOODEN_BUILDING_ICON_PATH = "./src/main/resources/woodenBuilding.png";
//    private static final String CAPITAL_BUILDING_ICON_PATH = "./src/main/resources/capitalBuilding.png";
    private static final URL IT_DEPRECATED_PATH = ImageFactory.class.getResource("/img/it_deprecated.png");
    private static final URL ICON_PATH = ImageFactory.class.getResource("/img/building.png");
    private static final URL MAIN_MENU_IMAGE_PATH = ImageFactory.class.getResource("/img/main_menu_image.jpg");

//    @Getter
//    private final Image woodenBuilding;
//    @Getter
//    private final Image capitalBuilding;

    @Getter
    private final Image itDeprecated;
    @Getter
    private final Image icon;
    @Getter
    private final Image mainMenuImage;

    public ImageFactory() {
//        this.woodenBuilding = new ImageIcon(WOODEN_BUILDING_ICON_PATH).getImage();
//        this.capitalBuilding = new ImageIcon(CAPITAL_BUILDING_ICON_PATH).getImage();
        this.itDeprecated = new ImageIcon(IT_DEPRECATED_PATH).getImage();
        this.icon = new ImageIcon(ICON_PATH).getImage();
        this.mainMenuImage = new ImageIcon(MAIN_MENU_IMAGE_PATH).getImage();
    }
}
