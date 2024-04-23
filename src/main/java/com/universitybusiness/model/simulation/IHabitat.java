package com.universitybusiness.model.simulation;

public interface IHabitat {
    /**
     * Call update simulation
     * @param time simulation time
     */
    void update(long time);

    /**
     * Reset simulation state to default
     */
    void reset();

    /**
     * Set simulation size
     * @param width simulation field width
     * @param height simulation field height
     */
    void setSize(int width, int height);
}
