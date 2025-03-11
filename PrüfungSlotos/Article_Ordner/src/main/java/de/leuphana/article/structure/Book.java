package de.leuphana.article.structure;

import de.leuphana.shop.structure.Article;
import de.leuphana.shop.structure.BookCategory;

public class Book extends Article {

	private String author;
	private BookCategory bookCategory;

	public Book(int articleId) {
		super(articleId);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

}