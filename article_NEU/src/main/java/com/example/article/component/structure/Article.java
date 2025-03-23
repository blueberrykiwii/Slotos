package com.example.article.component.structure;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  // Tabellen für Unterklassen
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;

    private String manufactor;
    private String name;
    private float price;

    public Article() {}

    public Article(String manufactor, String name, float price) {
        this.manufactor = manufactor;
        this.name = name;
        this.price = price;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

