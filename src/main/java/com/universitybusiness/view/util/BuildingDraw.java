package com.universitybusiness.view.util;

import lombok.Data;
import lombok.Getter;

import java.awt.*;

@Data
public class BuildingDraw {
    @Getter
    private static final Color woodenBuildingColor = new Color(17, 102, 28);
    @Getter
    private static final Color capitalBuildingColor = new Color(143, 30, 242);
    @Getter
    private static final Integer woodenBuildingSide = 3;
    @Getter
    private static final Integer capitalBuildingSide = 4;
}
