package com.universitybusiness.view.viewModel;

import java.util.ArrayList;
import java.util.Iterator;

public class TerminalViewModel implements ViewModel {
    private final ArrayList<String> history = new ArrayList<>();

    private int currentItem = 0;

    public void addCommand(String command) {
        history.add(command);
        currentItem = history.size();
    }

    public String getPreviousCommand() {
        if (!history.isEmpty()) {
            if (currentItem > 0) {
                return history.get(--currentItem);
            }

            return history.get(0);
        }

        return "";
    }

    public String getNextCommand() {
        if (!history.isEmpty()) {
            if (currentItem < history.size()) {
                return history.get(++currentItem);
            }
        }

        return "";
    }
}
