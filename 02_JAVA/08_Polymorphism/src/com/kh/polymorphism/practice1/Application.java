package com.kh.polymorphism.practice1;

import java.util.Scanner;

import com.kh.polymorphism.practice1.controller.LibarayController;

public class Application {
	Scanner sc = new Scanner(System.in);
	LibarayController lc = new LibarayController();
	public static void main(String[] args) {
		Application app = new Application();
		app.memberin();
		app.mainmenu();
		switch(app.mainmenu()) {
		case 1:
			app.mypage();
			
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
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public Stinrg mypage() {
		return System.out.println(lc.showmem());
	}
	
	
	
}
