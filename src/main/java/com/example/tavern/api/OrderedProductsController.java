package com.example.tavern.api;

import com.example.tavern.model.Product;
import com.example.tavern.model.Request;
import com.example.tavern.service.OrderedProductsService;
import com.example.tavern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/buy")
public class OrderedProductsController {
    private final OrderedProductsService orderedProductsService;

    @Autowired
    public OrderedProductsController(OrderedProductsService orderedProductsService)
    {
        this.orderedProductsService = orderedProductsService;
    }

    @PostMapping
    public void buyProduct(@RequestBody Request request)
    {
        try
        {
            orderedProductsService.buyProduct(request);
        }
        catch (Error exc)
        {
            throw new Error(exc);
        }
    }
}
