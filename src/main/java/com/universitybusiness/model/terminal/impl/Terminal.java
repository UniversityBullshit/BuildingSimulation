package com.universitybusiness.model.terminal.impl;

import com.universitybusiness.model.terminal.IProgram;

import java.util.HashMap;

public class Terminal implements IProgram {
    private static Terminal instance;
    private final HashMap<String, IProgram> programPalette;

    private Terminal() {
        programPalette = new HashMap<>();

        programPalette.put("help", new HelpProgram());
        programPalette.put("preferences", new PreferencesProgram());
    }

    public static Terminal getInstance() {
        if (instance == null) {
            instance = new Terminal();
        }

        return instance;
    }

    @Override
    public String execute(String command) {
        if (command == null || command.isEmpty()) {
            return "";
        }

        String program = getProgram(command);

        if (!programPalette.containsKey(program)) {
            return "Unknown command: " + program;
        }

        return programPalette.get(program).execute(getParameter(command));
    }

    private String getProgram(String command) {
        return command.split(" ")[0];
    }

    private String getParameter(String command) {
        if (!command.contains(" ")) {
            return "";
        }

        return command.substring(command.indexOf(" ") + 1);
    }
}
