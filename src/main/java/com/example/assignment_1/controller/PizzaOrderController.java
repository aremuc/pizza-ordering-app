package com.example.assignment_1.controller;

import com.example.assignment_1.model.PizzaOrder;
import com.example.assignment_1.service.PizzaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("pizzaOrder", new PizzaOrder());
        return "order-form";
    }

    @PostMapping("/order")
    public String addOrder(PizzaOrder pizzaOrder) {
        pizzaOrderService.addOrder(pizzaOrder);
        return "redirect:/";
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", pizzaOrderService.getAllOrders());
        return "orders";
    }

}
