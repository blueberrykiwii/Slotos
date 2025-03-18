package com.example.shop.component.behaviour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.article.component.structure.Article;
import com.example.customer.component.structure.Cart;
import com.example.customer.component.structure.Customer;
import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;
import com.example.shop.connector.ForeignArticleRestConnectorRequester;
import com.example.shop.connector.ForeignCustomerRestConnectorRequester;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
@Service

//Du musst den Eureka Client in der ShopConfiguration registrieren, 
//damit der Shop-Service beim Eureka Server als Client bekannt wird und seine Dienste anderen Microservices zur Verfügung stellen kann.
public class ShopService {

    private final RabbitTemplate rabbitTemplate;
    private final ForeignArticleRestConnectorRequester articleClient;
    private final ForeignCustomerRestConnectorRequester customerClient;


    @Value("${exchange.order}")
    private String exchange;

    @Value("${routing.order}")
    private String routingKey;

    @Autowired
    public ShopService(RabbitTemplate rabbitTemplate, ForeignArticleRestConnectorRequester articleClient, ForeignCustomerRestConnectorRequester customerClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.articleClient = articleClient;
        this.customerClient = customerClient;
    }


    // Bestellung an Order-Service senden (RabbitMQ)
    public void sendOrder(Order order) {
        System.out.println("Sende Bestellung an Order-Service: " + order);
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
    }	
    //Die anderen Microservices brauchen keine Feign Clients für Shop, weil Shop nur ein orchestrierender Service ist und selbst keine externen Requests empfängt.
    //Feign Clients, um REST-Anfragen an andere Microservices zu schicken.
    // Katalog-Artikel holen (via Feign-Client)
    public Article getArticle(int articleId) {
        return articleClient.getArticle(articleId);
    }

    // Warenkorb eines Kunden holen (via Feign-Client)
    public Cart getCartForCustomer(Integer customerId) {
        return customerClient.getCartForCustomer(customerId);
    }

    // Artikel zum Warenkorb eines Kunden hinzufügen (via Feign-Client)
    public void addArticleToCart(Integer customerId, Integer articleId) {
        customerClient.addArticleToCart(customerId, articleId);
    }

 // Artikel aus dem Warenkorb eines Kunden entfernen
    public void removeArticleFromCart(Integer customerId, int articleId) {
        customerClient.removeArticleFromCart(customerId, articleId);
    }
    
    public void checkOut(String customerId) {
        Order order = new Order(customerId);  // Erstelle eine neue Bestellung mit der Customer-ID
        System.out.println("Sende Bestellung an Order-Service via RabbitMQ: " + order);
        rabbitTemplate.convertAndSend(exchange, routingKey, order);  // Senden an RabbitMQ
    }




}
