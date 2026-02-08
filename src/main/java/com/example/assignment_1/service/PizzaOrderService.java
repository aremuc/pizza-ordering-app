package com.example.assignment_1.service;

import com.example.assignment_1.model.PizzaOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderService {

    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

    //add an order
    public void addOrder(PizzaOrder order) {
        pizzaOrders.add(order);
    }

    public List<PizzaOrder> getAllOrders() {
        return pizzaOrders;
    }
}
