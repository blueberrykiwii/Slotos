package com.example.customer.component.structure;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart; // Annahme: Cart ist eine eigene Entity in MariaDB

    @ElementCollection
    private List<String> orderIds = new ArrayList<>(); // Speichert nur Order-IDs als String

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public void addOrderId(String orderId) {
        this.orderIds.add(orderId);
    }
}

