package com.example.order.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.article.component.structure.Article;

@FeignClient(name = "article-service", url = "http://localhost:8082")
public interface ForeignArticleRestConnectorRequester {

    @GetMapping("/articles/{id}")
    Article getArticleById(@PathVariable String id);
}
