package com.example.tavern.model;

import com.example.tavern.other.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class OrderedProducts{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.All.class)
    private long id;
    @ManyToOne
    @JsonIgnoreProperties("orderedProducts")
    @JsonView(Views.Summary.class)
    private Product product;
    @ManyToOne
    @JsonIgnoreProperties("orderedProducts")
    @JsonView(Views.Summary.class)
    private User user;
    @JsonView(Views.Summary.class)
    private int amount;

    public OrderedProducts() {
    }

    public OrderedProducts(Product product, User user, int amount) {
        this.product = product;
        this.user = user;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
