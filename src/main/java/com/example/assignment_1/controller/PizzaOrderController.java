package com.example.assignment_1.controller;

import com.example.assignment_1.service.PizzaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaOrderController {

    PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

}
