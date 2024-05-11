package com.universitybusiness.controller;

import com.universitybusiness.model.client.Client;

import java.util.TreeMap;

public class ClientController {
    private final Client client;

    public ClientController(Client client) {
        this.client = client;
    }

    public String getUsername() {
        return client.getUsername();
    }

    public TreeMap<Long, String> getUserList() {
        return client.getUserList();
    }

    public void disconnect() {
        client.processCommand(Client.CommandList.DISCONNECT);
        client.disconnect();
    }
}
