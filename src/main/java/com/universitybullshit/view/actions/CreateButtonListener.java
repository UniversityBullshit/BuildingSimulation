package com.universitybullshit.view.actions;

import com.universitybullshit.view.MainMenu;
import com.universitybullshit.view.SimulationWindow;
import com.universitybullshit.view.component.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButtonListener implements ActionListener {
    private final HintTextField width_field;
    private final HintTextField height_field;
    private int width = 0;
    private int height = 0;
    private final JFrame context = MainMenu.getContext();
    private final JPanel root;
    public CreateButtonListener(HintTextField width_field, HintTextField height_field, JPanel root) {
        this.width_field = width_field;
        this.height_field = height_field;
        this.root = root;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (verify()) {
            nextScreen();
        }
    }

    private boolean verify() {
        boolean isValidWidth = verifyWidth(this.width_field.getText());
        boolean isValidHeight = verifyHeight(this.height_field.getText());

        return isValidHeight && isValidWidth;
    }

    private boolean verifyWidth(String text) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            width = Integer.parseInt(text);
            isValid = (width >= 500 && width <= 1000);
        }

        if (!isValid) {
            this.width_field.setBorderColor(Color.RED);
            this.width_field.repaint();
        }

        return isValid;
    }

    private boolean verifyHeight(String text) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            height = Integer.parseInt(text);
            isValid = (height >= 500 && height <= 1000);
        }

        if (!isValid) {
            this.height_field.setBorderColor(Color.RED);
            this.height_field.repaint();
        }

        return isValid;
    }

    private void nextScreen() {
        MainMenu.clearFrame();
        SimulationWindow.draw(this.context, this.width, this.height);
    }
}
