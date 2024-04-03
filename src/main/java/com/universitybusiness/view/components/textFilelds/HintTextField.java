package com.universitybusiness.view.components.textFilelds;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HintTextField extends JTextField {
    @Getter
    @Setter
    private Color borderColor = null;

    @Getter
    @Setter
    private Color errorBorderColor = new Color(177, 2, 2);

    private Boolean hasError = false;

    @Getter
    @Setter
    private int radius;

    public HintTextField(String hint) {
        setText(hint);

        addFocusListener(getFocusAdapter(hint));
    }
    public HintTextField(String hint, int columns) {
        setText(hint);
        setColumns(columns);

        addFocusListener(getFocusAdapter(hint));
    }

    private FocusAdapter getFocusAdapter(String hint) {
        return new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                } else {
                    setText(getText());
                }

                clearError();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().isEmpty()) {
                    setText(hint);
                } else {
                    setText(getText());
                }
            }
        };
    }

    public void setError() {
        hasError = true;
        repaint();
    }

    public void clearError() {
        hasError = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0,0,getWidth() - 1,getHeight() - 1,radius,radius);
        super.paintComponent(g2d);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (!hasError) {
            g2d.setColor(this.borderColor == null ? getForeground() : this.borderColor);
        } else {
            g2d.setColor(this.errorBorderColor);
        }

        g2d.drawRoundRect(0,0,getWidth() - 1, getHeight() - 1, radius, radius);
    }
}
