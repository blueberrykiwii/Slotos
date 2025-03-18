package com.example.shop.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.customer.component.structure.Cart;

@FeignClient(name = "customer-service", url = "http://customer-service")
public interface ForeignCustomerRestConnectorRequester {

    @GetMapping("/customers/{customerId}/cart")
    Cart getCartForCustomer(@PathVariable Integer customerId);

    @PostMapping("/customers/{customerId}/cart/articles/{articleId}")
    void addArticleToCart(@PathVariable Integer customerId, @PathVariable Integer articleId);

    @DeleteMapping("/customers/{customerId}/cart/articles/{articleId}")
    void removeArticleFromCart(@PathVariable Integer customerId, @PathVariable Integer articleId);
}
