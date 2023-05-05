package com.universitybullshit.view.util;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.components.Area;
import com.universitybullshit.view.actions.ShowTimeAction;
import com.universitybullshit.view.actions.StartKeyAction;
import com.universitybullshit.view.actions.StopKeyAction;

import javax.swing.*;

public class KeyboardInput {

    public static void createKeyBindings(JComponent component, WindowManager context, Area area) {
        InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = component.getActionMap();

        Action startAction = new StartKeyAction(context.getController(), area);
        Action stopAction = new StopKeyAction(area, context);
        Action showTimeAction = new ShowTimeAction(area);

        im.put(KeyStroke.getKeyStroke("B"), "start");
        im.put(KeyStroke.getKeyStroke("E"), "stop");
        im.put(KeyStroke.getKeyStroke("T"), "time");
        am.put("start", startAction);
        am.put("stop", stopAction);
        am.put("time", showTimeAction);
    }
}
