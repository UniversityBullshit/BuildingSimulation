package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.preferences.SavePreferencesAction;
import com.universitybusiness.view.components.controls.ControlButton;
import com.universitybusiness.view.components.textFilelds.HintTextField;
import com.universitybusiness.view.fabrics.ComponentFabric;
import com.universitybusiness.view.components.menubar.CustomMenuBar;
import com.universitybusiness.view.util.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PreferencesPage extends Page implements IPage {
    // String constants
    private final String PAGE_LABEL_NAME = "PreferencesLabel";
    private final String WOODEN_LABEL_NAME = "WoodenLabel";
    private final String CAPITAL_LABEL_NAME = "CapitalLabel";
    private final String INTERVAL_LABEL_NAME = "IntervalLabel";
    private final String PROBABILITY_LABEL_NAME = "ProbabilityLabel";
    private final String LIFETIME_LABEL_NAME = "LifetimeLabel";
    private final String SPEED_LABEL_NAME = "SpeedLabel";
    private final String WOODEN_INTERVAL_FIELD_NAME = "WoodenIntervalField";
    private final String CAPITAL_INTERVAL_FIELD_NAME = "CapitalIntervalField";
    private final String WOODEN_LIFETIME_FIELD_NAME = "WoodenLifetimeField";
    private final String CAPITAL_LIFETIME_FIELD_NAME = "CapitalLifetimeField";
    private final String WOODEN_SPEED_FIELD_NAME = "WoodenSpeedFieldName";
    private final String CAPITAL_SPEED_FIELD_NAME = "CapitalSpeedFieldName";
    private final String SAVE_EXIT_BUTTON_NAME = "SaveExitButtonName";
    private final String RESTORE_BUTTON_NAME = "RestoreButtonName";
    private final String WOODEN_PROBABILITY_COMBOBOX = "WoodenProbabilityCombobox";
    private final String CAPITAL_PROBABILITY_COMBOBOX = "CapitalProbabilityCombobox";
    private final String WOODEN_BUILDINGS_IMAGE_NAME = "WoodenBuildingsImage";
    private final String CAPITAL_BUILDINGS_IMAGE_NAME = "CapitalBuildingsImage";

    public PreferencesPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }


    @Override
    public void initializeComponents() {
        final String PAGE_LABEL_TEXT = "Preferences";
        final String WOODEN_LABEL_TEXT = "<html><p>Wooden<br>Building</p></html>";
        final String CAPITAL_LABEL_TEXT = "<html><p>Capital<br>Building</p></html>";
        final String INTERVAL_LABEL_TEXT = "Spawn Interval";
        final String PROBABILITY_LABEL_TEXT = "Spawn Probability";
        final String LIFETIME_LABEL_TEXT = "Life Time";
        final String SPEED_LABEL_TEXT = "Movement Speed";
        final String SAVE_EXIT_BUTTON_TEXT = "Save and exit";
        final String RESTORE_BUTTON_TEXT = "Restore defaults";
        final String INTERVAL_FIELDS_HINT = "500-10000 (ms)";
        final String PROBABILITY_COMBOBOX_HINT = "10-100%";
        final String LIFETIME_FIELDS_HINT = "1-1000 (s)";
        final String SPEED_FIELDS_HINT = "1-100 (pts/s)";

        // Labels
        components.put(PAGE_LABEL_NAME, new JLabel(PAGE_LABEL_TEXT));
        components.put(WOODEN_LABEL_NAME, new JLabel(WOODEN_LABEL_TEXT, SwingConstants.RIGHT));
        components.put(CAPITAL_LABEL_NAME, new JLabel(CAPITAL_LABEL_TEXT, SwingConstants.RIGHT));
        components.put(INTERVAL_LABEL_NAME, new JLabel(INTERVAL_LABEL_TEXT));
        components.put(PROBABILITY_LABEL_NAME, new JLabel(PROBABILITY_LABEL_TEXT));
        components.put(LIFETIME_LABEL_NAME, new JLabel(LIFETIME_LABEL_TEXT));
        components.put(SPEED_LABEL_NAME, new JLabel(SPEED_LABEL_TEXT));

        // Fields
        components.put(WOODEN_INTERVAL_FIELD_NAME, new HintTextField(INTERVAL_FIELDS_HINT));
        components.put(CAPITAL_INTERVAL_FIELD_NAME, new HintTextField(INTERVAL_FIELDS_HINT));
        components.put(WOODEN_PROBABILITY_COMBOBOX, new HintTextField(PROBABILITY_COMBOBOX_HINT));
        components.put(CAPITAL_PROBABILITY_COMBOBOX, new HintTextField(PROBABILITY_COMBOBOX_HINT));
        components.put(WOODEN_LIFETIME_FIELD_NAME, new HintTextField(LIFETIME_FIELDS_HINT));
        components.put(CAPITAL_LIFETIME_FIELD_NAME, new HintTextField(LIFETIME_FIELDS_HINT));
        components.put(WOODEN_SPEED_FIELD_NAME, new HintTextField(SPEED_FIELDS_HINT));
        components.put(CAPITAL_SPEED_FIELD_NAME, new HintTextField(SPEED_FIELDS_HINT));

        // Buttons
        components.put(SAVE_EXIT_BUTTON_NAME, new ControlButton(SAVE_EXIT_BUTTON_TEXT));
        components.put(RESTORE_BUTTON_NAME, new ControlButton(RESTORE_BUTTON_TEXT));

        // Images
        components.put(WOODEN_BUILDINGS_IMAGE_NAME, new JPanel());
        components.put(CAPITAL_BUILDINGS_IMAGE_NAME, new JPanel());
    }

    @Override
    public void reset() {}

    @Override
    public void setupAppearance() {
        ComponentFabric.setupLabel1((JLabel) components.get(PAGE_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(PAGE_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(WOODEN_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(WOODEN_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(CAPITAL_LABEL_NAME));
        ComponentFabric.setupLabel2((JLabel) components.get(CAPITAL_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(INTERVAL_LABEL_NAME));
        ComponentFabric.setupLabel3((JLabel) components.get(INTERVAL_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(PROBABILITY_LABEL_NAME));
        ComponentFabric.setupLabel3((JLabel) components.get(PROBABILITY_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(LIFETIME_LABEL_NAME));
        ComponentFabric.setupLabel3((JLabel) components.get(LIFETIME_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(SPEED_LABEL_NAME));
        ComponentFabric.setupLabel3((JLabel) components.get(SPEED_LABEL_NAME));

        ComponentFabric.setupHintTextField((HintTextField) components.get(WOODEN_INTERVAL_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(CAPITAL_INTERVAL_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(WOODEN_LIFETIME_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(CAPITAL_LIFETIME_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(WOODEN_SPEED_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(CAPITAL_SPEED_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(WOODEN_PROBABILITY_COMBOBOX));
        ComponentFabric.setupHintTextField((HintTextField) components.get(CAPITAL_PROBABILITY_COMBOBOX));

        ComponentFabric.setupControlButtonDark((ControlButton) components.get(SAVE_EXIT_BUTTON_NAME));
        ComponentFabric.setupControlButtonLight((ControlButton) components.get(RESTORE_BUTTON_NAME));

        components.get(WOODEN_BUILDINGS_IMAGE_NAME).add(new JLabel(new ImageIcon(
                WindowManager
                        .getImageFactory()
                        .getWoodenBuilding()
                        .getScaledInstance(50, 50, Image.SCALE_SMOOTH)
        )));
        components.get(WOODEN_BUILDINGS_IMAGE_NAME).setBackground(Style.getPrimaryLightColor());
        components.get(CAPITAL_BUILDINGS_IMAGE_NAME).add(new JLabel(new ImageIcon(
                WindowManager
                        .getImageFactory()
                        .getCapitalBuilding()
                        .getScaledInstance(50, 50, Image.SCALE_SMOOTH)
        )));
        components.get(CAPITAL_BUILDINGS_IMAGE_NAME).setBackground(Style.getPrimaryLightColor());

        setupActions();
    }

    private void setupActions() {
        SavePreferencesAction saveAndExit = new SavePreferencesAction(context);
        saveAndExit.addField((HintTextField) components.get(WOODEN_INTERVAL_FIELD_NAME));
        saveAndExit.addField((HintTextField) components.get(CAPITAL_INTERVAL_FIELD_NAME));
        saveAndExit.addField((HintTextField) components.get(WOODEN_LIFETIME_FIELD_NAME));
        saveAndExit.addField((HintTextField) components.get(CAPITAL_LIFETIME_FIELD_NAME));
        saveAndExit.addField((HintTextField) components.get(WOODEN_SPEED_FIELD_NAME));
        saveAndExit.addField((HintTextField) components.get(CAPITAL_SPEED_FIELD_NAME));

        ((ControlButton) components.get(SAVE_EXIT_BUTTON_NAME)).addActionListener(saveAndExit);
    }

    @Override
    public void draw() {
        frame.setJMenuBar(new CustomMenuBar(context));

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(createPageLabelPanel());

        rootPanel.add(createBuildingsTypesPanel());

        rootPanel.add(createFieldsLabelPanel(components.get(INTERVAL_LABEL_NAME)));
        rootPanel.add(createFields(components.get(WOODEN_INTERVAL_FIELD_NAME),
                components.get(CAPITAL_INTERVAL_FIELD_NAME)));

        rootPanel.add(createFieldsLabelPanel(components.get(PROBABILITY_LABEL_NAME)));
        rootPanel.add(createFields(components.get(WOODEN_PROBABILITY_COMBOBOX),
                components.get(CAPITAL_PROBABILITY_COMBOBOX)));

        rootPanel.add(createFieldsLabelPanel(components.get(LIFETIME_LABEL_NAME)));
        rootPanel.add(createFields(components.get(WOODEN_LIFETIME_FIELD_NAME),
                components.get(CAPITAL_LIFETIME_FIELD_NAME)));

        rootPanel.add(createFieldsLabelPanel(components.get(SPEED_LABEL_NAME)));
        rootPanel.add(createFields(components.get(WOODEN_SPEED_FIELD_NAME),
                components.get(CAPITAL_SPEED_FIELD_NAME)));

        rootPanel.add(createSaveExitButtonPanel());
        rootPanel.add(createRestoreButtonPanel());

        frame.add(rootPanel);
        frame.pack();
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

    private JPanel createFieldsLabelPanel(JComponent label) {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
//        panel.setBorder(new EmptyBorder(0, 0, -50, 0));
        panel.add(label);
        return panel;
    }

    private JPanel createFields(JComponent leftField, JComponent rightField) {
        JPanel setup = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        ComponentFabric.setupLightPanel(setup);
        ComponentFabric.setupLightPanel(leftPanel);
        ComponentFabric.setupLightPanel(rightPanel);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        leftPanel.add(leftField);
        rightPanel.add(rightField);

        setup.add(leftPanel);
        setup.add(Box.createHorizontalStrut(12));
        setup.add(rightPanel);

        return setup;
    }

    private JPanel createSaveExitButtonPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setBorder(new EmptyBorder(20, 0, 0, 0));
        panel.add(components.get(SAVE_EXIT_BUTTON_NAME));
        return panel;
    }

    private JPanel createRestoreButtonPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setBorder(new EmptyBorder(0, 0, 20, 0));
        panel.add(components.get(RESTORE_BUTTON_NAME));
        return panel;
    }

    private JPanel createBuildingsTypesPanel() {
        JPanel panel = new JPanel();
        JPanel woodenBuildingPanel = new JPanel();
        JPanel capitalBuildingPanel = new JPanel();

        ComponentFabric.setupLightPanel(panel);
        ComponentFabric.setupLightPanel(woodenBuildingPanel);
        ComponentFabric.setupLightPanel(capitalBuildingPanel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(0,12,0,12));
        woodenBuildingPanel.setLayout(new BoxLayout(woodenBuildingPanel, BoxLayout.X_AXIS));
        capitalBuildingPanel.setLayout(new BoxLayout(capitalBuildingPanel, BoxLayout.X_AXIS));

        woodenBuildingPanel.add(components.get(WOODEN_BUILDINGS_IMAGE_NAME));
        woodenBuildingPanel.add(components.get(WOODEN_LABEL_NAME));

        capitalBuildingPanel.add(components.get(CAPITAL_BUILDINGS_IMAGE_NAME));
        capitalBuildingPanel.add(components.get(CAPITAL_LABEL_NAME));

        panel.add(woodenBuildingPanel);
        panel.add(Box.createHorizontalStrut(12));
        panel.add(capitalBuildingPanel);

        return panel;
    }
}
