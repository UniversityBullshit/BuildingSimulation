package com.universitybullshit.model.util;

import lombok.Data;
import lombok.Getter;

@Data
public class BuildingDto {
    @Getter
    private static long woodenBuildingInterval = 2000;
    @Getter
    private static double woodenBuildingProbability = 0.3;
    @Getter
    private static long woodenBuildingLifeTime = 30000;
    @Getter
    private static long capitalBuildingInterval = 3000;
    @Getter
    private static double capitalBuildingProbability = 0.7;
    @Getter
    private static long capitalBuildingLifeTime = 90000;
}
