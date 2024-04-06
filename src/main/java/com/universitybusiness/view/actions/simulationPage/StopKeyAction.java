package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.simulationView.Area;
import com.universitybusiness.view.components.controls.ControlButton;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StopKeyAction extends AbstractAction {
    private final Area area;
    private final WindowManager context;
    private ControlButton startButton = null;
    private ControlButton stopButton = null;
    private ControlButton currentObjectsButton = null;

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
        ControlButton stopButton,
        ControlButton currentObjectsButton
    ) {
        this(area, context);
        this.startButton = startButton;
        this.stopButton = stopButton;
        this.currentObjectsButton = currentObjectsButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.context.getController().stopSimulation();

        if (this.startButton != null) {
            this.startButton.setEnabled(true);
        }

        if (this.stopButton != null) {
            this.stopButton.setEnabled(false);
        }

        if (this.currentObjectsButton != null) {
            this.currentObjectsButton.setEnabled(false);
        }

        if (this.area.isShowInfo()) {
            this.context.showDialog(WindowManager.Pages.INFORMATION);
        }
    }
}
