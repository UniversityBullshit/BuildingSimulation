package com.universitybusiness.model.client;

import lombok.Getter;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.TreeMap;

public class Client implements Runnable {
    private Socket socket;
    private long id;
    @Getter
    private String username;
    private String command;
    private boolean connected;

    private ObjectOutputStream out;
    private ObjectInputStream in;


    public static class CommandList {
        public static final String DISCONNECT = "disconnect";
        public static final String GET_USER_LIST = "getUserList";
    }


    public Client(int port) {
        connected = true;

        try {
            socket = new Socket("localhost", port);

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCommand(String command) {
        this.command = command;
    }

    public TreeMap<Long, String> getUserList() {
        processCommand(CommandList.GET_USER_LIST);

        TreeMap<Long, String> users = new TreeMap<>();

        try {
            users.putAll((TreeMap<Long, String>) in.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            id = (Long) in.readObject();
            username = (String) in.readObject();

            System.out.println(id + " " + username);

            while (connected) {
                if (in.available() == 0) {
                    if (command != null) {
                        switch (command) {
                            case CommandList.DISCONNECT:
                                out.writeObject(CommandList.DISCONNECT);
                                connected = false;
                                break;
                            case CommandList.GET_USER_LIST:
                                out.writeObject(CommandList.GET_USER_LIST);
                                break;
                            default:
                                out.writeObject(command);
                                break;
                        }

                        out.flush();
                        command = null;
                    }
                } else {
                    int bytes = in.available();
                    byte[] buffer = new byte[bytes];
                    in.read(buffer);
                    String request = new String(buffer);
                    System.out.println(request);
                }
            }

            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
