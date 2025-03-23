package com.example.shop.connector;

import com.example.customer.component.structure.Cart;
import com.example.customer.component.structure.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer3", url = "http://localhost:8081") // ich muss hier nochmal schauen ob das wirklich der richtige Port ist
public interface CustomerFeignClient {

    @GetMapping("/customers")
    List<Customer> getAllCustomers();

    @PostMapping("/customers")
    void createCustomer(@RequestBody Customer customer);

    @GetMapping("/customers/{customerId}/cart")
    Cart getCartForCustomer(@PathVariable("customerId") Integer customerId);

    @PostMapping("/customers/{customerId}/cart/{articleId}")
    void addArticleToCart(@PathVariable("customerId") Integer customerId, 
                          @PathVariable("articleId") Integer articleId);

    @DeleteMapping("/customers/{customerId}/cart/{articleId}")
    void removeArticleFromCart(@PathVariable("customerId") Integer customerId, 
                               @PathVariable("articleId") Integer articleId);
}
