package com.universitybusiness.model.client;

import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.simulation.impl.Habitat;
import lombok.Getter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

public class Client implements Runnable {
    private Socket socket;

    private UserData userData;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    private RequestSender sender;
    private ResponseListener listener;
    private Response response;

    @Getter
    private boolean connected;

    public static class CommandList {
        public static final String DISCONNECT = "disconnect";
        public static final String GET_USER_LIST = "getUserList";
        public static final String GET_DATA = "getData";
    }

    public Client(int port) {
        userData = new UserData();

        try {
            socket = new Socket("localhost", port);

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            sender = new RequestSender(out);
            listener = new ResponseListener(in, userData);

            connected = true;
        } catch (Exception e) {
            connected = false;
            System.out.println("Failed to connect to server: " + e.getClass());
        }
    }

    private void start() {
        new Thread(sender).start();
        new Thread(listener).start();
    }

    public void stop() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response getResponse() {
        return listener.getResponse();
    }

    public void execute(Request request) {
        sender.execute(request);
    }

    public String getUsername() {
        return userData.getUsername();
    }

    public UUID getUserId() {
        return userData.getUserId();
    }

    @Override
    public void run() {
        start();

        while (connected) {
            response = listener.getResponse();

            if (response.get().get(0).equals("getHabitat")) {
                try {
                    byte[] habitat = ByteSerializer.serialize(Habitat.getInstance());

                    sender.execute(new Request()
                            .add("receiveHabitat")
                            .add(habitat)
                            .add(response.get().get(1)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
