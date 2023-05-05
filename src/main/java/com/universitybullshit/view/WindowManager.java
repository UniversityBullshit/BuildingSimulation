package com.universitybullshit.view;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.fabrics.FontFactory;
import com.universitybullshit.view.fabrics.ImageFactory;
import com.universitybullshit.view.pages.IPage;
import com.universitybullshit.view.pages.InformationPage;
import com.universitybullshit.view.pages.MainMenuPage;
import com.universitybullshit.view.pages.SimulationPage;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents program GUI and allows to manage pages switching
 */
public class WindowManager {
    @Getter
    private final JFrame mainFrame;
    @Getter
    private static final ImageFactory imageFactory = new ImageFactory();
    @Getter
    private static final FontFactory fontFactory =   new FontFactory();
    private final Map<String, IPage> pages;
    @Getter
    @Setter
    private String currentPage;
    @Getter
    private final HabitatController controller;

    @Getter
    @Setter
    private int width;
    @Getter
    @Setter
    private int height;

    // String constants
    @Getter
    private final String TITLE =                   "BuildingSpawner";
    @Getter
    private static final String MAIN_MENU_PAGE =   "MainMenu";
    @Getter
    private static final String PREFERENCES_PAGE = "Preferences";
    @Getter
    private static final String SIMULATION_PAGE =  "Simulation";
    @Getter
    private static final String INFORMATION_PAGE = "Information";

    public WindowManager(HabitatController controller) {
        mainFrame = new JFrame();
        this.controller = controller;

        pages = new HashMap<>();
        pages.put(MAIN_MENU_PAGE, new MainMenuPage(mainFrame, this));
        pages.put(SIMULATION_PAGE, new SimulationPage(mainFrame, this));
//        pages.add(new PreferencesPage(mainFrame));
        pages.put(INFORMATION_PAGE, new InformationPage(mainFrame, this));

        currentPage = MAIN_MENU_PAGE;
        width = 400;
        height = 650;

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
        mainFrame.setSize(width, height);
        mainFrame.setLocationRelativeTo(null);

        currentPage = pageName;
        pages.get(currentPage).draw();
        mainFrame.setVisible(true);
    }

    public void showDialog(String dialogName) {
        JDialog dialog = new JDialog(mainFrame, dialogName, true);
        pages.get(dialogName).drawAsDialog(dialog);
        dialog.setVisible(true);
    }
}
