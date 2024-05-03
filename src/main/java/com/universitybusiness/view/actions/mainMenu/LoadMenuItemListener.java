package com.universitybusiness.view.actions.mainMenu;

import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadMenuItemListener implements ActionListener {
    private final WindowManager context;

    public LoadMenuItemListener(WindowManager context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open file...");
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".ser");
            }

            @Override
            public String getDescription() {
                return "Serialized files (*.ser)";
            }
        });

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile))) {
                Habitat.deserialize((Habitat) ois.readObject());
                final Habitat instance = Habitat.getInstance();
                context.getController().setSimulationService(instance);
                context.setWidth(instance.getWidth() + 200);
                context.setHeight(instance.getHeight() + 164);
                context.swapPage(WindowManager.Pages.SIMULATION);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
