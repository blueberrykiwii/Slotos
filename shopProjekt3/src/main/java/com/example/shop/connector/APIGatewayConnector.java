package com.example.shop.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.example.article.component.structure.Article;
import com.example.customer.component.structure.Customer;
import com.example.order.component.structure.Order;

//API Gateway Client
@FeignClient(name = "api-gateway-service")
public interface APIGatewayConnector {
 // Hauptfunktionen über API Gateway
 @GetMapping("/customer-service/customers/{customerId}")
 Customer getCustomer(@PathVariable Integer customerId);
 
 @GetMapping("/article-service/articles/{articleId}")
 Article getArticle(@PathVariable("articleId") int articleId);
 
 @GetMapping("/order-service/orders/{orderId}")
 Order getOrder(@PathVariable Integer orderId);
}
