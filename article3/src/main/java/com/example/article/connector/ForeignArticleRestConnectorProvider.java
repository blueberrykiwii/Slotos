package com.example.article.connector;

import com.example.article.component.structure.Article;
import com.example.article.component.behaviour.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ForeignArticleRestConnectorProvider {

    private final ArticleService articleService;

    public ForeignArticleRestConnectorProvider(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticleById(@PathVariable String id) {
        return articleService.getArticleById(id);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
    }
}
