package com.example.tavern.api;

import com.example.tavern.dto.SummaryAll;
import com.example.tavern.model.Product;
import com.example.tavern.model.User;
import com.example.tavern.other.Views;
import com.example.tavern.service.SummaryService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/summary")
public class SummaryController
{
    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/all")
    public List<SummaryAll> getAll()
    {
        return summaryService.getAll();
    }

    @GetMapping("/user/{id}")
    public User getSummaryOfUser(@PathVariable long id)
    {
        return summaryService.getSummaryOfUser(id);
    }

    @JsonView(Views.Summary.class)
    @GetMapping("/product/{id}")
    public Product getSummaryOfProduct(@PathVariable long id)
    {
        return summaryService.getSummaryOfProduct(id);
    }
}
