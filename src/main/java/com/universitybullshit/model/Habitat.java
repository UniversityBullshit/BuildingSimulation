package com.universitybullshit.model;

import java.util.List;

public class Habitat {
    private int width;
    private int height;
    private long time;
    private List<Building> buildings;
    public Habitat(int width, int height) {
        this.width = width;
        this.height = height;
        this.time = 0;
        this.buildings = null;
    }
    private void Update(long time) {
        // Генерация новых объектов и размещение в поле
    }
    public List<Building> GetBuildigs() {
        return this.buildings;
    }
}
