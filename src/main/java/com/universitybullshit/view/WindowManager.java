package com.universitybullshit.view;

import com.universitybullshit.view.fabrics.FontFactory;
import com.universitybullshit.view.fabrics.ImageFactory;
import com.universitybullshit.view.pages.IPage;
import com.universitybullshit.view.pages.MainMenuPage;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents program GUI and allows to manage pages switching
 */
public class WindowManager {
    private final JFrame mainFrame;
    @Getter
    private static final ImageFactory imageFactory = new ImageFactory();
    @Getter
    private static final FontFactory fontFactory =   new FontFactory();
    private final Map<String, IPage> pages;
    @Getter
    @Setter
    private String currentPage;

    // String constants
    @Getter
    private final String TITLE =                   "BuildingSpawner";
    @Getter
    private static final String MAIN_MENU_PAGE =   "MainMenu";
    @Getter
    private static final String PREFERENCES_PAGE = "Preferences";
    @Getter
    private static final String SIMULATION_PAGE =  "Simulation";

    public WindowManager() {
        mainFrame = new JFrame();

        pages = new HashMap<>();
        pages.put(MAIN_MENU_PAGE, new MainMenuPage(mainFrame, this));
//        pages.add(new PreferencesPage(mainFrame));
//        pages.add(new SimulationPage(mainFrame));

        currentPage = MAIN_MENU_PAGE;

        setDefaults();
        swapPage(currentPage);
    }

    /**
     * Sets frame default settings
     */
    private void setDefaults() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setIconImage(imageFactory.getIcon());
        mainFrame.setResizable(false);
        mainFrame.setTitle(TITLE);
    }

    /**
     * Must be called in action responsible for switching pages
     * @param pageName constant that can be got from WindowManager
     */
    public void swapPage(String pageName) {
        mainFrame.getContentPane().removeAll();
        pages.get(pageName).draw();
        mainFrame.setVisible(true);
    }
}
