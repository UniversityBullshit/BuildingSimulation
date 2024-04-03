package com.universitybusiness.view.pages;

import javax.swing.*;

public interface IPage {
    /**
     * Creates all components of page
     */
    void initializeComponents();

    /**
     * Restore starting state of page (Optional)
     */
    void reset();

    /**
     * Setups all components appearance
     */
    void setupAppearance();

    /**
     * Adds all components of page to frame
     */
    void draw();

    /**
     * Draws all components in JDialog. (Optional)
     */
    void drawAsDialog(JDialog dialog);
}
