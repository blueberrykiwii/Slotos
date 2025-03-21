package com.example.customer.dto;

public class OrderPositionDTO {
    private String articleId;
    private int articleQuantity;

    public OrderPositionDTO() {}

    public OrderPositionDTO(String articleId, int articleQuantity) {
        this.articleId = articleId;
        this.articleQuantity = articleQuantity;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public int getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(int articleQuantity) {
        this.articleQuantity = articleQuantity;
    }
}
