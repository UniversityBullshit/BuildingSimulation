package com.universitybullshit.view.fabrics;

import com.universitybullshit.view.fabrics.ImageFactory;
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
            URL resource = ImageFactory.class.getResource("/fonts/Kadwa-Regular.ttf");
            File file = Paths.get(resource.toURI()).toFile();
            kadwaRegularFont = Font.createFont(Font.TRUETYPE_FONT, file);
            kadwaRegularFont = kadwaRegularFont.deriveFont(Font.PLAIN, 14);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
