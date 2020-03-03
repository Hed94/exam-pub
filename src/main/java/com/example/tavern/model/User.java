package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final boolean isActive;
    private final int pocket;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name")String name,
                @JsonProperty("isActive")boolean isActive,
                @JsonProperty("pocket")int pocket) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.pocket = pocket;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getPocket() {
        return pocket;
    }
}
