package de.leuphana.article.structure;

import de.leuphana.shop.structure.Article;

public class CD extends Article {

	private String artist;

	public CD(int articleId) {
		super(articleId);
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}