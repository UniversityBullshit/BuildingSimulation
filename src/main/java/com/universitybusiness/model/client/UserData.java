package com.universitybusiness.model.client;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class UserData {
    @Getter
    @Setter
    private UUID userId;
    @Getter
    @Setter
    private String username;
}
