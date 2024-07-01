package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		OperatorPractice b = new OperatorPractice();
//		b.method1();
//		b.method2();
//		b.method3();
//		b.method4();
//		b.method5();
//		b.method6();
		b.method7();
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.println("인원 수와 연필 개수를 입력하시오");
		int men = sc.nextInt();
		int pencil = sc.nextInt();
		
		System.out.println("1인당 연필 개수 : " + (pencil/men) + "\n남은 연필 개수 : " + (pencil%men));

	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("무작위 숫자를 입력하시오");
		int num = sc.nextInt();
		int result = num >= 100 ? num - (num%100) : num;
		// double result = num / 100 * 100
		System.out.println(result);

	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("무작위 3개의 숫자를 입력하시오");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
	    String result = num1 == num2 && num2 == num3 ? "true" : "false";
	    // boolean result = num1 == num2 && num2 == num3
	    System.out.println(result);
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("무작위 정수를 입력하시오");
		int num1 = sc.nextInt();
		
	   String result = num1%2 == 0 ? "짝수다" : "짝수가 아니다.";
	   System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.println("주민번호를 입력하시오(- 포함)");
		String num1 = sc.next();
		
		String result = num1.charAt(7) == '1' || num1.charAt(7) == '3' ? "남자" : num1.charAt(7) == '2' || num1.charAt(7) == '4' ?
				"여자" : "누구세요?";
		
		System.out.println(result);
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method6() {
			System.out.println("나이를 입력하시오");
			int age = sc.nextInt();
			
			String result = age <= 13  ? "어린이" : age <= 19 ? "청소년" : "성인";
			System.out.println(result);
		
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.println("사과 수와 바구니의 용량를 입력하시오");
		int apple = sc.nextInt();
		int basket = sc.nextInt();
		
		System.out.println((apple % basket == 0 ? apple/basket : apple / basket + 1 ) + "개면 사과를 전부 담을 수 있어요");
		// apple / basket + (apple % basket == 0 ? 0 : 1);
	}
	
}