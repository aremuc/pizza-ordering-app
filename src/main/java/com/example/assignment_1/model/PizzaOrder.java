/*
Name: Calvin Aremu
Student ID: 991817431
Course: PROG27545
Assignment: 1
*/

package com.example.assignment_1.model;

import java.time.LocalDateTime;
import java.util.List;


public class PizzaOrder {

    private int id;
    private String customerName;
    private Size size;
    private Crust crust;
    private List<Topping> toppings;
    private int quantity;
    private boolean delivery;
    private String deliveryAddress;
    private double subtotal;
    private double discountAmount;
    private double tax;
    private double total;
    private LocalDateTime orderTime;

    public PizzaOrder() {}

    public PizzaOrder(int id, String customerName, Size size, Crust crust, List<Topping> toppings, int quantity, boolean delivery, String deliveryAddress, double subtotal, double discountAmount, double tax, double total, LocalDateTime orderTime) {
        this.id = id;
        this.customerName = customerName;
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
        this.quantity = quantity;
        this.delivery = delivery;
        this.deliveryAddress = deliveryAddress;
        this.subtotal = subtotal;
        this.discountAmount = discountAmount;
        this.tax = tax;
        this.total = total;
        this.orderTime = orderTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", size=" + size +
                ", crust=" + crust +
                ", toppings=" + toppings +
                ", quantity=" + quantity +
                ", delivery=" + delivery +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", subtotal=" + subtotal +
                ", discountAmount=" + discountAmount +
                ", tax=" + tax +
                ", total=" + total +
                ", orderTime=" + orderTime +
                '}';
    }
}
