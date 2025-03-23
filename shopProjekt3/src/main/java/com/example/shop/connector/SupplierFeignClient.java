package com.example.shop.connector;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.example.article.component.structure.Article;

import java.util.List;

@FeignClient(name = "article-service") // Später über Service Discovery
public interface SupplierFeignClient {

    @PostMapping("/articles")
    void createArticle(@RequestBody Article article);

    @PutMapping("/articles/{id}")
    void updateArticle(@PathVariable int id, @RequestBody Article article);

    @DeleteMapping("/articles/{id}")
    void deleteArticle(@PathVariable int id);

    @GetMapping("/articles/{id}")
    Article getArticle(@PathVariable int id);

    @GetMapping("/articles")
    List<Article> getAllArticles();
}
