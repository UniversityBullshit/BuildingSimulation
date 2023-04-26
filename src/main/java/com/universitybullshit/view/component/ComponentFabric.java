package com.universitybullshit.view.component;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ComponentFabric {
    private final Map<String, ArrayList<Object>> componentsList = new HashMap<>();
    private static final FontFactory fontFactory = new FontFactory();
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

    public static void setupControlButtonDark(ControlButton button) {
        button.setColorOver(new Color(20,20,20));
        button.setColor(Color.BLACK);
        button.setColorClick(new Color(80,80,80));
        button.setRadius(20);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBorder(new EmptyBorder(5,10,5,10));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 18));
    }
    public static void setupControlButtonLight(ControlButton button) {
        button.setColorOver(new Color(240,240,240));
        button.setColor(Color.WHITE);
        button.setColorClick(new Color(225,225,225));
        button.setBorderColor(Color.WHITE);
        button.setRadius(20);
        button.setPreferredSize(new Dimension(160, 30));
        button.setBorder((new EmptyBorder(5,10,5,10)));
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setFont(fontFactory.getKadwaRegularFont().deriveFont(Font.PLAIN, 18));
    }
}
