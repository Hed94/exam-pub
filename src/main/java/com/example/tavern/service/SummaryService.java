package com.example.tavern.service;

import com.example.tavern.dao.OrderedProductsRepository;
import com.example.tavern.dao.ProductRepository;
import com.example.tavern.dao.UserRepository;
import com.example.tavern.dto.SummaryAll;
import com.example.tavern.model.Product;
import com.example.tavern.model.User;
import com.example.tavern.other.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("summaryService")
public class SummaryService
{
    @Autowired
    private OrderedProductsRepository orderedProductsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<SummaryAll> getAll()
    {
        return orderedProductsRepository.SummaryAll();
    }

    public User getSummaryOfUser(long id)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        User user;
        if (optionalUser.isPresent())
        {
            return Load.populateUser(optionalUser.get());
        }
        else
        {
            throw new Error("User not found");
        }
    }

    public Product getSummaryOfProduct(long id)
    {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product;
        if (optionalProduct.isPresent())
        {
            return Load.populateProduct(optionalProduct.get());
        }
        else
        {
            throw new Error("Product not found");
        }
    }
}
