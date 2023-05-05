package com.universitybullshit.view.pages;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.menubar.CustomMenuBar;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PreferencesPage implements IPage {
    private final JFrame frame;
    private final Map<String, JComponent> components;
    private final WindowManager context;


    // String constants
    private final String PREFERENCES_LABEL_NAME = "PreferencesLabel";
    private final String WOODEN_LABEL_NAME = "WoodenLabel";
    private final String CAPITAL_LABEL_NAME = "CapitalLabel";
    private final String INTERVAL_LABEL_NAME = "IntervalLabel";
    private final String PROBABILITY_LABEL_NAME = "ProbabilityLabel";
    private final String LIFETIME_LABEL_NAME = "LifetimeLabel";
    private final String SPEED_LABEL_NAME = "SpeedLabel";
    private final String WOODEN_INTERVAL_FIELD_NAME = "WoodenIntevalField";
    private final String CAPITAL_INTERVAL_FIELD_NAME = "CapitalIntervalField";
    private final String WOODEN_LIFETIME_FIELD_NAME = "WoodenLifetimeField";
    private final String CAPITAL_LIFETIME_FIELD_NAME = "CapitalLifetimeField";
    private final String WOODEN_SPEED_FIELD_NAME = "WoodenSpeedFieldName";
    private final String CAPITAL_SPEED_FIELD_NAME = "CapitalSpeedFieldName";
    private final String SAVE_EXIT_BUTTON_NAME = "SaveExitButtonName";
    private final String RESTORE_BUTTON_NAME = "RestoreButtonName";
    private final String WOODEN_PROBABILITY_COMBOBOX = "WoodenProbabilityCombobox";
    private final String CAPITAL_PROBABILITY_COMBOBOX = "CapitalProbabilityCombobox";

    public PreferencesPage(JFrame frame, WindowManager context) {
        this.frame = frame;
        this.context = context;
        components = new HashMap<>();

        initializeComponents();
        setupAppearance();
    }


    @Override
    public void initializeComponents() {

    }

    @Override
    public void setupAppearance() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        // No implementation
    }
}
