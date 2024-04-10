package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ControlsPage extends Page {
    private final String TITLE_LABEL = "Title";
    private final String B_BUTTON_LABEL = "B";
    private final String E_BUTTON_LABEL = "E";
    private final String T_BUTTON_LABEL = "T";
    public ControlsPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }

    @Override
    public void initializeComponents() {
        components.put(TITLE_LABEL, new JLabel("Controls"));
        components.put(B_BUTTON_LABEL, new JLabel("'B' to start"));
        components.put(E_BUTTON_LABEL, new JLabel("'E' to stop"));
        components.put(T_BUTTON_LABEL, new JLabel("'T' to toggle time"));
    }

    @Override
    public void setupAppearance() {

    }

    @Override
    public void draw() {
        // No implementation
    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        dialog.setSize(240, 120);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        rootPanel.setBorder(new EmptyBorder(new Insets(10, 10, 0, 0)));

        rootPanel.add(components.get(TITLE_LABEL));
        rootPanel.add(components.get(B_BUTTON_LABEL));
        rootPanel.add(components.get(E_BUTTON_LABEL));
        rootPanel.add(components.get(T_BUTTON_LABEL));

        dialog.add(rootPanel);
    }
}
