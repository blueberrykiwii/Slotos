package com.example.order.component.behaviour;

import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;
import com.example.order.connector.ForeignArticleRestConnectorRequester;
import com.example.order.connector.ForeignCustomerRestConnectorRequester;
import com.example.order.connector.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;

    private final ForeignArticleRestConnectorRequester articleClient; // FeignClient für Article
    private final ForeignCustomerRestConnectorRequester customerClient; // FeignClient für Customer

    @Autowired
    public OrderService(OrderRepository orderRepository, RabbitTemplate rabbitTemplate,
                        ForeignArticleRestConnectorRequester articleClient,
                        ForeignCustomerRestConnectorRequester customerClient) {
        this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.articleClient = articleClient;
        this.customerClient = customerClient;
    }

    // Bestellung per Messaging empfangen
    @RabbitListener(queues = "${queue.order}")
    public void receiveOrder(Order order) {
        System.out.println("Neue Bestellung empfangen: " + order);
        // Bestellung direkt verarbeiten
        processIncomingOrder(order);
    }

    // Bestellauftrag verarbeiten (z.B. Artikelpreise abrufen, Gesamtpreis berechnen)
    public void processIncomingOrder(Order order) {
        double totalPrice = 0.0;
        // Durch alle Bestellpositionen iterieren und Artikelpreise berechnen
        for (OrderPosition position : order.getOrderPositions()) {
            Double articlePrice = getArticlePrice(position.getArticleId());
            if (articlePrice != null) {
                totalPrice += articlePrice * position.getArticleQuantity();
            }
        }
        System.out.println("Bestellung verarbeitet, Gesamtpreis: " + totalPrice);

        // Bestellung speichern (MongoDB)
        order.setTotalPrice(totalPrice); // Gesamtpreis auf die Bestellung setzen
        orderRepository.save(order);  // Bestellung in der DB speichern
    }

    // Artikelpreis vom Article-Service über FeignClient abrufen
    private Double getArticlePrice(String articleId) {
        try {
            // Anfrage an Article-Service senden
            return (double) articleClient.getArticle(articleId).getPrice(); // Hier wird der Preis des Artikels abgerufen
        } catch (Exception e) {
            System.err.println("Fehler beim Abrufen des Artikelpreises: " + e.getMessage());
            return null;
        }
    }

    // Methode zum Speichern einer Bestellung
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Methode zum Abrufen einer Bestellung nach ID
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    // Methode zum Abrufen aller Bestellungen
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Methode zum Löschen einer Bestellung
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    
    }
}

