package com.kh.polymorphism.practice1.controller;

import java.util.ArrayList;

import com.kh.polymorphism.practice1.model.Book2;
import com.kh.polymorphism.practice1.model.Member2;

public class LibaryController2 {

	private Member2 member = new Member2();
	int count = 0;
	
	// 내 정보 추가
	public void addMember(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}
	
	// 마이페이지
	public Member2 myPage() {
		return member;
	}
	
	// 책 대여
	public String rentBook(Book2 book) {
		ArrayList<Book2> bookList = member.getBookList();
		
		// 이미 대여한 책은 대여 불가능하게 만들어야 하는 경우
		for(Book2 value : bookList) {
			if(value != null && value.equals(book)) {
				return "이미 대여한 책입니다.";
			} 
		}
		
		if(bookList.size() < 2) {
			if(member.getAge() < book.getAccessAge()) {
				return "나이 제한으로 대여 불가능입니다.";
			}
			
			bookList.add(book);
			
			if(book.isCoupon()) {
				member.setCoupon(member.getCoupon() + 1);
			}
			
			return "성공적으로 대여되었습니다.";
		}
		
		return "더 이상 대여할 수 없습니다.";
		
	}
				
}