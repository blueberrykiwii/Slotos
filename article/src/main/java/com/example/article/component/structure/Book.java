package com.example.article.component.structure;
import jakarta.persistence.*;


@Entity
public class Book extends Article {

    private String author;

    @Enumerated(EnumType.STRING) // Enum als String speichern
    private BookCategory bookCategory;

    // Standardkonstruktor für JPA
    public Book() {
        super();
    }

    // Konstruktor mit den Feldern
    public Book(int articleId, String author, BookCategory bookCategory) {
        super(articleId);
        this.author = author;
        this.bookCategory = bookCategory;
    }

    // Getter und Setter
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
