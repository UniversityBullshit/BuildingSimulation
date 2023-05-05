package com.universitybullshit.view.pages;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.fabrics.ComponentFabric;
import com.universitybullshit.view.menubar.CustomMenuBar;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PreferencesPage implements IPage {
    private final JFrame frame;
    private final Map<String, JComponent> components;
    private final WindowManager context;


    // String constants
    private final String PAGE_LABEL_NAME = "PreferencesLabel";
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
        final String PAGE_LABEL_TEXT = "Preferences";
        final String WOODEN_LABEL_TEXT = "Wooden Building";
        final String CAPITAL_LABEL_TEXT = "Capital Building";
        final String INTERVAL_LABEL_TEXT = "Spawn Interval";
        final String PROBABILITY_LABEL_TEXT = "Spawn Probability";
        final String LIFETIME_LABEL_TEXT = "Life Time";
        final String SPEED_LABEL_TEXT = "Movement Speed";
        final String SAVE_EXIT_BUTTON_TEXT = "Save and exit";
        final String RESTORE_BUTTON_NAME = "Restore defaults";
        final String INTERVAL_FIELDS_HINT = "500-10000 (ms)";
        final String PROBABILITY_COMBOBOX_HINT = "10-100%";
        final String LIFETIME_FIELDS_HINT = "1-1000 (s)";
        final String MOVEMENT_FIELDS_HINT = "1-100 (pts/s)";

        components.put(PAGE_LABEL_NAME, new JLabel(PAGE_LABEL_TEXT));
    }

    @Override
    public void setupAppearance() {
        ComponentFabric.setupLabel1((JLabel) components.get(PAGE_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(PAGE_LABEL_NAME));
    }

    @Override
    public void draw() {
        frame.setJMenuBar(new CustomMenuBar(context));

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(createPageLabelPanel());

        frame.add(rootPanel);
//        frame.pack();
        frame.requestFocusInWindow();
    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        // No implementation
    }

    private JPanel createPageLabelPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.add(components.get(PAGE_LABEL_NAME));
        return panel;
    }
}
