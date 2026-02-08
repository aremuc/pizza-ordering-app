package com.example.assignment_1.controller;

import com.example.assignment_1.model.PizzaOrder;
import com.example.assignment_1.service.PizzaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

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
    public String addOrder(PizzaOrder pizzaOrder, Model model) {

        if (pizzaOrder.getToppings() == null) {
            pizzaOrder.setToppings(new ArrayList<>());
        }

        if (pizzaOrder.getQuantity() <= 0) {
            model.addAttribute("error", "Quantity must be greater than 0.");
            model.addAttribute("pizzaOrder", pizzaOrder);
            return "order-form";
        }

        if (pizzaOrder.isDelivery()) {
            String addr = pizzaOrder.getDeliveryAddress();
            if (addr == null || addr.trim().isEmpty()) {
                model.addAttribute("error", "Delivery address is required when delivery is selected.");
                model.addAttribute("pizzaOrder", pizzaOrder); // keep what they typed
                return "order-form";
            }
        }

        pizzaOrderService.addOrder(pizzaOrder);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", pizzaOrderService.getAllOrders());
        return "orders";
    }

}
