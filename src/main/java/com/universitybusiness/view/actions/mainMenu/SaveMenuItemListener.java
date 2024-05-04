package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.view.util.CustomFileFilter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveMenuItemListener implements ActionListener {
    private final JFileChooser fileChooser = new JFileChooser();

    private final String DIALOG_TITLE = "Save as...";

    public SaveMenuItemListener() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        fileChooser.setDialogTitle(DIALOG_TITLE);
        fileChooser.setFileFilter(new CustomFileFilter());

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (!selectedFile.getName().toLowerCase().endsWith(CustomFileFilter.FILE_EXTENSION)) {
                selectedFile = new File(selectedFile.getPath() + CustomFileFilter.FILE_EXTENSION);
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile))) {
                oos.writeObject(Habitat.getInstance());
                JOptionPane.showMessageDialog(null, "File saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
