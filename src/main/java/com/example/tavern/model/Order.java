package com.example.tavern.model;

public class Order {
    private Product product;
    private User user;
    private int amount;

    public Order(Product product, User user, int amount) {
        this.product = product;
        this.user = user;
        this.amount = amount;
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
