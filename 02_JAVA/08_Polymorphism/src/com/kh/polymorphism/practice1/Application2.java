package com.kh.polymorphism.practice1;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.polymorphism.practice1.model.Book2;

import com.kh.polymorphism.practice1.model.Member2;


public class Application2 {
	
		
		Scanner sc = new Scanner(System.in);
		Member2 member = new Member2();
		Book2[] books = {new Book2("밥을 지어요", true, 0), 
					new Book2("오늘은 아무래도 덮밥", false, 0), 
					new Book2("원피스 108", false, 15), 
					new Book2("귀멸의 칼날 23", false, 19)};

		public static void main(String[] args) {
			Application2 app = new Application2();
			app.menu();
		}
		
		public void menu() {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			member.setName(name);
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			member.setAge(age);
			
			while(true) {
				System.out.println("==== 메뉴 ====");
				System.out.println("1. 마이페이지");
				System.out.println("2. 도서 대여하기");
				System.out.println("3. 프로그램 종료하기");
				System.out.print("메뉴 번호 : ");
				int number = Integer.parseInt(sc.nextLine());
				
				if(number == 1) {
					System.out.println(member);
				} else if(number == 2) {
					for(int i = 0; i < books.length; i++) {
						System.out.println((i+1) + "번 도서 : " + books[i]);
					}
					System.out.print("대여할 도서 번호 선택 : ");
					int select = Integer.parseInt(sc.nextLine());
					// select(index+1) 번호에 따라서 해당 책이 Member - bookList에 추가
					member.getBookList()[0] = books[select-1];
					
					
					
				}
				
			}
			
			
			
		}
		
		

	}
