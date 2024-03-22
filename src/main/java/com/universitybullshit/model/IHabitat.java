package com.universitybullshit.model;

public interface IHabitat {
    public void update(long time);
    
    public void reset();

    public void setSize(int width, int height);
}