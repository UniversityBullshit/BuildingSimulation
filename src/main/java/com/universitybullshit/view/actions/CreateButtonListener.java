package com.universitybullshit.view.actions;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.Area;
import com.universitybullshit.view.MainFrame;
import com.universitybullshit.view.MainMenu;
import com.universitybullshit.view.SimulationArea;
import com.universitybullshit.view.util.HintTextField;
import com.universitybullshit.view.util.KeyboardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.MalformedInputException;

public class CreateButtonListener implements ActionListener {
    private final HintTextField width;
    private final HintTextField height;
    private int width_i = 0;
    private int height_i = 0;
    private final JFrame context = MainMenu.getContext();
    private final JPanel root;
    public CreateButtonListener(HintTextField width, HintTextField height, JPanel root) {
        this.width = width;
        this.height = height;
        this.root = root;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (verify()) {
            nextScreen();
        }
    }

    private boolean verify() {
        boolean isValid = false;

        boolean isValidWidth = verifyWidth(this.width.getText());
        boolean isValidHeight = verifyHeight(this.height.getText());

        return isValidHeight && isValidWidth;
    }

    private boolean verifyWidth(String text) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            width_i = Integer.parseInt(text);
            isValid = (width_i >= 500 && width_i <= 1000);
        }

        if (isValid) {
            this.width.setBorderColor(Color.RED);
            this.width.repaint();
        }

        return isValid;
    }

    private boolean verifyHeight(String text) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            height_i = Integer.parseInt(text);
            isValid = (height_i >= 500 && height_i <= 1000);
        }

        if (!isValid) {
            this.height.setBorderColor(Color.RED);
            this.height.repaint();
        }

        return isValid;
    }

    private void nextScreen() {
        MainMenu.clearFrame();
        HabitatController controller = new HabitatController(this.width_i, this.height_i);
        Area area = new Area(this.width_i, this.height_i, this.root, controller);
        JRootPane rootPane = this.context.getRootPane();
        KeyboardInput.createKeyBindings(rootPane, controller, area);
        area.create();
    }
}
