package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SnackController c = new SnackController();
		
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("맛 : ");
		String flavor = sc.next();
		
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		
		// 서버한테 요청해, 응답받은 결과를 다시 화면으로!!!
	    System.out.println(c.saveDate(kind, name, flavor, numOf, price));
	    System.out.println(c.confirmData());
	}

}
