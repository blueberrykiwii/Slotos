package com.example.article.component.structure;
import jakarta.persistence.*;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatische ID-Generierung
    private int articleId;

    private String manufactor;
    private String name;
    private float price;

    // Standardkonstruktor für JPA
    public Article() {
    }

    // Konstruktor mit articleId
    public Article(int articleId) {
        this.articleId = articleId;
    }

    // Konstruktor für den Artikel
    public Article(String manufactor, String name, float price) {
        this.manufactor = manufactor;
        this.name = name;
        this.price = price;
    }

    // Getter und Setter
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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
