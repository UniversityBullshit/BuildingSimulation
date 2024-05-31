package com.universitybusiness.model.terminal.impl;

import com.universitybusiness.model.Preferences;
import com.universitybusiness.model.terminal.IProgram;

import java.util.HashMap;
import java.util.function.Function;

public class PreferencesProgram implements IProgram {
    private final HashMap<String, Function<String, String>> getCommandPalette;
    private final HashMap<String, Function<String, String>> setCommandPalette;

    public PreferencesProgram() {
        getCommandPalette = new HashMap<>();
        setCommandPalette = new HashMap<>();

        getCommandPalette.put("woodenBuildingSpeed", this::getWoodenBuildingSpeed);
        getCommandPalette.put("capitalBuildingSpeed", this::getCapitalBuildingSpeed);
        getCommandPalette.put("woodenBuildingInterval", this::getWoodenBuildingInterval);
        getCommandPalette.put("capitalBuildingInterval", this::getCapitalBuildingInterval);
        getCommandPalette.put("woodenBuildingProbability", this::getWoodenBuildingProbability);
        getCommandPalette.put("capitalBuildingProbability", this::getCapitalBuildingProbability);
        getCommandPalette.put("woodenBuildingLifeTime", this::getWoodenBuildingLifeTime);
        getCommandPalette.put("capitalBuildingLifeTime", this::getCapitalBuildingLifeTime);
        getCommandPalette.put("woodenBuildingAIPriority", this::getWoodenBuildingAIPriority);
        getCommandPalette.put("capitalBuildingAIPriority", this::getCapitalBuildingAIPriority);

        setCommandPalette.put("woodenBuildingSpeed", this::setWoodenBuildingSpeed);
        setCommandPalette.put("capitalBuildingSpeed", this::setCapitalBuildingSpeed);
        setCommandPalette.put("woodenBuildingInterval", this::setWoodenBuildingInterval);
        setCommandPalette.put("capitalBuildingInterval", this::setCapitalBuildingInterval);
        setCommandPalette.put("woodenBuildingProbability", this::setWoodenBuildingProbability);
        setCommandPalette.put("capitalBuildingProbability", this::setCapitalBuildingProbability);
        setCommandPalette.put("woodenBuildingLifeTime", this::setWoodenBuildingLifeTime);
        setCommandPalette.put("capitalBuildingLifeTime", this::setCapitalBuildingLifeTime);
        setCommandPalette.put("woodenBuildingAIPriority", this::setWoodenBuildingAIPriority);
        setCommandPalette.put("capitalBuildingAIPriority", this::setCapitalBuildingAIPriority);
    }

    @Override
    public String execute(String command) {
        if (command == null || command.isEmpty()) {
            return "No parameter given\n" +
                    "Use 'help preferences' to get list of available parameters";
        }

        String parameter = command.split(" ")[0];
        if (!getCommandPalette.containsKey(parameter)) {
            return "Unknown parameter of 'preferences': " + command + "\n" +
                    "Use 'help preferences' to get list of available parameters";
        }

        if (command.split(" ").length == 1 ||
            (!command.split(" ")[1].equals("set") ) && (!command.split(" ")[1].equals("get"))) {
            return "Choose 'set' or 'get' action after parameter "  + parameter;
        }

        String action = command.split(" ")[1];
        if (action.equals("get")) {
            return getCommandPalette.get(parameter).apply(null);
        }

        if (command.split(" ").length < 3) {
            return "Number must be given after 'set' action";
        }

        try {
            Double.parseDouble(command.split(" ")[2]);
        } catch (NumberFormatException e) {
            return "Number must be given after 'set' action";
        }

        String result = setCommandPalette.get(parameter).apply(command.split(" ")[2]);
        Preferences.getInstance().save();

        return result;
    }

    private String getWoodenBuildingProbability(String unused) {
        return  "Current wooden building probability: " +
                Preferences.getInstance().getWoodenBuildingProbability();
    }

    private String getCapitalBuildingProbability(String unused) {
        return "Current capital building probability: " +
                Preferences.getInstance().getCapitalBuildingProbability();
    }

    private String getWoodenBuildingInterval(String unused) {
        return "Current wooden building interval: " +
                Preferences.getInstance().getWoodenBuildingInterval();
    }

    private String getCapitalBuildingInterval(String unused) {
        return "Current capital building interval: " +
                Preferences.getInstance().getCapitalBuildingInterval();
    }

    private String getWoodenBuildingLifeTime(String unused) {
        return "Current wooden building life time: " +
                Preferences.getInstance().getWoodenBuildingLifeTime();
    }

