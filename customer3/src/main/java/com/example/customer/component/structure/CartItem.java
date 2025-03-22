package com.example.customer.component.structure;

import com.example.customer.dto.ArticleDTO;

public class CartItem {
    private ArticleDTO article;
    private int quantity;
    private Integer cartItemId;

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
}
