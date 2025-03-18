package com.example.customer.component.structure;

import javax.persistence.*;

import com.example.order.component.structure.Order;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart; // Angenommen, Cart ist eine weitere Entity, die du noch erstellen musst

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Map<Integer, Order> orders = new HashMap<>();

    public Customer() {}

    public Customer(String name, String address, Cart cart) {
        this.name = name;
        this.address = address;
        this.cart = cart;
    }

    // Getter und Setter
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }
}
