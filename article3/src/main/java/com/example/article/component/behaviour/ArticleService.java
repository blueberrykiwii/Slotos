package com.example.article.component.behaviour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.article.component.structure.Article;
import com.example.article.connector.ArticleSpringDataConnectorRequester;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleSpringDataConnectorRequester articleRepository;

    @Autowired
    public ArticleService(ArticleSpringDataConnectorRequester articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Artikel speichern
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    // Artikel nach ID suchen
    public Optional<Article> getArticleById(Integer id) {
        return articleRepository.findById(id);
    }
    

    // Alle Artikel abrufen
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Artikel löschen
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
}
