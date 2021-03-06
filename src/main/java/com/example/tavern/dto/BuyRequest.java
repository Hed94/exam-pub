package com.example.tavern.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyRequest {
    private long userID;
    private long productID;
    private int amount;

    public BuyRequest(@JsonProperty("userID") long userID,
                      @JsonProperty("productID") long productID,
                      @JsonProperty("amount") int amount) {
        this.userID = userID;
        this.productID = productID;
        this.amount = amount;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
