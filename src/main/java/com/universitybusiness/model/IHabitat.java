package com.universitybusiness.model;

public interface IHabitat {
    void update(long time);
    
    void reset();

    void setSize(int width, int height);
}