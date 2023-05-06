package com.universitybullshit.model.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BuildingDto {
    @Getter
    @Setter
    private static long woodenBuildingInterval = 2000;
    @Getter
    @Setter
    private static double woodenBuildingProbability = 0.3;
    @Getter
    @Setter
    private static long woodenBuildingLifeTime = 30000;
    @Getter
    @Setter
    private static long capitalBuildingInterval = 3000;
    @Getter
    @Setter
    private static double capitalBuildingProbability = 0.7;
    @Getter
    @Setter
    private static long capitalBuildingLifeTime = 90000;
}
