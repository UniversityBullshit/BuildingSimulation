package com.universitybullshit.view.pages;

public interface IPage {
    /**
     * Creates all components of page
     */
    void initializeComponents();

    /**
     * Setups all components appearance
     */
    void setupAppearance();

    /**
     * Adds all components of page to frame
     */
    void draw();
}
