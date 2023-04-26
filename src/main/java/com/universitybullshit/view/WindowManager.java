package com.universitybullshit.view;

import com.universitybullshit.view.fabrics.FontFactory;
import com.universitybullshit.view.fabrics.ImageFactory;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class represents program GUI and allows to manage pages switching
 */
public class WindowManager {
    private final JFrame mainFrame;
    @Getter
    private final ImageFactory imageFactory;
    @Getter
    private final FontFactory fontFactory;
    @Getter
    @Setter
    private String currentPage;


    // String constants
    @Getter
    private final String TITLE = "BuildingSpawner";
    @Getter
    private static final String MAIN_MENU_PAGE = "MainMenu";
    @Getter
    private static final String PREFERENCES_PAGE = "Preferences";
    @Getter
    private static final String SIMULATION_PAGE = "Simulation";

    public WindowManager() {
        mainFrame = new JFrame();
        imageFactory = new ImageFactory();
        fontFactory = new FontFactory();

        currentPage = MAIN_MENU_PAGE;

        setDefaults();
        swapPage(currentPage);
    }

    /**
     * Sets frame default settings
     */
    private void setDefaults() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setIconImage(this.imageFactory.getIcon());
        mainFrame.setResizable(false);
        mainFrame.setTitle(TITLE);
    }

    /**
     * Must be called in action responsible for switching pages
     * @param pageName constant that can be got from WindowManager
     */
    public void swapPage(String pageName) {
        // Cleanup frame from previous page
        mainFrame.getContentPane().removeAll();

        // Draw new one page
        switch (pageName) {
            case MAIN_MENU_PAGE:
                break;
            case PREFERENCES_PAGE:
                break;
            case SIMULATION_PAGE:
                break;
        }
    }
}
