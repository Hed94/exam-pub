package com.example.tavern.service;

import com.example.tavern.dao.OrderedProductsRepository;
import com.example.tavern.dao.ProductRepository;
import com.example.tavern.dao.UserRepository;
import com.example.tavern.model.OrderedProducts;
import com.example.tavern.model.Product;
import com.example.tavern.model.Request;
import com.example.tavern.model.User;
import com.example.tavern.other.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("orderedProductsService")
public class OrderedProductsService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderedProductsRepository orderedProductsRepository;

    public void buyProduct(Request request)
    {
        Optional<User> optionalUser = userRepository.findById(request.getUserID());
        User user;
        if (optionalUser.isPresent()){
            user = Load.populateUser(optionalUser.get());
        }
        else
        {
            throw new Error("User not found");
        }

        Optional<Product> optionalProduct = productRepository.findById(request.getProductID());
        Product product;
        if (optionalProduct.isPresent()){
            product = Load.populateProduct(optionalProduct.get());
        }
        else
        {
            throw new Error("Product not found");
        }

        if(product.getIsForAdult() && !user.isAdult())
        {
            throw new Error("Chosen product is only for adults");
        }

        if(user.getPocket() < (request.getAmount()*product.getPrice()))
        {
            throw new Error("User does not have enough money.");
        }

        OrderedProducts order = new OrderedProducts(product,user,request.getAmount());
        orderedProductsRepository.save(order);
        user.setPocket(user.getPocket()-(request.getAmount()*product.getPrice()));
        userRepository.save(user);
    }
}
