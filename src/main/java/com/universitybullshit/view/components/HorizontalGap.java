package com.universitybullshit.view.components;

import javax.swing.*;

public class HorizontalGap extends JLabel {
    public HorizontalGap(int length) {
        setText(new String(new char[length]).replace("\0", "-"));
    }
}
