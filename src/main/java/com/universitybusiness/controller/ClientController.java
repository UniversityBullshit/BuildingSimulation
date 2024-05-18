package com.universitybusiness.controller;

import com.universitybusiness.model.client.ByteSerializer;
import com.universitybusiness.model.client.Client;
import com.universitybusiness.model.client.Request;
import com.universitybusiness.model.client.Response;
import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.service.SimulationService;

import java.io.IOException;
import java.util.TreeMap;
import java.util.UUID;

public class ClientController {
    private final Client client;
    private final SimulationService simulationService;

    public ClientController(Client client, SimulationService simulationService) {
        this.client = client;
        this.simulationService = simulationService;
    }

    public String getUsername() {
        return client.getUsername();
    }

    public TreeMap<UUID, String> getUserList() {
        client.execute(new Request().add("getUserList"));
        Response response = client.getResponse();

        TreeMap<UUID, String> userList = new TreeMap<>();

        if (response.get().get(0) instanceof TreeMap) {
            userList = (TreeMap<UUID, String>) response.get().get(0);
            userList.remove(client.getUserId());
        }

        return userList;
    }

    public void loadData(UUID id) {
        client.execute(new Request()
                .add("getData")
                .add(id));
        Response response = client.getResponse();

        try {
            final Habitat habitat = (Habitat) ByteSerializer.deserialize((byte[]) (response.get().get(1)));
            Habitat.deserialize(habitat);
            simulationService.setHabitat(habitat);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
