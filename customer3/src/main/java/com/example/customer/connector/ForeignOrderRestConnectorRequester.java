package com.example.customer.connector;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.customer.dto.OrderDTO;

import java.util.List;


@FeignClient(name = "order3", path = "/orders") //heist der wirklcih order-service??
public interface ForeignOrderRestConnectorRequester {

    @GetMapping("/{orderId}")
    OrderDTO getOrderById(@PathVariable("orderId") String orderId);

    @GetMapping("/customer/{customerId}")
    List<OrderDTO> getOrdersByCustomerId(@PathVariable("customerId") Integer customerId);
}

//wieso habe ich beim 