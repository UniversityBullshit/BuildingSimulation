package com.universitybusiness.view.components;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class RadioButton extends JRadioButton {
    @Getter
    @Setter
    private Color activeColor;
    @Getter
    @Setter
    private Color unactiveColor;
    public RadioButton(String text, boolean selected) {
        setText(text);
        setSelected(selected);
        setPreferredSize(new Dimension(20,20));
        setForeground(Color.WHITE);
        setBackground(Color.WHITE);
        setActiveColor(new Color(87,60,193));
        setUnactiveColor(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRect(0,0,getWidth(), getHeight());

        if (isSelected()) {
            g2d.setColor(getActiveColor());
            g2d.fillOval(0,0, getWidth(), getHeight());

            g2d.setColor(getBackground());
            g2d.fillOval(2,2,getWidth() - 4, getHeight() - 4);

            g2d.setColor(getActiveColor());
            g2d.fillOval(6,6, getWidth() - 12, getHeight() - 12);
        } else {
            g2d.setColor(getUnactiveColor());
            g2d.fillOval(0,0,getWidth(), getHeight());

            g2d.setColor(getBackground());
            g2d.fillOval(3,3,getWidth() - 6, getHeight() - 6);
        }
    }
}
