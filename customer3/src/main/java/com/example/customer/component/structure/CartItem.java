package com.example.customer.component.structure;

import com.example.customer.dto.ArticleDTO;
import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @Transient // Da ArticleDTO kein @Entity ist, wird es nicht in der DB gespeichert
    private ArticleDTO article;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartItem() {}

    public CartItem(ArticleDTO article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public ArticleDTO getArticle() {
        return article;
    }

    public void setArticle(ArticleDTO article) {
        this.article = article;
    }
    
    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
