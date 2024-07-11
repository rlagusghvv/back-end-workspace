package com.kh.practice1.model;

public class Song {
    // 필드
    private String title; // 곡 제목
    private String singer; // 가수 이름

    // 생성자
    public Song(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    // getter 메서드
    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    // setter 메서드
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    // toString 메서드
    @Override
    public String toString() {
        return singer + " - " + title;
    }
}