package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;
    @OneToMany(mappedBy="user")
    @JsonIgnoreProperties("user")
    private Set<OrderedProducts> orderedProducts;

    public User() {
    }

    public User(@JsonProperty("id") long id,
                @JsonProperty("name")String name,
                @JsonProperty("isActive")boolean isActive,
                @JsonProperty("isActive")boolean isAdult,
                @JsonProperty("pocket")int pocket) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.isAdult = isAdult;
        this.pocket = pocket;
        orderedProducts = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
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
