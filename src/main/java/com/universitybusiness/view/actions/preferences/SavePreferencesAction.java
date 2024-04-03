package com.universitybusiness.view.actions.preferences;

import com.universitybusiness.model.util.BuildingData;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.textFilelds.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SavePreferencesAction extends AbstractAction {
    private final WindowManager context;
    private final ArrayList<HintTextField> fields;
    private final ArrayList<Integer> values;

    public SavePreferencesAction(WindowManager context) {
        this.context = context;
        this.fields = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void addField(HintTextField field) {
        fields.add(field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (verify()) {
            setValues();
            nextScreen();
        } else {
            showErrorMessage();
        }
    }

    private void setValues() {
        BuildingData.setWoodenBuildingInterval(values.get(0));
        BuildingData.setCapitalBuildingInterval(values.get(1));
        BuildingData.setWoodenBuildingLifeTime(values.get(2) * 1000);
        BuildingData.setCapitalBuildingLifeTime(values.get(3) * 1000);
    }

    private void nextScreen() {
        context.swapPage(WindowManager.getMAIN_MENU_PAGE());
    }

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(context.getMainFrame(),
                new String[] {"Incorrect values:\n" +
                        "Spawn Interval: 500-10000(ms)\n" +
                        "Life Time: 1-1000(s)\n"+
                        "Movement Speed 1-100(pts/s)"});
        fields.get(0).setText("2000");
        fields.get(1).setText("3000");
        fields.get(2).setText("30");
        fields.get(3).setText("90");
        fields.get(4).setText("5");
        fields.get(5).setText("5");
    }

    private boolean verify() {
        boolean woodenSpawnInterval = verifySpawnInterval(fields.get(0).getText(), 0);
        boolean capitalSpawnInterval = verifySpawnInterval(fields.get(1).getText(), 1);
        boolean woodenLifeTime = verifyLifeTime(fields.get(2).getText(), 2);
        boolean capitalLifeTime = verifyLifeTime(fields.get(3).getText(), 3);
        boolean woodenMovementSpeed = verifyMovementSpeed(fields.get(4).getText(), 4);
        boolean capitalMovementSpeed = verifyMovementSpeed(fields.get(5).getText(), 5);

        return woodenSpawnInterval && capitalSpawnInterval && woodenLifeTime && capitalLifeTime &&
                woodenMovementSpeed && capitalMovementSpeed;
    }

    private boolean verifySpawnInterval(String text, int index) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            values.add(Integer.parseInt(text));
            isValid = (values.get(index) >= 500 && values.get(index) <= 10000);
        }

        if (!isValid) {
            fields.get(index).setError();
        }

        return isValid;
    }

    private boolean verifyLifeTime(String text, int index) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            values.add(Integer.parseInt(text));
            isValid = (values.get(index) >= 1 && values.get(index) <= 1000);
        }

        if (!isValid) {
            fields.get(index).setError();
        }

        return isValid;
    }

    private boolean verifyMovementSpeed(String text, int index) {
        boolean isValid = false;

        if (text != null && text.matches("\\d+")) {
            values.add(Integer.parseInt(text));
            isValid = (values.get(index) >= 1 && values.get(index) <= 100);
        }

        if (!isValid) {
            fields.get(index).setError();
        }

        return isValid;
    }
}
