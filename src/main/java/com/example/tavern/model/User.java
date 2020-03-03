package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final UUID id;
    private final String name;
    private boolean isActive;
    private int pocket;
    private Set<Order> orders;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name")String name,
                @JsonProperty("isActive")boolean isActive,
                @JsonProperty("pocket")int pocket) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.pocket = pocket;
        orders = new HashSet<Order>();
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

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPocket() {
        return pocket;
    }

    public void setPocket(int pocket) {
        this.pocket = pocket;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
