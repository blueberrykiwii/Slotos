package com.example.order.component.behaviour;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;
import com.example.order.connector.OrderSpringDataMongoDBConnectorRequester;
import com.example.order.connector.ForeignArticleRestConnectorRequester;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderSpringDataMongoDBConnectorRequester orderRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ForeignArticleRestConnectorRequester articleConnector;

    public OrderService(OrderSpringDataMongoDBConnectorRequester orderRepository, 
                        RabbitTemplate rabbitTemplate, 
                        ForeignArticleRestConnectorRequester articleConnector) {
        this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.articleConnector = articleConnector;
    }

    // Bestellung per Messaging empfangen
    @RabbitListener(queues = "${queue.order}")
    public void receiveOrder(Order order) {
        System.out.println("Neue Bestellung empfangen: " + order);
        processIncomingOrder(order);
    }

    // Bestellauftrag verarbeiten (Artikelpreise abrufen & speichern)
    public void processIncomingOrder(Order order) {
        double totalPrice = 0.0;
        for (OrderPosition position : order.getOrderPositions()) {
            float articlePrice = getArticlePrice(position.getArticleId());
            if (articlePrice != null) {
                totalPrice += articlePrice * position.getArticleQuantity();
            } else {
                System.err.println("Fehler: Artikelpreis für Artikel-ID " + position.getArticleId() + " nicht gefunden.");
            }
        }
        System.out.println("Bestellung verarbeitet, Gesamtpreis: " + totalPrice);
        orderRepository.save(order);
    }

    // Bestellung speichern
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Bestellung nach ID abrufen
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    // Alle Bestellungen abrufen
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Bestellung löschen
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    // Artikelpreis per Feign Client abrufen
    private float getArticlePrice(String articleId) {
        try {
            return articleConnector.getArticleById(articleId).getPrice();
        } catch (Exception e) {
            System.err.println("Fehler beim Abrufen des Artikelpreises: " + e.getMessage());
            return null;
        }
    }
}
