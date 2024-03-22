package com.universitybullshit.view.actions;

import com.universitybullshit.model.Habitat;
import com.universitybullshit.model.IHabitat;
import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.components.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButtonListener implements ActionListener {
    private final HintTextField width_field;
    private final HintTextField height_field;
    private int width = 0;
    private int height = 0;
    private final WindowManager context;
    public CreateButtonListener(HintTextField width_field, HintTextField height_field, WindowManager context) {
        this.width_field = width_field;
        this.height_field = height_field;
        this.context = context;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (verify()) {
            nextScreen();
        } else {
            JOptionPane.showMessageDialog(context.getMainFrame(),
                    new String[] {"Некорректное значение размерности. Допустимые значения:\n" +
                                    "Ширина: 500-1000\n" +
                                    "Высота: 500-1000"});
            width_field.setText("500");
            height_field.setText("500");
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
        final Habitat instance = Habitat.getInstance();
        instance.reset();
        instance.setSize(width, height);

        context.getController().setContext(instance);

        context.setWidth(width + 200);
        context.setHeight(height + 64);

        context.swapPage(WindowManager.getSIMULATION_PAGE());
    }
}
