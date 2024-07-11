package com.kh.polymorphism.practice1;

import java.util.Scanner;

import com.kh.polymorphism.practice1.controller.LibarayController;
import com.kh.polymorphism.practice1.model.Book;
import com.kh.polymorphism.practice1.model.Member;

public class Application {
	Scanner sc = new Scanner(System.in);
	LibarayController lc = new LibarayController();
	public static void main(String[] args) {
		Application app = new Application();
		Scanner sc = new Scanner(System.in);
		LibarayController lc = new LibarayController();
		Member member = new Member();
		// 책 정보 인서트
		Book[] book = new Book[4];
		book[0] = new Book("밥을 지어요", true, 0);
		book[1] = new Book("오늘은 아무래도 덮밥", false, 0);
		book[2] = new Book("원피스 108", false, 15);
		book[3] = new Book("귀멸의 칼날 23", false, 19);
		
		while(true) {
		app.memberin();
		switch(app.mainmenu()) {
		case 1:
			app.mypage();
			break;
		case 2:
//			lc.showbook();
			for(int i = 0; i < book.length; i++) {
				System.out.println((i+1) + "번 도서 : " + book[i]);
			}
			System.out.print("대여할 도서 번호 선택 : ");
			int select = Integer.parseInt(sc.nextLine());
			// select 번호에 따라서 해당 책이 Member - bookList에 추가
		    member.getBookList()[0] = book[select-1];
			
			
		}
		}
        
}
	public void memberin () {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");	
		int age = Integer.parseInt(sc.nextLine());
		lc.addMember(name, age);
	}
	
	public int mainmenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public void mypage() {
		System.out.println(lc.showmem());
	}
	
   
	
	
	
	
}
