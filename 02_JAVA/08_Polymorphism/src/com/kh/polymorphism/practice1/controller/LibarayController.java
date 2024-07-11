package com.kh.polymorphism.practice1.controller;

import com.kh.polymorphism.practice1.model.Book;
import com.kh.polymorphism.practice1.model.Member;

public class LibarayController {

	private Member member = new Member();
	private Book book = new Book();

	public void addMember(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}

	public void addBook(Book[] books) {
		// 책 정보 인서트
		books[0] = new Book("밥을 지어요", true, 0);
		books[1] = new Book("오늘은 아무래도 덮밥", false, 0);
		books[2] = new Book("원피스 108", false, 15);
		books[3] = new Book("귀멸의 칼날 23", false, 19);
	}

	public String lendBook(Member[] members, Book[] books) {
		return null;
	}

	public String returnBook(Member[] members, Book[] books) {
		return null;
	}

	public Member showmem() {

		return member;

	}
	
	public Book showbook() {

		return book;

	}
	
}
