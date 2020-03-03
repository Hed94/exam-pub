package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    private final String name;
    private boolean isActive;
    private int pocket;
    @ManyToMany
    private Set<OrderedProducts> orderedProducts;

    public User(@JsonProperty("id") long id,
                @JsonProperty("name")String name,
                @JsonProperty("isActive")boolean isActive,
                @JsonProperty("pocket")int pocket) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.pocket = pocket;
        orderedProducts = new HashSet<>();
    }

    public long getId() {
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

    public Set<OrderedProducts> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Set<OrderedProducts> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
