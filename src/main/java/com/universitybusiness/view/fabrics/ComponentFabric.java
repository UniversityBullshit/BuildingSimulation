package com.universitybusiness.view.fabrics;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.components.ControlButton;
import com.universitybusiness.view.components.HintTextField;
import com.universitybusiness.view.components.RadioButton;
import com.universitybusiness.view.components.SwitchButton;
import com.universitybusiness.view.util.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class ComponentFabric {
    public static void setupLightPanel(JPanel panel) {
        panel.setBackground(Style.getPrimaryLightColor());
    }

    public static void setupDarkPanel(JPanel panel) {
        panel.setBackground(Style.getPrimaryDarkColor());
    }
    public static void setupLabel1(JLabel label) {
        label.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 36));
    }

    public static void setupLabel2(JLabel label) {
        label.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 20));
    }

    public static void setupLabel3(JLabel label) {
        label.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 15));
    }

    public static void setupDarkLabel(JLabel label) {
        label.setForeground(Style.getPrimaryDarkColor());
    }

    public static void setupLightLabel(JLabel label) {
        label.setForeground(Style.getPrimaryLightColor());
    }

    public static void setupControlButtonDark(ControlButton button) {
        button.setColorOver(new Color(20,20,20));
        button.setColor(Color.BLACK);
        button.setColorClick(new Color(80,80,80));
        button.setRadius(20);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBorder(new EmptyBorder(5,10,5,10));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 18));
    }
    public static void setupControlButtonLight(ControlButton button) {
        button.setColorOver(new Color(240,240,240));
        button.setColor(Color.WHITE);
        button.setColorClick(new Color(225,225,225));
        button.setBorderColor(Color.WHITE);
        button.setRadius(20);
        button.setPreferredSize(new Dimension(160, 30));
        button.setBorder((new EmptyBorder(5,10,5,10)));
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 18));
    }

    public static void setupHintTextField(HintTextField field) {
        field.setColumns(9);
        field.setPreferredSize(new Dimension(160,30));
        field.setRadius(15);
        field.setForeground(Style.getTextFieldHintsColor());
        field.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 15));
        field.setBorder(BorderFactory.createCompoundBorder(
                field.getBorder(),
                BorderFactory.createEmptyBorder(2,20,2,5)
        ));
    }

    public static void setupSwitchButton(SwitchButton button) {

    }

    public static void setupRadioButton(RadioButton button) {
        button.setBackground(Style.getPrimaryLightColor());
        button.setActiveColor(Style.getSelectColor());
        button.setUnactiveColor(Style.getUnselectColor());
    }
}
