package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String productName;
    private final int amount;
    private final int price;

    public Product(@JsonProperty("id") UUID id,
                   @JsonProperty("id") String productName,
                   @JsonProperty("id") int amount,
                   @JsonProperty("id") int price) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public UUID getId() {
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
