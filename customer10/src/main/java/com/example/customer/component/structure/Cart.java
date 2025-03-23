package com.example.customer.component.structure;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Auto-generierte ID für Cart

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Map<Integer, CartItem> cartItems = new HashMap<>();

    private int numberOfArticles;

    @ManyToOne
    @JoinColumn(name = "customer_id")  // Die Beziehung zu Customer
    private Customer customer;

    // Standardkonstruktor
    public Cart() {
        numberOfArticles = 0;
    }

    // Konstruktor mit Kunden und CartItems
    public Cart(Customer customer) {
        this.customer = customer;
        this.numberOfArticles = 0;
    }

    // Methoden zum Hinzufügen und Entfernen von CartItems
    public void addCartItem(CartItem cartItem) {
        cartItems.put(cartItem.getCartItemId(), cartItem);
        numberOfArticles++;
    }

    public void deleteCartItem(int cartItemId) {
        cartItems.remove(cartItemId);
        numberOfArticles--;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    public void setNumberOfArticles(int numberOfArticles) {
        this.numberOfArticles = numberOfArticles;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Berechne den Gesamtpreis des Warenkorbs
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (CartItem cartItem : cartItems.values()) {
            totalPrice += cartItem.getQuantity() * cartItem.getArticle().getPrice();
        }
        return totalPrice;
    }
}