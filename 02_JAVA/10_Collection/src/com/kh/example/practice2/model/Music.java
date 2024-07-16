package com.kh.example.practice2.model;

import java.util.Objects;

public class Music {
	private String artist;
	private String song;
	
	
	public Music() {
	}


	public Music(String artist, String song) {
		super();
		this.artist = artist;
		this.song = song;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getSong() {
		return song;
	}


	public void setSong(String song) {
		this.song = song;
	}


	@Override
	public String toString() {
		return artist + " - " + song; 
	}


	@Override
	public int hashCode() {
		return Objects.hash(artist, song);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(song, other.song);
	}
	
	

}
