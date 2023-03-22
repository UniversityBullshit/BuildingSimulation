package com.universitybullshit.model;

import java.util.List;
import java.util.Random;

public class Habitat {
    private int width;
    private int height;
    private long time;
    private List<Building> buildings;
    public Habitat(int width, int height) {
        this.width = width;
        this.height = height;
        this.time = System.currentTimeMillis();
        this.buildings = null;
    }
    public void Update(long time) {
        // Генерация новых объектов и размещение в поле
        Random generator = new Random();
        double chance = generator.nextDouble();

        if (chance > CapitalBuilding.GetProbability()) {
            if (time - this.time > CapitalBuilding.GetInterval()) {
                System.out.println("Ищем место, где можно разместить CapitalBuilding и ставим");
                this.time = time;
            }
        }

        if (chance > WoodenBuilding.GetProbability()) {
            if (time - this.time > WoodenBuilding.GetInterval()) {
                System.out.println("Ищем место, где можно разместить WoodenBuilding и ставим");
                this.time = time;
            }
        }

        System.out.printf("Diff: %d\n", time - this.time);
    }
    public List<Building> GetBuildings() {
        return this.buildings;
    }
}
