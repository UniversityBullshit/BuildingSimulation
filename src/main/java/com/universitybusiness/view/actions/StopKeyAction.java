package com.universitybusiness.view.actions;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.Area;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StopKeyAction extends AbstractAction {
    private final Area area;
    private final WindowManager context;

    public StopKeyAction(Area area, WindowManager context) {
        this.area = area;
        this.context = context;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.context.getController().stopSimulation();
        this.area.stopUpdating();

        if (this.area.isShowInfo()) {
            this.context.showDialog(WindowManager.getINFORMATION_PAGE());
        }
    }
}
