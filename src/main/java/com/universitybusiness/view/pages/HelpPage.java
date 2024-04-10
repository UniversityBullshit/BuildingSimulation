package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HelpPage extends Page {
    private final String PROGRAM_NAME_LABEL = "ProgramName";
    private final String PROGRAM_VERSION_LABEL = "Version";
    private final String PROGRAM_AUTHORS_LABEL = "Authors";
    private final String IMAGE_LABEL = "Image";

    public HelpPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }

    @Override
    public void initializeComponents() {
        components.put(PROGRAM_NAME_LABEL, new JLabel("BuildingSpawner"));
        components.put(PROGRAM_VERSION_LABEL, new JLabel("1.0"));
        components.put(PROGRAM_AUTHORS_LABEL, new JLabel("Authors: Sergei Cheremisin, Arounte"));
        components.put(IMAGE_LABEL, new JLabel(
            new ImageIcon(
                WindowManager.getImageFactory().getItDeprecated().getScaledInstance(115, 42, Image.SCALE_SMOOTH)
            )
        ));
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
        dialog.setSize(240, 180);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());

        rootPanel.add(createImagePanel(), BorderLayout.NORTH);
        rootPanel.add(createAboutPanel(), BorderLayout.CENTER);

        dialog.add(rootPanel);
    }

    private JPanel createImagePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(15, 0, 0, 0)));

        panel.add(components.get(IMAGE_LABEL));

        return panel;
    }

    private JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 0, 0)));

        panel.add(components.get(PROGRAM_NAME_LABEL));
        panel.add(components.get(PROGRAM_VERSION_LABEL));
        panel.add(components.get(PROGRAM_AUTHORS_LABEL));

        return panel;
    }
}
