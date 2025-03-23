package com.example.article.component.structure;

import jakarta.persistence.*;

@Entity
@Table(name = "cds")
@PrimaryKeyJoinColumn(name = "article_id")  // Verknüpfung mit `articles`
public class CD extends Article {

    private String artist;

    public CD() {}

    public CD(String manufactor, String name, float price, String artist) {
        super(manufactor, name, price);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

