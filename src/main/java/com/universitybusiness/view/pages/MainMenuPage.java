package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.CreateButtonListener;
import com.universitybusiness.view.actions.PreferencesButtonListener;
import com.universitybusiness.view.components.ControlButton;
import com.universitybusiness.view.components.HintTextField;
import com.universitybusiness.view.fabrics.ComponentFabric;
import com.universitybusiness.view.menubar.CustomMenuBar;
import com.universitybusiness.view.util.StyleDto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainMenuPage extends Page implements IPage {
    // String constants
    private final String PAGE_LABEL_NAME =         "MainMenu";
    private final String WIDTH_LABEL_NAME =        "WidthLabel";
    private final String HEIGHT_LABEL_NAME =       "HeightLabel";
    private final String IMAGE_PANEL_NAME =        "Image";
    private final String WIDTH_FIELD_NAME =        "WidthTextField";
    private final String HEIGHT_FIELD_NAME =       "HeightTextField";
    private final String START_BUTTON_NAME =       "StartButton";
    private final String PREFERENCES_BUTTON_NAME = "PreferencesButton";

    public MainMenuPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }

    @Override
    public void initializeComponents() {
        final String PAGE_LABEL_TEXT = "Main menu";
        final String WIDTH_LABEL_TEXT = "Width";
        final String HEIGHT_LABEL_TEXT = "Height";
        final String TEXT_FIELDS_HINT = "500-1000";
        final String START_BUTTON_TEXT = "Start";
        final String PREFERENCES_BUTTON_TEXT = "Preferences";

        components.put(PAGE_LABEL_NAME, new JLabel(PAGE_LABEL_TEXT));
        components.put(WIDTH_LABEL_NAME, new JLabel(WIDTH_LABEL_TEXT));
        components.put(HEIGHT_LABEL_NAME, new JLabel(HEIGHT_LABEL_TEXT));

        components.put(IMAGE_PANEL_NAME, new JPanel());

        components.put(WIDTH_FIELD_NAME, new HintTextField(TEXT_FIELDS_HINT));
        components.put(HEIGHT_FIELD_NAME, new HintTextField(TEXT_FIELDS_HINT));

        components.put(START_BUTTON_NAME, new ControlButton(START_BUTTON_TEXT));
        components.put(PREFERENCES_BUTTON_NAME, new ControlButton(PREFERENCES_BUTTON_TEXT));

        setupActions();
    }

    private void setupActions() {
        CreateButtonListener createButtonListener = new CreateButtonListener(
                (HintTextField) components.get(WIDTH_FIELD_NAME),
                (HintTextField) components.get(HEIGHT_FIELD_NAME),
                context
        );

        PreferencesButtonListener preferencesButtonListener = new PreferencesButtonListener(context);

        ((ControlButton)components.get(START_BUTTON_NAME)).addActionListener(createButtonListener);
        ((ControlButton)components.get(PREFERENCES_BUTTON_NAME)).addActionListener(preferencesButtonListener);
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

        ComponentFabric.setupControlButtonDark((ControlButton) components.get(START_BUTTON_NAME));
        ComponentFabric.setupControlButtonDark((ControlButton) components.get(PREFERENCES_BUTTON_NAME));

        components.get(PREFERENCES_BUTTON_NAME).setBackground(StyleDto.getSecondaryDarkColor());
    }

    @Override
    public void draw() {
        frame.setJMenuBar(new CustomMenuBar(context));

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(createMainLabelPanel());
        rootPanel.add(components.get(IMAGE_PANEL_NAME));
        rootPanel.add(createSetupFields());
        rootPanel.add(createCreationButtonPanel());
        rootPanel.add(createPreferencesButtonPanel());

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

    private JPanel createCreationButtonPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setBorder(new EmptyBorder(20,0,0,0));

        panel.add(components.get(START_BUTTON_NAME));

        return panel;
    }

    private JPanel createPreferencesButtonPanel() {
        JPanel panel = new JPanel();
        ComponentFabric.setupLightPanel(panel);
        panel.setBorder(new EmptyBorder(0,0,20,0));

        // Add action listener, allows swap to preferences page

        panel.add(components.get(PREFERENCES_BUTTON_NAME));

        return panel;
    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        // No implementation
    }
}
