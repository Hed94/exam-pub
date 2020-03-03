package com.example.tavern.model;

import com.example.tavern.other.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UsersWithoutOrders.class)
    private long id;
    @JsonView(Views.UsersWithoutOrders.class)
    private String name;
    @JsonView(Views.UsersWithoutOrders.class)
    private boolean isActive;
    @JsonView(Views.UsersWithoutOrders.class)
    private boolean isAdult;
    @JsonView(Views.UsersWithoutOrders.class)
    private int pocket;
    @OneToMany(mappedBy="user")
    @JsonIgnoreProperties("user")
    @JsonView(Views.Summary.class)
    private Set<OrderedProducts> orderedProducts;

    public User() {
    }

    public User(@JsonProperty("id") long id,
                @JsonProperty("name")String name,
                @JsonProperty("isActive")boolean isActive,
                @JsonProperty("isAdult")boolean isAdult,
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
