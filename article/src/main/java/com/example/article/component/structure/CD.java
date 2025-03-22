package com.example.article.component.structure;

import jakarta.persistence.*;


@Entity
public class CD extends Article {

    private String artist;

    // Standardkonstruktor für JPA
    public CD() {
        super();
    }

    // Konstruktor mit den Feldern
    public CD(int articleId, String artist) {
        super(articleId);
        this.artist = artist;
    }

    // Getter und Setter
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
