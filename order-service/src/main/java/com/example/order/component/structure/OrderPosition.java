package com.example.order.component.structure;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderPosition {

    @Id
    private String positionId;
    private String articleId;  // Speichert nur die ID des Artikels
    private int articleQuantity;

    public OrderPosition() {}

    public OrderPosition(String positionId, String articleId, int articleQuantity) {
        this.positionId = positionId;
        this.articleId = articleId;
        this.articleQuantity = articleQuantity;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
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
