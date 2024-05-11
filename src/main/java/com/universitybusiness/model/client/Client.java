package com.universitybusiness.model.client;

import lombok.Getter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Client implements Runnable {
    private Socket socket;
    @Getter
    private UUID id;
    @Getter
    private String username;
    private String command;
    private boolean connected;

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Object response = null;
    private CountDownLatch latch = new CountDownLatch(1);

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
            System.out.println("Failed to connect to server: " + e.getClass());
        }
    }

    public void processCommand(String command) {
        this.command = command;
    }

    public Object acceptResponse() {
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void run() {
        try {
            id = (UUID) in.readObject();
            username = (String) in.readObject();

            System.out.println(id + " " + username);

            while (connected) {
                if (in.available() == 0) {
                    if (command != null) {
                        switch (command) {
                            case CommandList.DISCONNECT:
                                disconnect();
                                break;
                            case CommandList.GET_USER_LIST:
                                getUserList();
                                break;
                            default:
                                out.writeObject(command);
                                break;
                        }

                        command = null;
                        latch = new CountDownLatch(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        try {
            out.writeObject(CommandList.DISCONNECT);
            connected = false;
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUserList() {
        try {
            out.writeObject(CommandList.GET_USER_LIST);
            out.flush();

            synchronized (this) {
                response = in.readObject();
                latch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
