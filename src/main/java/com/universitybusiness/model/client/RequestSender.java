package com.universitybusiness.model.client;

import java.io.ObjectOutputStream;

public class RequestSender implements Runnable {
    private final ObjectOutputStream out;
    private Request request;


    public RequestSender(ObjectOutputStream out) {
        this.out = out;
        request = new Request();
    }

    public void execute(Request request) {
        synchronized (this.request) {
            this.request = request;
            this.request.setReady();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (request) {
                    if (request != null && request.isReady()) {
                        for (Object object : request.get()) {
                            out.writeObject(object);
                        }
                        out.flush();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
