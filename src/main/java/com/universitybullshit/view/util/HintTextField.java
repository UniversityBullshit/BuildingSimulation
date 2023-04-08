package com.universitybullshit.view.util;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HintTextField extends JTextField {
    @Getter
    @Setter
    private int radius;
    public HintTextField(String hint) {
        setText(hint);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                } else {
                    setText(getText());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().length() == 0) {
                    setText(hint);
                } else {
                    setText(getText());
                }
            }
        });
    }
    public HintTextField(String hint, int columns) {
        setText(hint);
        setColumns(columns);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                } else {
                    setText(getText());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().length() == 0) {
                    setText(hint);
                } else {
                    setText(getText());
                }
            }
        });
    }
}
