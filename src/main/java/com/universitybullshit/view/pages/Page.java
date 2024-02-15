package com.universitybullshit.view.pages;

import com.universitybullshit.view.WindowManager;

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
        
        initializeComponents();
        setupAppearance();
    }
}