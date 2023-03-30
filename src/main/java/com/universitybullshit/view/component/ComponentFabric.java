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

    public void setupConstraints(String name, Integer gridx, Integer gridy, Integer gridwidth, Integer gridheight, Integer fill, Integer anchor) {
        GridBagConstraints constraints = new GridBagConstraints();
        if (gridx != null) constraints.gridx = gridx;
        if (gridy != null) constraints.gridy = gridy;
        if (gridwidth != null) constraints.gridwidth = gridwidth;
        if (gridheight != null) constraints.gridheight = gridheight;
        if (fill != null) constraints.fill = fill;
        if (anchor != null) constraints.anchor = anchor;
        componentsList.get(name).add(constraints);
    }

    public <T> T getComponent(String key) {
        return (T) componentsList.get(key).get(0);
    }

    public <T> T getConstraints(String key) {
        return (T) componentsList.get(key).get(1);
    }
}
