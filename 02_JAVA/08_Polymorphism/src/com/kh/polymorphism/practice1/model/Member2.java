package com.kh.polymorphism.practice1.model;

import java.util.Arrays;

public class Member2 {

	private String name;
	private int age;
	private int coupon;
	private Book2[] bookList = new Book2[2];
	
	public Member2() {
	}
	public Member2(String name, int age, int coupon, Book2[] bookList) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
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
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book2[] getBookList() {
		return bookList;
	}
	public void setBookList(Book2[] bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
}
