package com.example.tavern.model;

import com.example.tavern.other.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.Summary.class,Views.ProductsWithoutOrders.class})
    private long id;
    @JsonView({Views.Summary.class,Views.ProductsWithoutOrders.class})
    private String productName;
    @JsonView({Views.Summary.class,Views.ProductsWithoutOrders.class})
    private boolean isForAdult;
    @JsonView({Views.Summary.class,Views.ProductsWithoutOrders.class})
    private int price;
    @OneToMany(mappedBy="product")
    @JsonIgnoreProperties("user")
    @JsonView(Views.Summary.class)
    private Set<OrderedProducts> orderedProducts;

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
        orderedProducts = new HashSet<>();
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

    public void isForAdult(boolean isForAdult) {
        this.isForAdult = isForAdult;
    }

    public void setForAdult(boolean forAdult) {
        isForAdult = forAdult;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<OrderedProducts> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Set<OrderedProducts> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
