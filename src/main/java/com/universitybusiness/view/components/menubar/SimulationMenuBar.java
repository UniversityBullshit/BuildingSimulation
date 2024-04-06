package com.universitybusiness.view.components.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.simulationPage.ShowTimeAction;
import com.universitybusiness.view.actions.simulationPage.StartKeyAction;
import com.universitybusiness.view.actions.simulationPage.StopKeyAction;
import com.universitybusiness.view.components.simulationView.Area;
import com.universitybusiness.view.util.Style;

import javax.swing.*;
import java.awt.*;

public class SimulationMenuBar extends CustomMenuBar {
    private final Area area;

    public SimulationMenuBar(WindowManager context, Area area) {
        super(context);

        this.area = area;

        this.add(createActionsMenu());
    }

    private JMenu createActionsMenu() {
        JMenu actions = new JMenu("Actions");
        actions.setForeground(Style.getPrimaryLightColor());

        JMenuItem start = new JMenuItem("Start");
        JMenuItem stop = new JMenuItem("Stop");
        JMenuItem showTime = new JMenuItem("Show time");
        JMenuItem hideTime = new JMenuItem("Hide time");

        showTime.setEnabled(!area.isShowTime());
        hideTime.setEnabled(area.isShowTime());

        start.addActionListener(new StartKeyAction(this.context.getController()));
        stop.addActionListener(new StopKeyAction(area, this.context));
        showTime.addActionListener(new ShowTimeAction(area));
        hideTime.addActionListener(new ShowTimeAction(area));

        actions.add(start);
        actions.add(stop);
        actions.add(showTime);
        actions.add(hideTime);

        return actions;
    }
}
