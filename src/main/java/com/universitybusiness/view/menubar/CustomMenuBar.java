package com.universitybusiness.view.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.AboutMenuItemListener;
import com.universitybusiness.view.actions.ControlsMenuItemListener;
import com.universitybusiness.view.util.Style;

import javax.swing.*;

public class CustomMenuBar extends JMenuBar {
    private final WindowManager context;
    public CustomMenuBar(WindowManager context) {
        this.context = context;

        UIManager.put("MenuBar.background", Style.getPrimaryDarkColor());

        this.add(createHelpMenu());
    }

    private JMenu createHelpMenu() {
        JMenu help = new JMenu("Help");
        help.setForeground(Style.getPrimaryLightColor());

        JMenuItem controls = new JMenuItem("Controls");
        JMenuItem about = new JMenuItem("About");

        controls.addActionListener(new ControlsMenuItemListener(context.getMainFrame()));
        about.addActionListener(new AboutMenuItemListener(context.getMainFrame()));

        help.add(controls);
        help.add(about);

        return help;
    }
}
