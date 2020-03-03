package com.example.tavern.api;

import com.example.tavern.model.Product;
import com.example.tavern.model.User;
import com.example.tavern.service.ProductService;
import com.example.tavern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drink-menu")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
}
