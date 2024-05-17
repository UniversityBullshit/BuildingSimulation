package com.universitybusiness.view.viewModel;

import com.universitybusiness.controller.ClientController;
import com.universitybusiness.view.adapters.User;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.security.KeyPair;
import java.util.*;

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
    private final DefaultListModel<User> listModel;

    /**
     * Currently selected user to display in user profile page
     */
    @Getter
    private User selectedUser;

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

    public User getUser(int index) {
        return listModel.get(index);
    }

    public void setSelectedUser(User user) {
        if (selectedUser != user) {
            selectedUser = user;
        }
    }

    public DefaultListModel<User> reloadUsersList() {
        listModel.removeAllElements();

        TreeMap<UUID, String> users = controller.getUserList();
        users.forEach((key, value) -> {
            listModel.addElement(new User(key, value));
        });

        return listModel;
    }
}
