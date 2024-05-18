package com.universitybusiness.view.adapters;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String username;

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
