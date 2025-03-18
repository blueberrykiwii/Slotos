package com.example.order.component.behaviour;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;
import com.example.order.connector.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;

    private static final String ARTICLE_SERVICE_URL = "http://ARTICLE-SERVICE/articles/";

    @Autowired
    public OrderService(OrderRepository orderRepository, RabbitTemplate rabbitTemplate, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.restTemplate = restTemplate;
    }
 // Bestellung per Messaging empfangen
    @RabbitListener(queues = "${queue.order}")
    public void receiveOrder(Order order) {
        System.out.println("Neue Bestellung empfangen: " + order);
        // Bestellung direkt verarbeiten
        processIncomingOrder(order);
    }


    // Bestellauftrag empfangen (Messaging)
    public void processIncomingOrder(Order order) {
        // Artikelpreise von ArticleService abrufen und Gesamtpreis berechnen
        double totalPrice = 0.0;
        for (OrderPosition position : order.getOrderPositions()) {
            Double articlePrice = getArticlePrice(position.getArticleId());
            if (articlePrice != null) {
                totalPrice += articlePrice * position.getArticleQuantity();
            }
        }
        System.out.println("Bestellung verarbeitet, Gesamtpreis: " + totalPrice);
        orderRepository.save(order);
    }

    // Methode zum Speichern einer Bestellung
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Methode zum Abrufen einer Bestellung nach ID (MongoDB nutzt String-IDs)
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

    // Methode zum Abrufen des Artikelpreises vom ArticleService
    private Double getArticlePrice(String articleId) {
        try {
            return restTemplate.getForObject(ARTICLE_SERVICE_URL + articleId + "/price", Double.class);
        } catch (Exception e) {
            System.err.println("Fehler beim Abrufen des Artikelpreises: " + e.getMessage());
            return null;
        }
    }
}
