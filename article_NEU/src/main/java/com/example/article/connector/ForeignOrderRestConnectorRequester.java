package com.example.article.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.article.component.structure.Article;

@FeignClient(name = "order-service", url = "http://localhost:8083")
public interface ForeignOrderRestConnectorRequester {

    @GetMapping("/orders/articles/{id}")
    Article getArticleById(@PathVariable String id);
}
