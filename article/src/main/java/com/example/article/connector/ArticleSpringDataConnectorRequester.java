package com.example.article.connector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.article.component.structure.Article;

@Repository
public interface ArticleSpringDataConnectorRequester extends JpaRepository<Article, Integer> {
    // Hier kannst du zusätzliche Abfragen definieren, falls nötig
}
