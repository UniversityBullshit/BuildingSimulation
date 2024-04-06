package com.universitybusiness.view.actions;

import com.universitybusiness.view.components.controls.ControlButton;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LockButtonsAction extends AbstractAction {
    private final ControlButton startButton;
    private final ControlButton stopButton;

    public LockButtonsAction(ControlButton startButton, ControlButton stopButton) {
        this.startButton = startButton;
        this.stopButton = stopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startButton.setEnabled(!startButton.getIsEnabled());
        stopButton.setEnabled(!stopButton.getIsEnabled());
    }
}
