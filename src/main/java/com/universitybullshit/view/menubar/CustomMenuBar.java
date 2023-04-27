package com.universitybullshit.view.menubar;

import com.universitybullshit.view.WindowManager;
import com.universitybullshit.view.actions.AboutMenuItemListener;
import com.universitybullshit.view.actions.ControlsMenuItemListener;
import com.universitybullshit.view.util.StyleDto;

import javax.swing.*;

public class CustomMenuBar extends JMenuBar {
    private final WindowManager context;
    public CustomMenuBar(WindowManager context) {
        this.context = context;

        UIManager.put("MenuBar.background", StyleDto.getPrimaryDarkColor());

        this.add(createHelpMenu());
    }

    private JMenu createHelpMenu() {
        JMenu help = new JMenu("Help");
        help.setForeground(StyleDto.getPrimaryLightColor());

        JMenuItem controls = new JMenuItem("Controls");
        JMenuItem about = new JMenuItem("About");

        controls.addActionListener(new ControlsMenuItemListener(context.getMainFrame()));
        about.addActionListener(new AboutMenuItemListener(context.getMainFrame()));

        help.add(controls);
        help.add(about);

        return help;
    }
}
