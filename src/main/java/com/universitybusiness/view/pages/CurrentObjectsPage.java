package com.universitybusiness.view.pages;

import com.universitybusiness.model.Habitat;
import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.TreeMap;

public class CurrentObjectsPage extends Page implements IPage {
    private final TreeMap<Long, Long> spawnTimeMap;
    private final String TABLE_NAME = "Table";
    private final String SCROLL_PANE_NAME = "ScrollPane";
    private final String KEY = "Key";
    private final String VALUE = "Spawn time";
    private final String[] COLUMN_NAMES = {KEY, VALUE};

    public CurrentObjectsPage(JFrame frame, WindowManager context, TreeMap<Long, Long> spawnTimeMap) {
        super(frame, context);

        this.spawnTimeMap = spawnTimeMap;
    }

    @Override
    public void initializeComponents() {
        components.put(TABLE_NAME, createTable());
        components.put(
                SCROLL_PANE_NAME,
                new JScrollPane(components.get(TABLE_NAME))
        );
    }

    @Override
    public void setupAppearance() {}

    @Override
    public void drawAsDialog(JDialog dialog) {
        dialog.setSize(new Dimension(488, 373));
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add((JScrollPane) components.get(SCROLL_PANE_NAME), BorderLayout.CENTER);
        dialog.pack();

//        rootPanel.setLayout(new BorderLayout());
//        rootPanel.add(components.get(SCROLL_PANE_NAME), BorderLayout.CENTER);
//
//        rootPanel.add(new JLabel("PENIS"));

    }

    @Override
    public void draw() {
    }

    @Override
    public void reset() {
    }

    private JTable createTable() {

//        Object[][] tableData = spawnTimeMap.entrySet().stream()
//                .map(entry -> new Object[]{entry.getKey(), entry.getValue()})
//                .toArray(Object[][]::new);

        Object[][] initialTableData = {
                {"1", "1"}
        };

        DefaultTableModel model = new DefaultTableModel(initialTableData, COLUMN_NAMES);

        return new JTable(model);
    }
}
