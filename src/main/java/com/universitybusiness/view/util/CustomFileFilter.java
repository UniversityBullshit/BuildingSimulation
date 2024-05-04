package com.universitybusiness.view.util;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class CustomFileFilter extends FileFilter {
    public static final String FILE_EXTENSION = ".bss";

    public static final String FILE_DESCRIPTION = "BuildingSimulator Save file";

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(FILE_EXTENSION);
    }

    @Override
    public String getDescription() {
        return FILE_DESCRIPTION + " (*" + FILE_EXTENSION + ")";
    }
}
