package com.example.order.connector;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ForeignShopJMSConnectorReceiver {

    @JmsListener(destination = "shop-to-order-queue")
    public void receiveMessage(String message) {
        System.out.println("Received order message from Shop: " + message);
        // Hier kannst du die empfangene Bestellung weiterverarbeiten
    }
}
