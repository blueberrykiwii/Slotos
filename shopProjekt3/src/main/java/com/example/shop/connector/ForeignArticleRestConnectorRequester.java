package com.example.shop.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.article.component.structure.Article;

@FeignClient(name = "article-service")  // Name des Microservices in Eureka
public interface ForeignArticleRestConnectorRequester {

    @GetMapping("/articles/{articleId}")
    Article getArticle(@PathVariable("articleId") int articleId);
}
