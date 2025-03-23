package com.example.article.component.structure;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogId;

    @ManyToMany
    @JoinTable(
        name = "catalog_articles",
        joinColumns = @JoinColumn(name = "catalog_id"),
        inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private Set<Article> articles = new HashSet<>();

    // Standardkonstruktor für JPA
    public Catalog() {}

    public Catalog(Set<Article> articles) {
        this.articles = articles;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    // Methode zum Artikel finden
    public Article getArticle(int articleId) {
        return articles.stream()
                .filter(article -> article.getArticleId() == articleId)
                .findFirst()
                .orElse(null);
    }

    // Methode zum Artikel hinzufügen
    public void addArticle(Article article) {
        this.articles.add(article);
    }
}

