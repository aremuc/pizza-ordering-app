package com.example.assignment_1.service;

import com.example.assignment_1.model.PizzaOrder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderService {

    private int nextId = 1;

    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

    //add an order
    public void addOrder(PizzaOrder order) {
        order.setId(nextId++);
        order.setOrderTime(LocalDateTime.now());
        double base = calculateBasePrice(order);
        double toppings = calculateToppingsPrice(order);
        double subtotal = (base + toppings) * order.getQuantity();
        order.setSubtotal(subtotal);

        double discount = calculateDiscountAmount(order, subtotal);
        order.setDiscountAmount(discount);

        double taxableAmount = subtotal - discount;
        double tax = calculateTaxAmount(taxableAmount);
        order.setTax(tax);

        double deliveryFee = calculateDeliveryFee(order);

        double total = taxableAmount + tax + deliveryFee;
        order.setTotal(total);
        pizzaOrders.add(order);
    }

    public List<PizzaOrder> getAllOrders() {
        return pizzaOrders;
    }

    private double calculateBasePrice(PizzaOrder order) {
        return switch (order.getSize()) {
            case SMALL -> 8.00;
            case MEDIUM -> 10.00;
            case LARGE -> 12.00;
            default -> 0.00;
        };
    }

    private double calculateToppingsPrice(PizzaOrder order) {
        return 1.25 * order.getToppings().size();
    }

    private double calculateDiscountAmount(PizzaOrder order, double subtotal) {
        if (order.getQuantity() > 3) {
            return subtotal * .10;
        }
        return 0.00;
    }

    private double calculateTaxAmount(double amountAfterDiscount) {
        return amountAfterDiscount * 0.13;
    }

    private double calculateDeliveryFee(PizzaOrder order) {
        if (order.isDelivery()) {
            return 3.99;
        }
        else {
            return 0;
            }
        }
    }


