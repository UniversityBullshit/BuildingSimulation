package com.universitybusiness.view.actions.common;

import com.universitybusiness.view.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapPageAction implements ActionListener {
    private final WindowManager context;
    private final String page;

    public SwapPageAction(WindowManager context, String page) {
        this.context = context;
        this.page = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        context.swapPage(page);
    }
}
