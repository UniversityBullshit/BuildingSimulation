package com.universitybusiness.model.client;

import java.util.ArrayList;

public class Response {
    private final ArrayList<Object> response;

    public Response() {
        response = new ArrayList<>();
    }

    public void add(Object object) {
        response.add(object);
    }

    public ArrayList<Object> get() {
        return response;
    }
}
