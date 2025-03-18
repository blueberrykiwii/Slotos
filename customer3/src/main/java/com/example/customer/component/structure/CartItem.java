package com.example.customer.component.structure;

import javax.persistence.*;

import com.example.article.component.structure.Article;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart; // Beziehung zu Cart

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article; // Beziehung zu Article

    private int quantity;

    // Standardkonstruktor
    public CartItem() {
    }

    // Konstruktor mit Artikel und Menge
    public CartItem(Article article) {
        this.article = article;
        this.quantity = 1;
    }

    // Getter und Setter
    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        this.quantity--;
    }
}
