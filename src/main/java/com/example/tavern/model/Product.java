package com.example.tavern.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private boolean isForAdult;
    private int price;

    public Product() {
    }

    public Product(@JsonProperty("id") long id,
                   @JsonProperty("productName") String productName,
                   @JsonProperty("isForAdult") boolean isForAdult,
                   @JsonProperty("price") int price) {
        this.id = id;
        this.productName = productName;
        this.isForAdult = isForAdult;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean getIsForAdult() {
        return isForAdult;
    }

    public void setIsForAdult(boolean isForAdult) {
        this.isForAdult = isForAdult;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
