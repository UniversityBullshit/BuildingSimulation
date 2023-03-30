package com.universitybullshit.view.component;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ComponentFabric {
    private final Map<String, ArrayList<Object>> componentsList = new HashMap<>();
    public <T> void createComponent(T component, String name) {
        componentsList.put(name, new ArrayList<>());
        componentsList.get(name).add(component);
    }


    public void setupConstraints(String name, HashMap<String, Integer> args) {
        GridBagConstraints constraints = new GridBagConstraints();
        if (args.get("gridx") != null) constraints.gridx = args.get("gridx");
        if (args.get("gridy") != null) constraints.gridy = args.get("gridy");
        if (args.get("gridwidth") != null) constraints.gridwidth = args.get("gridwidth");
        if (args.get("gridheight") != null) constraints.gridheight = args.get("gridheight");
        if (args.get("fill") != null) constraints.fill = args.get("fill");
        if (args.get("anchor") != null) constraints.anchor = args.get("anchor");
        componentsList.get(name).add(constraints);
    }

    public <T> T getComponent(String key) {
        return (T) componentsList.get(key).get(0);
    }

    public <T> T getConstraints(String key) {
        return (T) componentsList.get(key).get(1);
    }
}
