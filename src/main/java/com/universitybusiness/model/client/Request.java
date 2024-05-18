package com.universitybusiness.model.client;

import lombok.Getter;

import java.util.ArrayList;


/**
 * Each request to server must be a new one instance.
 */
public class Request {
    private ArrayList<Object> request;
    @Getter
    private boolean ready;

    public Request() {
        request = new ArrayList<>();
        ready = false;
    }

    public Request add(Object object) {
        request.add(object);

        return this;
    }

    public ArrayList<Object> get() {
        ready = false;
        return request;
    }

    public void setReady() {
        ready = true;
    }
}
