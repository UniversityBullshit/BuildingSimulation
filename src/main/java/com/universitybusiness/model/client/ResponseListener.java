package com.universitybusiness.model.client;

import lombok.Getter;

import java.io.ObjectInputStream;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class ResponseListener implements Runnable {
    private final ObjectInputStream in;
    private UserData userData;
    private Response response;
    private CountDownLatch latch;

    public ResponseListener(ObjectInputStream in, UserData userData) {
        this.in = in;
        this.userData = userData;
        latch = new CountDownLatch(1);
    }

    public Response getResponse() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public void run() {
        try {
            userData.setUserId((UUID) in.readObject());
            userData.setUsername((String) in.readObject());

            System.out.println("User: " + userData.getUsername() + " [" + userData.getUserId() + "]");

            while (true) {
                Object object = in.readObject();

                response = new Response();
                while (!object.equals("end")) {
                    response.add(object);
                    object = in.readObject();
                }

                latch.countDown();
                latch = new CountDownLatch(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
