package com.universitybusiness.view.components.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.mainMenu.LoadMenuItemListener;
import com.universitybusiness.view.actions.mainMenu.SaveMenuItemListener;
import com.universitybusiness.view.util.Style;

import javax.swing.*;

public class MainMenuBar extends CustomMenuBar {
    public MainMenuBar(WindowManager context) {
        super(context);
        this.add(createFileMenu());
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");
        file.setForeground(Style.getPrimaryLightColor());

        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        load.addActionListener(new LoadMenuItemListener(context));
        save.addActionListener(new SaveMenuItemListener(context));

        file.add(load);
        file.add(save);

        return file;
    }
}
