package com.example.articleservice.component.structure;

public class CD extends Article {

	private String artist;
	
	public CD() {
	}

	public void setArticleId(int articleId) {
		super.setArticleId(articleId);
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}