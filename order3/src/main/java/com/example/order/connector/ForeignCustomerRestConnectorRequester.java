package com.example.order.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.customer.component.structure.Customer;


@FeignClient(name = "customer-service", url = "http://localhost:8081")
public interface ForeignCustomerRestConnectorRequester {

    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable String id);
}
