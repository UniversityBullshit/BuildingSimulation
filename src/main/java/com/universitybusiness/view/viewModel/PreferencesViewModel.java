package com.universitybusiness.view.viewModel;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.view.components.combobox.ComboBox;
import com.universitybusiness.view.components.textFilelds.HintTextField;
import lombok.Setter;

import java.util.Objects;

public class PreferencesViewModel implements ViewModel {
    private interface SetValueOperation {
        void apply(long value);
    }

    private final Preferences preferences;

    @Setter
    private HintTextField woodenBuildingInterval;
    @Setter
    private HintTextField capitalBuildingInterval;
    @Setter
    private HintTextField woodenBuildingLifetime;
    @Setter
    private HintTextField capitalBuildingLifetime;
    @Setter
    private HintTextField woodenBuildingSpeed;
    @Setter
    private HintTextField capitalBuildingSpeed;
    @Setter
    private ComboBox<String> woodenBuildingProbability;
    @Setter
    private ComboBox<String> capitalBuildingProbability;

    public PreferencesViewModel(
            Preferences preferences
    ) {
        this.preferences = preferences;
    }

    /**
     * Method that try to save values to preferences
     * @return status of read and write operation
     */
    public boolean savePreferences() {
        boolean status = true;

        processWoodenBuildingProbability();
        processCapitalBuildingProbability();

        status &= processWoodenBuildingInterval();
        status &= processCapitalBuildingInterval();
        status &= processWoodenBuildingLifetime();
        status &= processCapitalBuildingLifetime();
        status &= processWoodenBuildingSpeed();
        status &= processCapitalBuildingSpeed();

        return status;
    }

    public void restoreDefaults() {
        preferences.restoreDefaults();
    }

    private boolean processWoodenBuildingInterval() {
        if (!verifyValue(woodenBuildingInterval, 500, 10000)) {
            processError(
                    woodenBuildingInterval,
                    Preferences.Defaults.WOODEN_BUILDING_INTERVAL,
                    preferences::setWoodenBuildingInterval
            );

            return false;
        }

        setValue(woodenBuildingInterval, preferences::setWoodenBuildingInterval);

        return true;
    }

    private boolean processCapitalBuildingInterval() {
        if (!verifyValue(capitalBuildingInterval, 500, 10000)) {
            processError(
                    capitalBuildingInterval,
                    Preferences.Defaults.CAPITAL_BUILDING_INTERVAL,
                    preferences::setCapitalBuildingInterval
            );

            return false;
        }

        setValue(capitalBuildingInterval, preferences::setCapitalBuildingInterval);

        return true;
    }

    private boolean processWoodenBuildingLifetime() {
        if (!verifyValue(woodenBuildingLifetime, 1, 1000)) {
            processError(
                    woodenBuildingLifetime,
                    Preferences.Defaults.WOODEN_BUILDING_LIFE_TIME,
                    preferences::setWoodenBuildingLifeTime,
                    1000
            );

            return false;
        }

        setValue(woodenBuildingLifetime, preferences::setWoodenBuildingLifeTime, 1000);

        return true;
    }

    private boolean processCapitalBuildingLifetime() {
        if (!verifyValue(capitalBuildingLifetime, 1, 1000)) {
            processError(
                    capitalBuildingLifetime,
                    Preferences.Defaults.CAPITAL_BUILDING_LIFE_TIME,
                    preferences::setCapitalBuildingLifeTime,
                    1000
            );

            return false;
        }

        setValue(capitalBuildingLifetime, preferences::setCapitalBuildingLifeTime, 1000);

        return true;
    }

    private boolean processWoodenBuildingSpeed() {
        if (!verifyValue(woodenBuildingSpeed, 1, 100)) {
            processError(
                    woodenBuildingSpeed,
                    Preferences.Defaults.WOODEN_BUILDING_SPEED,
                    preferences::setWoodenBuildingSpeed
            );

            return false;
        }

        setValue(woodenBuildingSpeed, preferences::setWoodenBuildingSpeed);

        return true;
    }

    private boolean processCapitalBuildingSpeed() {
        if (!verifyValue(capitalBuildingSpeed, 1, 100)) {
            processError(
                    capitalBuildingSpeed,
                    Preferences.Defaults.CAPITAL_BUILDING_SPEED,
                    preferences::setCapitalBuildingSpeed
            );

            return false;
        }

        setValue(capitalBuildingSpeed, preferences::setCapitalBuildingSpeed);

        return true;
    }

    private void processWoodenBuildingProbability() {
        if (woodenBuildingProbability == null || woodenBuildingProbability.getSelectedItem() == null) {
            return;
        }

        String item = woodenBuildingProbability.getSelectedItem().toString().replace("%", "");
        double value = Double.parseDouble(item) / 100;

        preferences.setWoodenBuildingProbability(value);
    }

    private void processCapitalBuildingProbability() {
        if (capitalBuildingProbability == null || capitalBuildingProbability.getSelectedItem() == null) {
            return;
        }

        String item = capitalBuildingProbability.getSelectedItem().toString().replace("%", "");
        double value = Double.parseDouble(item) / 100;

        preferences.setCapitalBuildingProbability(value);
    }

    private boolean verifyValue(HintTextField field, int min, int max) {
        if (field == null) {
            return false;
        }

        String text = field.getText();
        if (text != null && text.matches("\\d+")) {
            try {
                long value = Long.parseLong(text);
                return (value >= min && value <= max);
            } catch (Exception ignored) {
            }
        }

        return false;
    }

    private void setValue(HintTextField field, SetValueOperation operation) {
        operation.apply(Long.parseLong(field.getText()));
    }

    private void setValue(HintTextField field, SetValueOperation operation, long multiplier) {
        operation.apply(Long.parseLong(field.getText()) * multiplier);
    }

    private void processError(HintTextField field, long defaultValue, SetValueOperation operation) {
        field.setError();
        field.setText(String.valueOf(defaultValue));
        operation.apply(defaultValue);
    }

    private void processError(HintTextField field, long defaultValue, SetValueOperation operation, long multiplier) {
        field.setError();
        field.setText(String.valueOf(defaultValue / 1000));
        operation.apply(defaultValue);
    }
}
