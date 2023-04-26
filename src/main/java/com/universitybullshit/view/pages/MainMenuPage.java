package com.universitybullshit.view.pages;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.actions.CreateButtonListener;
import com.universitybullshit.view.component.ControlButton;
import com.universitybullshit.view.component.HintTextField;
import com.universitybullshit.view.fabrics.ComponentFabric;
import com.universitybullshit.view.util.StyleDto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainMenuPage implements IPage {
    private final JFrame frame;
    private final Map<String, JComponent> components;


    // String constants
    private final String PAGE_LABEL_NAME =         "MainMenu";
    private final String WIDTH_LABEL_NAME =        "WidthLabel";
    private final String HEIGHT_LABEL_NAME =       "HeightLabel";
    private final String IMAGE_PANEL_NAME =        "Image";
    private final String WIDTH_FIELD_NAME =        "WidthTextField";
    private final String HEIGHT_FIELD_NAME =       "HeightTextField";
    private final String CREATE_BUTTON_NAME =      "CreateButton";
    private final String PREFERENCES_BUTTON_NAME = "PreferencesButton";

    public MainMenuPage(JFrame frame) {
        this.frame = frame;
        components = new HashMap<>();

        initializeComponents();
        setupAppearance();
    }

    @Override
    public void initializeComponents() {
        final String PAGE_LABEL_TEXT =         "Main menu";
        final String WIDTH_LABEL_TEXT =        "Width";
        final String HEIGHT_LABEL_TEXT =       "Height";
        final String TEXT_FIELDS_HINT =        "500-1000";
        final String CREATE_BUTTON_TEXT =      "Create";
        final String PREFERENCES_BUTTON_TEXT = "Preferences";

        components.put(PAGE_LABEL_NAME, new JLabel(PAGE_LABEL_TEXT));
        components.put(WIDTH_LABEL_NAME, new JLabel(WIDTH_LABEL_TEXT));
        components.put(HEIGHT_LABEL_NAME, new JLabel(HEIGHT_LABEL_TEXT));

        components.put(IMAGE_PANEL_NAME, new JPanel());

        components.put(WIDTH_FIELD_NAME, new HintTextField(TEXT_FIELDS_HINT));
        components.put(HEIGHT_FIELD_NAME, new HintTextField(TEXT_FIELDS_HINT));

        components.put(CREATE_BUTTON_NAME, new ControlButton(CREATE_BUTTON_TEXT));
        components.put(PREFERENCES_BUTTON_NAME, new ControlButton(PREFERENCES_BUTTON_TEXT));
    }

    @Override
    public void setupAppearance() {
        ComponentFabric.setupLabel1((JLabel) components.get(PAGE_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(PAGE_LABEL_NAME));

        ComponentFabric.setupLabel3((JLabel) components.get(WIDTH_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(WIDTH_LABEL_NAME));

        ComponentFabric.setupLabel3((JLabel) components.get(HEIGHT_LABEL_NAME));
        ComponentFabric.setupDarkLabel((JLabel) components.get(HEIGHT_LABEL_NAME));

        components.get(IMAGE_PANEL_NAME).add(new JLabel(new ImageIcon(
                WindowManager.
                        getImageFactory().
                        getMainMenuImage().
                        getScaledInstance(420, 280, Image.SCALE_SMOOTH)
        )));
        components.get(IMAGE_PANEL_NAME).setBackground(StyleDto.getPrimaryLightColor());

        ComponentFabric.setupHintTextField((HintTextField) components.get(WIDTH_FIELD_NAME));
        ComponentFabric.setupHintTextField((HintTextField) components.get(HEIGHT_FIELD_NAME));

        ComponentFabric.setupControlButtonDark((ControlButton) components.get(CREATE_BUTTON_NAME));
        ComponentFabric.setupControlButtonDark((ControlButton) components.get(PREFERENCES_BUTTON_NAME));

        components.get(PREFERENCES_BUTTON_NAME).setBackground(StyleDto.getSecondaryDarkColor());
    }

    @Override
    public void draw() {
        frame.setSize(400,650);
        frame.setLocationRelativeTo(null);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(createMainLabelPanel());
        rootPanel.add(components.get(IMAGE_PANEL_NAME));
        rootPanel.add(createSetupFields());
        rootPanel.add(createCreationButtonPanel(rootPanel));
        rootPanel.add(createPreferencesButtonPanel(rootPanel));

        frame.add(rootPanel);
        frame.pack();
        frame.requestFocusInWindow();
    }

    private JPanel createMainLabelPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.add(components.get(PAGE_LABEL_NAME));
        return panel;
    }

    private JPanel createSetupFields() {
        JPanel setup = new JPanel();
        JPanel width = new JPanel();
        JPanel height = new JPanel();

        ComponentFabric.setupLightPanel(setup);
        ComponentFabric.setupLightPanel(width);
        ComponentFabric.setupLightPanel(height);

        width.setLayout(new BoxLayout(width, BoxLayout.Y_AXIS));
        height.setLayout(new BoxLayout(height, BoxLayout.Y_AXIS));

        width.add(components.get(WIDTH_LABEL_NAME));
        width.add(components.get(WIDTH_FIELD_NAME));

        height.add(components.get(HEIGHT_LABEL_NAME));
        height.add(components.get(HEIGHT_FIELD_NAME));

        setup.add(width);
        setup.add(Box.createHorizontalStrut(23));
        setup.add(height);

        return setup;
    }

    private JPanel createCreationButtonPanel(JPanel rootPanel) {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setBorder(new EmptyBorder(20,0,0,0));

        CreateButtonListener createButtonListener = new CreateButtonListener(
                (HintTextField) components.get(WIDTH_FIELD_NAME),
                (HintTextField) components.get(HEIGHT_FIELD_NAME),
                rootPanel
        );

        ((ControlButton)components.get(CREATE_BUTTON_NAME)).addActionListener(createButtonListener);
        panel.add(components.get(CREATE_BUTTON_NAME));

        return panel;
    }

    private JPanel createPreferencesButtonPanel(JPanel rootPanel) {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setBorder(new EmptyBorder(0,0,20,0));

        // Add action listener, allows swap to preferences page

        panel.add(components.get(PREFERENCES_BUTTON_NAME));

        return panel;
    }
}
