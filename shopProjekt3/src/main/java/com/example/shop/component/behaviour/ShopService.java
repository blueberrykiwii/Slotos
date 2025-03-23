package com.example.shop.component.behaviour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.article.component.structure.Article;
import com.example.customer.component.structure.Cart;
import com.example.customer.component.structure.Customer;
import com.example.order.component.structure.Order;
import com.example.shop.connector.APIGatewayConnector;
import com.example.shop.connector.CustomerFeignClient;
import com.example.shop.connector.SupplierFeignClient;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

@Service
public class ShopService {
    private final RabbitTemplate rabbitTemplate;
    private final APIGatewayConnector apiGatewayConnector;
    private final CustomerFeignClient customerFeignClient;  // Bereits existierender Client
    private final SupplierFeignClient supplierFeignClient;  // Bereits existierender Client
    
    @Value("${exchange.order}")
    private String exchange;
    @Value("${routing.order}")
    private String routingKey;
    
    @Autowired
    public ShopService(RabbitTemplate rabbitTemplate, 
                      APIGatewayConnector apiGatewayConnector,
                      CustomerFeignClient customerFeignClient, 
                      SupplierFeignClient supplierFeignClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.apiGatewayConnector = apiGatewayConnector;
        this.customerFeignClient = customerFeignClient;
        this.supplierFeignClient = supplierFeignClient;
    }
    
    // Verwendung der direkten REST-Clients gemäß Deploymentdiagramm
    public Cart getCartForCustomer(Integer customerId) {
        return customerFeignClient.getCartForCustomer(customerId);
    }
    
    public Article getArticle(int articleId) {
        return supplierFeignClient.getArticle(articleId);
    }
    
    // API Gateway für erweiterte Funktionen
    public Order getOrderDetails(Integer orderId) {
        return apiGatewayConnector.getOrder(orderId);
    }
    
    // Messaging für Order-Service (bleibt unverändert)
    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
    }
      
    public List<Article> getAllArticles() {
        return supplierFeignClient.getAllArticles();
    }
    
    // API Gateway für allgemeine Operationen
    public Customer getCustomer(Integer customerId) {
        return apiGatewayConnector.getCustomer(customerId);
    }
    
    // Messaging für Order-Service
    public void createOrder(Order order) {
        // Bestellung über RabbitMQ senden
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
    }
}

