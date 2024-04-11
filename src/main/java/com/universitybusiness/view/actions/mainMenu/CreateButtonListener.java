package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.model.Habitat;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.textFilelds.HintTextField;

import javax.swing.*;
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
        }
    }

    private boolean verify() {
        boolean isValidWidth = verifyValue(width_field, 500, 1000);
        if (isValidWidth) {
            width = Integer.parseInt(width_field.getText());
        } else {
            width_field.setError();
            width_field.setText("500");
        }

        boolean isValidHeight = verifyValue(height_field, 500, 1000);
        if (isValidHeight) {
            height = Integer.parseInt(height_field.getText());
        } else {
            height_field.setError();
            height_field.setText("500");
        }

        return isValidHeight && isValidWidth;
    }

    private boolean verifyValue(HintTextField field, int min, int max) {
        boolean isValid = false;
        String text = field.getText();

        if (text != null && text.matches("\\d+")) {
            try {
                int value = Integer.parseInt(text);
                isValid = (value >= min && value <= max);
            } catch (Exception ignored) {}
        }

        return isValid;
    }

    private void nextScreen() {
        final Habitat instance = Habitat.getInstance();
        context.getController().setSimulationService(instance);
        context.getController().resetSimulation();
        instance.setSize(width, height);

        context.setWidth(width + 200);
        context.setHeight(height + 136);

        context.swapPage(WindowManager.Pages.SIMULATION);
    }
}
