package com.example.customer.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.order.component.structure.Order; // Direkter Import der Order-Klasse

import java.util.List;

@FeignClient(name = "order-service", url = "http://localhost:8082")
public interface ForeignOrderRestConnectorRequester {

    @GetMapping("/orders/by-customer/{customerId}")
    List<Order> getOrdersByCustomerId(@PathVariable Integer customerId);
}
