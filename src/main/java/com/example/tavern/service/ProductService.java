package com.example.tavern.service;

import com.example.tavern.dao.ProductRepository;
import com.example.tavern.dao.UserRepository;
import com.example.tavern.model.Product;
import com.example.tavern.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
}
