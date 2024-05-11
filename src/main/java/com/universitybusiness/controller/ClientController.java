package com.universitybusiness.controller;

import com.universitybusiness.model.client.Client;

import java.util.TreeMap;
import java.util.UUID;

public class ClientController {
    private final Client client;

    public ClientController(Client client) {
        this.client = client;
    }

    public String getUsername() {
        return client.getUsername();
    }

    public TreeMap<UUID, String> getUserList() {
        client.processCommand(Client.CommandList.GET_USER_LIST);

        TreeMap<UUID, String> users = new TreeMap<>();

        Object response = client.acceptResponse();
        if (response instanceof TreeMap) {
            users = (TreeMap<UUID, String>) response;
            users.remove(client.getId());
        }

        return users;
    }

    public void disconnect() {
        client.processCommand(Client.CommandList.DISCONNECT);
    }
}
