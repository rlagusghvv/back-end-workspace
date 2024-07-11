package com.kh.practice1.model;

public class Song_copy {
	private String songTitle;
	private String singer;

	public Song_copy() {
	}

	public Song_copy(String songTitle, String singer) {
		super();
		this.songTitle = songTitle;
		this.singer = singer;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return singer + " - " + songTitle;
	}
	
	

}
