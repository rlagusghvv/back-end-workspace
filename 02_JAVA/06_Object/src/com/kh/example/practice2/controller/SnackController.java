package com.kh.example.practice2.controller;

import java.util.Scanner;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	Scanner sc = new Scanner(System.in);

	private Snack s = new Snack();

	public String saveDate(String kind, String name, String flavor, int numOf, int price) {
		// 데이터를 setter를 이용해 저장하고 "저장 완료되었습니다." 결과를 반환!
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다!";
	}
	
	// 백단에서 데이터를 기입받는 view 영역의 코드를 가지고 있어서는 안됨!
//	public void saveDate() {
//		// ------------------------------------------ 모델, 컨트롤러를 나누지 않고 메인에서 모든 코드를 짜는 경우
//		System.out.println("스낵류를 입력하세요.");
//		System.out.print("종류 : ");
//		String kind = sc.next();
//		s.setKind(kind);
//		System.out.print("이름 : ");
//		String name = sc.next();
//		s.setName(name);
//		System.out.print("맛 : ");
//		String flavor = sc.next();
//		s.setFlavor(flavor);
//		System.out.print("개수 : ");
//		int numOf = sc.nextInt();
//		s.setNumOf(numOf);
//		System.out.print("가격 : ");
//		int price = sc.nextInt();
//		// ------------------------------------------
//		// --> 여기까지는 controller나 model에 직접 접근 X
//
//		// 데이터를 서버에 요청! 서버에 전달할 때는 controller로!
//		s.setPrice(price);
//		System.out.println("저장 완료되었습니다.");
//	}

	public String confirmData() {
		
		return s.getKind() + "(" + s.getName() + "-" + s.getFlavor() + ")" + s.getNumOf() + "개 " + s.getPrice() + "원";
	}
}
