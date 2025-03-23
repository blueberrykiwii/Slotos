package com.example.shop.connector;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.article.component.structure.Article;
import com.example.customer.component.structure.Cart;

@FeignClient(name = "article-service")
public interface ForeignArticleRestConnectorRequester {
    @GetMapping("/articles")
    List<Article> getAllArticles();
 @GetMapping("/customers/{customerId}/cart")
 Cart getCartForCustomer(@PathVariable Integer customerId);
 

}