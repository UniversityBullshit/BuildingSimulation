package com.universitybusiness.view.components.combobox;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class ComboBox<E> extends JComboBox<E> {
    @Getter
    @Setter
    private String hint = "";
    @Getter
    @Setter
    private Color borderColor;
    @Getter
    @Setter
    private int radius = 0;

    public ComboBox(E[] items) {
        super(items);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);

        g2d.setColor(getForeground());
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        String text = getSelectedItem() != null ? getSelectedItem().toString() : (hint != null ? hint : "");
        g2d.drawString(text, 20, metrics.getAscent() + (getHeight() - metrics.getHeight()) / 2);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(this.borderColor == null ? getForeground() : this.borderColor);

        g2d.drawRoundRect(0,0,getWidth() - 1, getHeight() - 1, radius, radius);
    }
}
