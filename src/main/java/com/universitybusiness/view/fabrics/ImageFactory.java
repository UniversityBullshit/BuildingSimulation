package com.universitybusiness.view.fabrics;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageFactory {
    private static final URL IT_DEPRECATED_PATH = ImageFactory.class.getResource("/img/it_deprecated.png");
    private static final URL ICON_PATH = ImageFactory.class.getResource("/img/building.png");
    private static final URL MAIN_MENU_IMAGE_PATH = ImageFactory.class.getResource("/img/main_menu_image.jpg");
    private static final URL WOODEN_BUILDING_ICON_PATH = ImageFactory.class.getResource("/img/wooden64.png");
    private static final URL CAPITAL_BUILDING_ICON_PATH = ImageFactory.class.getResource("/img/capital64.png");

    @Getter
    private final Image itDeprecated;
    @Getter
    private final Image icon;
    @Getter
    private final Image mainMenuImage;
    @Getter
    private final Image woodenBuilding;
    @Getter
    private final Image capitalBuilding;

    public ImageFactory() {
        itDeprecated = new ImageIcon(IT_DEPRECATED_PATH).getImage();
        icon = new ImageIcon(ICON_PATH).getImage();
        mainMenuImage = new ImageIcon(MAIN_MENU_IMAGE_PATH).getImage();
        woodenBuilding = new ImageIcon(WOODEN_BUILDING_ICON_PATH).getImage();
        capitalBuilding = new ImageIcon(CAPITAL_BUILDING_ICON_PATH).getImage();
    }
}
