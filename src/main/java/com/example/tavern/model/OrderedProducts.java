package com.example.tavern.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderedProducts implements Serializable {
    @Id
    @ManyToOne
    private Product product;
    @Id
    @ManyToOne
    private User user;
    private int amount;

    public OrderedProducts(Product product, User user, int amount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedProducts)) return false;
        OrderedProducts orderedProducts = (OrderedProducts) o;
        return getProduct().equals(orderedProducts.getProduct()) &&
                getUser().equals(orderedProducts.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getUser());
    }
}
