package com.kh.polymorphism.practice1.model;

public class Member {
    private String name;
    private int age;
    private Book[] bookList;

    public Member() {
        this.bookList = new Book[5]; // 배열 크기를 필요한 만큼 설정
    }

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.bookList = new Book[5]; // 배열 크기를 필요한 만큼 설정
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book[] getBookList() {
        return bookList;
    }

    public void setBookList(Book[] bookList) {
        this.bookList = bookList;
    }
}