package com.example.articleservice.component.structure;

// Java Bean
// POJO (Plain Old Java Object)
public class Article {
	// ehemals attribute
	// bei Java Bean ist dies ein property
	private Integer articleId;
	private String manufactor;
	private String name;
	private float price;
	
	public Article() {
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getArticleId() {
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