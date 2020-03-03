package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private int amount;
    private int price;

    public Product() {
    }

    public Product(@JsonProperty("id") long id,
                   @JsonProperty("productName") String productName,
                   @JsonProperty("amount") int amount,
                   @JsonProperty("price") int price) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
