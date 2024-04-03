package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.menubar.CustomMenuBar;

import javax.swing.*;
import java.util.HashMap;

public abstract class Page implements IPage {
    protected final JFrame frame;
    
    protected final HashMap<String, JComponent> components;
    
    protected final WindowManager context;
    
    public Page(JFrame frame, WindowManager context) {
        this.frame = frame;
        this.context = context;
        components = new HashMap<>();

        this.frame.setJMenuBar(new CustomMenuBar(context));
        
        initializeComponents();
        setupAppearance();
    }
}