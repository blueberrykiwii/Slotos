package de.leuphana.order.structure;

import de.leuphana.shop.structure.Article;

public class OrderPosition {

	private int positionId;
	private Article article;
	private int articleQuantity;

	public OrderPosition(int positionId) {
		this.positionId = positionId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getArticleQuantity() {
		return articleQuantity;
	}

	public void setArticleQuantity(int articleQuantity) {
		this.articleQuantity = articleQuantity;
	}

}