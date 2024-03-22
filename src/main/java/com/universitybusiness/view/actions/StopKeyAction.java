package com.universitybusiness.view.actions;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.Area;
import com.universitybusiness.view.components.ControlButton;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StopKeyAction extends AbstractAction {
    private final Area area;
    private final WindowManager context;
    private ControlButton startButton = null;
    private ControlButton stopButton = null;

    public StopKeyAction(
        Area area,
        WindowManager context
    ) {
        this.area = area;
        this.context = context;
    }

    public StopKeyAction(
        Area area,
        WindowManager context,
        ControlButton startButton,
        ControlButton stopButton
    ) {
        this(area, context);
        this.startButton = startButton;
        this.stopButton = stopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.context.getController().stopSimulation();
        this.area.stopUpdating();

        if (this.startButton != null) {
            this.startButton.setEnabled(true);
        }

        if (this.stopButton != null) {
            this.stopButton.setEnabled(false);
        }

        if (this.area.isShowInfo()) {
            this.context.showDialog(WindowManager.getINFORMATION_PAGE());
        }
    }
}
