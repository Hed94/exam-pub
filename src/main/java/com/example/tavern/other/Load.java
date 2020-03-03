package com.example.tavern.other;

import com.example.tavern.model.Product;
import com.example.tavern.model.User;

public class Load
{
    public static User populateUser(final User user){
        User userData = new User();
        userData.setId(user.getId());
        userData.setName(user.getName());
        userData.setActive(user.isActive());
        userData.setAdult(user.isAdult());
        userData.setPocket(user.getPocket());
        userData.setOrderedProducts(user.getOrderedProducts());
        return  userData;
    }

    public static Product populateProduct(final Product product){
        Product productData = new Product();
        productData.setId(product.getId());
        productData.setProductName(product.getProductName());
        productData.setIsForAdult(product.getIsForAdult());
        productData.setPrice(product.getPrice());
        return  productData;
    }
}
