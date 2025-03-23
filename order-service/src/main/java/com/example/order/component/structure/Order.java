package com.example.order.component.structure;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String orderId;
    private String customerId;  // Speichert nur die ID des Kunden
    private List<OrderPosition> orderPositions = new ArrayList<>();
    private float totalPrice;  // Gesamtpreis der Bestellung

    public Order() {
    }
    public Order(String customerId) {
        this.customerId = customerId;
    }

    public Order(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderPositions = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    // ✅ Methode zum Hinzufügen einer OrderPosition
    public void addOrderPosition(OrderPosition orderPosition) {
        this.orderPositions.add(orderPosition);
    }

    // ✅ Methode zur Berechnung der Gesamtanzahl der Artikel in der Bestellung
    public int getNumberOfArticles() {
        int numberOfArticles = 0;
        for (OrderPosition orderPosition : orderPositions) {
            numberOfArticles += orderPosition.getArticleQuantity();
        }
        return numberOfArticles;
    }
}
