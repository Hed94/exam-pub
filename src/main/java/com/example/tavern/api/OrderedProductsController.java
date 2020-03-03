package com.example.tavern.api;

import com.example.tavern.dto.BuyRequest;
import com.example.tavern.service.OrderedProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void buyProduct(@RequestBody BuyRequest buyRequest)
    {
        try
        {
            orderedProductsService.buyProduct(buyRequest);
        }
        catch (Error exc)
        {
            throw new Error(exc);
        }
    }
}
