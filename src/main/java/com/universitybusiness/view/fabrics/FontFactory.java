package com.universitybusiness.view.fabrics;

import lombok.Getter;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class FontFactory {
    @Getter
    private Font kadwaRegularFont;

    public FontFactory() {
        try {
            InputStream  resource = FontFactory.class.getResourceAsStream("/fonts/Kadwa-Regular.ttf");

            if (resource == null) {
                throw new FileNotFoundException("Resource not found");
            }

            kadwaRegularFont = Font.createFont(Font.TRUETYPE_FONT, resource);
            kadwaRegularFont = kadwaRegularFont.deriveFont(Font.PLAIN, 14);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
