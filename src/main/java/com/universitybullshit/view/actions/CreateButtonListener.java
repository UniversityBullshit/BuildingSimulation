package com.universitybullshit.view.actions;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.Area;
import com.universitybullshit.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButtonListener implements ActionListener {
    private final JTextField width;
    private final JTextField height;
    private final JFrame ctx = MainFrame.getCtx();
    private final JPanel root;
    public CreateButtonListener(JTextField width, JTextField height, JPanel root) {
        this.width = width;
        this.height = height;
        this.root = root;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int width = Integer.parseInt(this.width.getText());
        int height = Integer.parseInt(this.height.getText());
        Area area = new Area(width, height);
        HabitatController controller = new HabitatController(width, height);
        JRootPane rootPane = ctx.getRootPane();
        Action myAction = new StartKeyAction(controller);
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("B"), "b");
        rootPane.getActionMap().put("b", myAction);
        area.create(root);
    }
}
