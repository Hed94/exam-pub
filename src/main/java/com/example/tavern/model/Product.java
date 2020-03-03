package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
