package com.universitybusiness.model.terminal.impl;

import com.universitybusiness.model.terminal.IProgram;

import java.util.HashMap;
import java.util.function.Function;

public class HelpProgram implements IProgram {
    private final HashMap<String, Function<Void, String>> programList;
    public HelpProgram() {
        programList = new HashMap<>();

        programList.put("preferences", PreferencesProgram::getHelp);
    }

    @Override
    public String execute(String program) {
        if (program == null || program.isEmpty()) {
            return "List of available commands: \n" +
                    "help - returns list of available commands\n" +
                    "preferences - allows control of program parameters";
        }

        if (!programList.containsKey(program)) {
            return "Unknown program: " + program;
        }

        return programList.get(program).apply(null);
    }
}
