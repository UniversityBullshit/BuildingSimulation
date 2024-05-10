package com.universitybusiness.view;

import com.universitybusiness.controller.ClientController;
import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;
import com.universitybusiness.view.fabrics.FontFactory;
import com.universitybusiness.view.fabrics.ImageFactory;
import com.universitybusiness.view.pages.*;
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
    private final Map<String, IPage> pages;
    @Getter
    private String currentPage;
    @Getter
    private final HabitatController controller;
    @Getter
    private final ClientController clientController;
    @Getter
    private final ApplicationViewModelFactory viewModelFactory;
    @Getter
    private static final ImageFactory imageFactory = new ImageFactory();
    @Getter
    private static final FontFactory fontFactory = new FontFactory();

    @Getter
    @Setter
    private int width;
    @Getter
    @Setter
    private int height;

    // String constants
    private final String TITLE =                   "BuildingSimulator";

    public static class Pages {
        public static final String MAIN_MENU = "MainMenu";
        public static final String PREFERENCES = "Preferences";
        public static final String SIMULATION = "Simulation";
        public static final String INFORMATION = "Information";
        public static final String CURRENT_OBJECTS = "CurrentObjectsPage";
        public static final String TERMINAL = "Terminal";
        public static final String HELP = "Help";
        public static final String CONTROLS = "Controls";
        public static final String USERS = "Users";
    }

    public WindowManager(
        HabitatController controller,
        ClientController clientController,
        ApplicationViewModelFactory viewModelFactory
    ) {
        mainFrame = new JFrame();
        this.controller = controller;
        this.clientController = clientController;
        this.viewModelFactory = viewModelFactory;

        pages = new HashMap<>();
        pages.put(Pages.MAIN_MENU, new MainMenuPage(mainFrame, this));
        pages.put(Pages.SIMULATION, new SimulationPage(mainFrame, this));
        pages.put(Pages.PREFERENCES, new PreferencesPage(mainFrame, this));
        pages.put(Pages.INFORMATION, new InformationPage(mainFrame, this));
        pages.put(Pages.CURRENT_OBJECTS, new CurrentObjectsPage(mainFrame, this));
        pages.put(Pages.CONTROLS, new ControlsPage(mainFrame, this));
        pages.put(Pages.HELP, new HelpPage(mainFrame, this));
        pages.put(Pages.TERMINAL, new TerminalPage(mainFrame, this));
        pages.put(Pages.USERS, new UsersPage(mainFrame, this));

        currentPage = Pages.MAIN_MENU;
        width = 400;
        height = 650;

        setupMainFrame();
        swapPage(currentPage);
    }

    /**
     * Sets frame default settings
     */
    private void setupMainFrame() {
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
        pages.get(currentPage).reset();

        mainFrame.setVisible(true);
    }

    public void showDialog(String pageName) {
        JDialog dialog = new JDialog(mainFrame, pageName, true);
        dialog.setLocationRelativeTo(null);
        pages.get(pageName).drawAsDialog(dialog);
        pages.get(pageName).reset();
        dialog.setVisible(true);
    }
}
