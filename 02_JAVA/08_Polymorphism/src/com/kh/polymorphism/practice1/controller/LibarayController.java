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
		
	}
	
	public String lendBook(Member[] members, Book[] books) {
		return null;
	}
	
	public String returnBook(Member[] members, Book[] books) {
		return null;
	}
	
	public Member[] showmem (Member[] members) {
		
		return 
		member.getName();
		member.getAge();
		member.getCoupon();
		member.getBookList();
		
	}
}
