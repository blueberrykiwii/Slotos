package com.example.customer.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.customer.dto.OrderDTO;

import java.util.List;

@FeignClient(name = "order-service", path = "/orders") // Prüfe, ob dein Service wirklich "order-service" heißt!
public interface ForeignOrderRestConnectorRequester {

    @GetMapping("/{orderId}")
    OrderDTO getOrderById(@PathVariable("orderId") String orderId);  // ✅ Name hinzugefügt

    @GetMapping("/customer/{customerId}")
    List<OrderDTO> getOrdersByCustomerId(@PathVariable("customerId") Integer customerId);  // ✅ Typ auf String geändert
}

//wieso habe ich beim 