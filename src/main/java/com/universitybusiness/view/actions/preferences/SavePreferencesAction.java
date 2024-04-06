package com.universitybusiness.view.actions.preferences;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.common.BackToMenuAction;
import com.universitybusiness.view.components.combobox.ComboBox;
import com.universitybusiness.view.components.textFilelds.HintTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

public class SavePreferencesAction extends AbstractAction {
    private final WindowManager windowManager;
    private final ArrayList<HintTextField> fields;
    private final ArrayList<ComboBox<String>> comboBoxes;
    private final BackToMenuAction backToMenuAction;

    public SavePreferencesAction(WindowManager windowManager) {
        this.windowManager = windowManager;
        fields = new ArrayList<>();
        comboBoxes = new ArrayList<>();
        backToMenuAction = new BackToMenuAction(windowManager);
    }

    public void addField(HintTextField field) {
        fields.add(field);
    }

    public void addComboBox(ComboBox<String> comboBox) { comboBoxes.add(comboBox); }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (processFields()) {
            backToMenuAction.actionPerformed(e);
        } else {
            showErrorMessage();
        }
    }

    private boolean processFields() {
        // Process textFields
        boolean woodenSpawnInterval = verifyValue(fields.get(0), 500, 10000);
        if (!woodenSpawnInterval) {
            fields.get(0).setError();
            fields.get(0).setText(String.valueOf(Preferences.DEFAULT_WOODEN_BUILDING_INTERVAL));
            Preferences.setWoodenBuildingInterval(Preferences.DEFAULT_WOODEN_BUILDING_INTERVAL);
        } else {
            Preferences.setWoodenBuildingInterval(Integer.parseInt(fields.get(0).getText()));
        }

        boolean capitalSpawnInterval = verifyValue(fields.get(1), 500, 10000);
        if (!capitalSpawnInterval) {
            fields.get(1).setError();
            fields.get(1).setText(String.valueOf(Preferences.DEFAULT_CAPITAL_BUILDING_INTERVAL));
            Preferences.setCapitalBuildingInterval(Preferences.DEFAULT_CAPITAL_BUILDING_INTERVAL);
        } else {
            Preferences.setCapitalBuildingInterval(Integer.parseInt(fields.get(1).getText()));
        }

        boolean woodenLifeTime = verifyValue(fields.get(2), 1, 1000);
        if (!woodenLifeTime) {
            fields.get(2).setError();
            fields.get(2).setText(String.valueOf(Preferences.DEFAULT_WOODEN_BUILDING_LIFE_TIME));
            Preferences.setWoodenBuildingLifeTime(Preferences.DEFAULT_WOODEN_BUILDING_LIFE_TIME);
        } else {
            Preferences.setWoodenBuildingLifeTime(Integer.parseInt(fields.get(2).getText()) * 1000L);
        }

        boolean capitalLifeTime = verifyValue(fields.get(3), 1, 1000);
        if (!capitalLifeTime) {
            fields.get(3).setError();
            fields.get(3).setText(String.valueOf(Preferences.DEFAULT_CAPITAL_BUILDING_LIFE_TIME));
            Preferences.setCapitalBuildingLifeTime(Preferences.DEFAULT_CAPITAL_BUILDING_LIFE_TIME);
        } else {
            Preferences.setCapitalBuildingLifeTime(Integer.parseInt(fields.get(3).getText()) * 1000L);
        }

        boolean woodenMovementSpeed = verifyValue(fields.get(4), 1, 100);
        if (!woodenMovementSpeed) {
            fields.get(4).setError();
            fields.get(4).setText(String.valueOf(Preferences.DEFAULT_WOODEN_BUILDING_SPEED));
            Preferences.setWoodenBuildingSpeed(Preferences.DEFAULT_WOODEN_BUILDING_SPEED);
        } else {
            Preferences.setWoodenBuildingSpeed(Integer.parseInt(fields.get(4).getText()));
        }

        boolean capitalMovementSpeed = verifyValue(fields.get(5), 1, 100);
        if (!capitalMovementSpeed) {
            fields.get(5).setError();
            fields.get(5).setText(String.valueOf(Preferences.DEFAULT_CAPITAL_BUILDING_SPEED));
            Preferences.setCapitalBuildingSpeed(Preferences.DEFAULT_CAPITAL_BUILDING_SPEED);
        } else {
            Preferences.setCapitalBuildingSpeed(Integer.parseInt(fields.get(5).getText()));
        }

        // Process comboBoxes
        String woodenBuildingProbability = Objects.requireNonNull(comboBoxes.get(0).getSelectedItem())
                .toString().replace("%", "");
        String capitalBuildingProbability = Objects.requireNonNull(comboBoxes.get(1).getSelectedItem())
                .toString().replace("%", "");

        Preferences.setWoodenBuildingProbability(Double.parseDouble(woodenBuildingProbability) / 100);
        Preferences.setCapitalBuildingProbability(Double.parseDouble(capitalBuildingProbability) / 100);

        return woodenSpawnInterval && capitalSpawnInterval && woodenLifeTime && capitalLifeTime &&
                woodenMovementSpeed && capitalMovementSpeed;
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

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(windowManager.getMainFrame(),
                new String[] {"Incorrect values:\n" +
                        "Spawn Interval: 500-10000(ms)\n" +
                        "Life Time: 1-1000(s)\n"+
                        "Movement Speed 1-100(pts/s)"});
    }
}
