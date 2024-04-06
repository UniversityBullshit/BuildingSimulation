package com.universitybusiness.view.components.controls;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlButton extends JButton {
    @Getter
    @Setter
    private boolean over;
    private boolean isEnabled = true;
    @Getter
    private Color color;
    @Getter
    @Setter
    private Color colorOver;
    @Getter
    @Setter
    private Color colorClick;
    @Getter
    @Setter
    private Color borderColor;
    @Getter
    @Setter
    private int radius = 0;
    public ControlButton(String text) {
        setText(text);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                if (!isEnabled) {
                    return;
                }

                setBackground(colorOver);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (!isEnabled) {
                    return;
                }

                setBackground(color);
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (!isEnabled) {
                    return;
                }

                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (!isEnabled) {
                    return;
                }

                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
    }

    public ControlButton(String text, boolean isEnabled) {
        this(text);
        this.setEnabled(isEnabled);
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    @Override
    public void setEnabled(boolean status) {
        this.isEnabled = status;
        super.setEnabled(status);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(borderColor);
        g2d.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        super.paintComponent(g);
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }
}
