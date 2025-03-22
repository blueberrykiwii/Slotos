package com.example.order.connector;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ForeignOrderRestConnectorRequester {

    @RabbitListener(queues = "shop-to-order-queue")
    public void receiveMessage(String message) {
        System.out.println("Order-Service hat Nachricht erhalten: " + message);
        
        // Hier kannst du die Nachricht weiterverarbeiten (z.B. speichern oder eine Order anlegen)
    }
}
