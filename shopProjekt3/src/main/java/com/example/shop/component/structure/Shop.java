package com.example.shop.component.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

import com.example.article.component.structure.Article;
import com.example.article.component.structure.Catalog;
import com.example.customer.component.structure.Cart;
import com.example.customer.component.structure.CartItem;
import com.example.customer.component.structure.Customer;
import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;

public class Shop {
    private Catalog catalog;
    private Map<Integer, Customer> customers;

    public Shop() {
        customers = new HashMap<>();
        catalog = new Catalog();
    }

    public Integer createCustomerWithCart() {
        Customer customer = new Customer(new Cart(customer));
        customers.put(customer.getCustomerId(), customer);
        return customer.getCustomerId();
    }

    public Article getArticle(int articleId) {
        return catalog.getArticle(articleId);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void removeArticleFromCart(Integer customerId, int articleId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Kunde mit ID " + customerId + " nicht gefunden.");
        }

        Cart cart = customer.getCart();
        if (cart == null) {
            throw new IllegalStateException("Kunde hat keinen Warenkorb.");
        }

        CartItem item = cart.getCartItems().values().stream()
            .filter(cartItem -> cartItem.getArticle().getArticleId() == articleId)
            .findFirst()
            .orElse(null);

        if (item != null) {
            cart.deleteCartItem(item.getCartItemId());
        }
    }

    public void addArticleToCart(Integer customerId, Integer articleId) {
        Article foundArticle = getArticle(articleId);
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Kunde mit ID " + customerId + " nicht gefunden.");
        }

        Cart cart = customer.getCart();
        if (cart == null) {
            throw new IllegalStateException("Kunde hat keinen Warenkorb.");
        }

        cart.addCartItem(new CartItem(foundArticle, 1));
    }

    public Order checkOutCart(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Kunde mit ID " + customerId + " nicht gefunden.");
        }

        Cart cart = customer.getCart();
        if (cart == null) {
            throw new IllegalStateException("Kunde hat keinen Warenkorb.");
        }

        Order order = new Order();
        order.setCustomerId(customerId);

        int i = 1;
        for (CartItem cartItem : cart.getCartItems().values()) {
            OrderPosition orderPosition = new OrderPosition(i++);
            orderPosition.setArticle(cartItem.getArticle());
            orderPosition.setArticleQuantity(cartItem.getQuantity());
            order.addOrderPosition(orderPosition);
        }

        customer.addOrder(order);
        return order;
    }

    public Cart getCartForCustomer(Integer customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Kunde mit ID " + customerId + " nicht gefunden.");
        }
        return customer.getCart();
    }
}
