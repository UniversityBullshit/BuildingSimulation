package com.universitybusiness.view.components.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.util.Style;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CustomMenuBar extends JMenuBar {
    protected final WindowManager context;
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

        controls.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.showDialog(WindowManager.Pages.CONTROLS);
            }
        });

        about.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.showDialog(WindowManager.Pages.HELP);
            }
        });

        help.add(controls);
        help.add(about);

        return help;
    }
}
