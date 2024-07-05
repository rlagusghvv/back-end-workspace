package com.kh.example.practice1.model;

public class Member {

	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public Member () {}
	
	public Member (String id, String pwd, String name, int age, char gender, String phone, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + "]";
	}

	public void changeName(String name) {
		this.name = name;
	};
	
	public void printName() {
		System.out.println(name);
	};
}
	
