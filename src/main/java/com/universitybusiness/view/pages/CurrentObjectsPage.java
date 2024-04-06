package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.TreeMap;

public class CurrentObjectsPage extends Page implements IPage {
    private final String KEY = "Key";
    private final String VALUE = "Spawn time (ms)";
    private final String[] COLUMN_NAMES = {KEY, VALUE};

    public CurrentObjectsPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }

    @Override
    public void initializeComponents() {}

    @Override
    public void setupAppearance() {}

    @Override
    public void drawAsDialog(JDialog dialog) {
        dialog.setSize(new Dimension(488, 373));
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(createScrollPane(), BorderLayout.CENTER);
        dialog.pack();
    }

    @Override
    public void draw() {
    }

    @Override
    public void reset() {}

    private JScrollPane createScrollPane() {
        JTable table = createTable();

        return new JScrollPane(table);
    }

    private JTable createTable() {
        Object[][] tableData = getTableData();
        DefaultTableModel model = new DefaultTableModel(tableData, COLUMN_NAMES);

        return new JTable(model);
    }

    private Object[][] getTableData() {
        TreeMap<Long, Long> spawnTimeMap = this.context.getController().getSpawnTimeMap();

        return spawnTimeMap.entrySet().stream()
                .map(entry -> new Object[]{entry.getKey(), entry.getValue()})
                .toArray(Object[][]::new);
    }
}
