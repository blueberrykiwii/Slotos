package com.example.customer.dto;

public class ArticleDTO {
    private int articleId;
    private String manufactor;
    private String name;
    private float price; 

    public ArticleDTO() {}

    // Konstruktor mit articleId
    public ArticleDTO(int articleId) {
        this.articleId = articleId;
    }
    
    public ArticleDTO(String manufactor, String name, float price) {
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
