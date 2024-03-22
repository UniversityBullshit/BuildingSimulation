package com.universitybusiness.view.util;

import lombok.Data;
import lombok.Getter;

import java.awt.*;

@Data
public class Style {
    /**
     * Primary accent color. Should be used for panels, buttons, text, and borders,
     * when background color is primaryLightColor.
     */
    @Getter
    private final static Color primaryDarkColor = new Color(32,32,32);

    /**
     * Secondary accent color. Should be used for optional elements that shouldn't
     * occupy user attention, when background color is primaryLightColor.
     */
    @Getter
    private final static Color secondaryDarkColor = new Color(66,66,66);

    /**
     * Primary accent color. Should be used for panels, buttons, text and borders,
     * when background color is primaryDarkColor. Always background color of text fields.
     */
    @Getter
    private final static Color primaryLightColor = new Color(255,255,255);

    /**
     * Color of inactive SwitchButtons or RadioButtons
     */
    @Getter
    private final static Color unselectColor = new Color(211,211,211);

    /**
     * Color of active SwitchButtons or RadioButtons.
     */
    @Getter
    private final static Color selectColor = new Color(34,167,63);

    /**
     * Should be used as text field hints color.
     */
    @Getter
    private final static Color textFieldHintsColor = new Color(113,113,113);
}
