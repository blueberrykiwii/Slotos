package com.example.article.component.structure;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
@PrimaryKeyJoinColumn(name = "article_id")  // Verknüpfung mit `articles`
public class Book extends Article {

    private String author;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    public Book() {}

    public Book(String manufactor, String name, float price, String author, BookCategory bookCategory) {
        super(manufactor, name, price);
        this.author = author;
        this.bookCategory = bookCategory;
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

