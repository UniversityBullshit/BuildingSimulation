package com.universitybusiness.view.viewModel;

import com.universitybusiness.controller.ClientController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.UUID;

public class UsersViewModel implements ViewModel {
    private final ClientController controller;
    private final Timer timer;
    private final int WAIT_TIME = 1000;
    private final HashSet<ActionListener> updateListeners;

    @Getter
    private boolean updating = true;

    @Getter
    private String username = "Offline";
    @Getter
    private final DefaultListModel<String> listModel;

    public UsersViewModel(ClientController controller) {
        this.controller = controller;
        listModel = new DefaultListModel<>();
        updateListeners = new HashSet<>();

        timer = new Timer(
            WAIT_TIME,
            event -> SwingUtilities.invokeLater(this::update));
        timer.start();
    }

    public void setUpdating(boolean status) {
        if (updating != status) {
            updating = status;
        }
    }

    public void addUpdateListener(ActionListener listener) {
        updateListeners.add(listener);
    }

    public void removeUpdateListener(ActionListener listener) {
        updateListeners.remove(listener);
    }

    public void update() {
        if (updating) {
            username = controller.getUsername();
            reloadUsersList();

            for (ActionListener listener : updateListeners) {
                listener.actionPerformed(null);
            }
        }
    }

    public DefaultListModel<String> reloadUsersList() {
        listModel.removeAllElements();

        TreeMap<UUID, String> users = controller.getUserList();
        users.forEach((key, value) -> listModel.addElement(value));

        return listModel;
    }
}