    private String getCapitalBuildingLifeTime(String unused) {
        return "Current capital building life time: " +
                Preferences.getInstance().getCapitalBuildingLifeTime();
    }

    private String getWoodenBuildingAIPriority(String unused) {
        return "Current wooden building AI priority: " +
                Preferences.getInstance().getWoodenBuildingAIPriority();
    }

    private String getCapitalBuildingAIPriority(String unused) {
        return "Current capital building AI priority: " +
                Preferences.getInstance().getCapitalBuildingAIPriority();
    }

    private String getWoodenBuildingSpeed(String unused) {
        return "Current wooden building speed: " +
                Preferences.getInstance().getWoodenBuildingSpeed();
    }

    private String getCapitalBuildingSpeed(String unused) {
        return "Current capital building speed: " +
                Preferences.getInstance().getCapitalBuildingSpeed();
    }

    private String setWoodenBuildingProbability(String probability) {
        try {
            Preferences.getInstance().setWoodenBuildingProbability(Double.parseDouble(probability) / 100);
        } catch (NumberFormatException e) {
            return "Probability must be a number between 0 and 100";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set wooden building probability to " + probability;
    }

    private String setCapitalBuildingProbability(String probability) {
        try {
            Preferences.getInstance().setCapitalBuildingProbability(Double.parseDouble(probability) / 100);
        } catch (NumberFormatException e) {
            return "Probability must be a number between 0 and 100";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set capital building probability to " + probability;
    }

    private String setWoodenBuildingInterval(String interval) {
        try {
            Preferences.getInstance().setWoodenBuildingInterval(Long.parseLong(interval));
        } catch (NumberFormatException e) {
            return "Interval must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set wooden building interval to " + interval;
    }

    private String setCapitalBuildingInterval(String interval) {
        try {
            Preferences.getInstance().setCapitalBuildingInterval(Long.parseLong(interval));
        } catch (NumberFormatException e) {
            return "Interval must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set capital building interval to " + interval;
    }

    private String setWoodenBuildingLifeTime(String lifeTime) {
        try {
            Preferences.getInstance().setWoodenBuildingLifeTime(Long.parseLong(lifeTime));
        } catch (NumberFormatException e) {
            return "Life time must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set wooden building life time to " + lifeTime;
    }

    private String setCapitalBuildingLifeTime(String lifeTime) {
        try {
            Preferences.getInstance().setCapitalBuildingLifeTime(Long.parseLong(lifeTime));
        } catch (NumberFormatException e) {
            return "Life time must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set capital building life time to " + lifeTime;
    }

    private String setWoodenBuildingSpeed(String speed) {
        try {
            Preferences.getInstance().setWoodenBuildingSpeed(Long.parseLong(speed));
        } catch (NumberFormatException e) {
            return "Speed must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set wooden building speed to " + speed;
    }

    private String setCapitalBuildingSpeed(String speed) {
        try {
            Preferences.getInstance().setCapitalBuildingSpeed(Long.parseLong(speed));
        } catch (NumberFormatException e) {
            return "Speed must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set capital building speed to " + speed;
    }

    private String setWoodenBuildingAIPriority(String priority) {
        try {
            Preferences.getInstance().setWoodenBuildingAIPriority(Integer.parseInt(priority));
        } catch (NumberFormatException e) {
            return "Priority must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set wooden building AI priority to " + priority;
    }

    private String setCapitalBuildingAIPriority(String priority) {
        try {
            Preferences.getInstance().setCapitalBuildingAIPriority(Integer.parseInt(priority));
        } catch (NumberFormatException e) {
            return "Priority must be a whole number";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Set capital building AI priority to " + priority;
    }

    public static String getHelp(Void unused) {
        return "List of available parameters:\n" +
                "woodenBuildingSpeed - manage speed of wooden building\n" +
                "capitalBuildingSpeed - manage speed of capital building\n" +
                "woodenBuildingInterval - manage interval of wooden building\n" +
                "capitalBuildingInterval - manage interval of capital building\n" +
                "woodenBuildingProbability - manage probability of wooden building\n" +
                "capitalBuildingProbability - manage probability of capital building\n" +
                "woodenBuildingLifeTime - manage lifetime of wooden building\n" +
                "capitalBuildingLifeTime - manage lifetime of capital building\n" +
                "woodenBuildingAIPriority - manage priority of wooden building AI\n" +
                "capitalBuildingAIPriority - manage priority of capital building AI";
    }
}
