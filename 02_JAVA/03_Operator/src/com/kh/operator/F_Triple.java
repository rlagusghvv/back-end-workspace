package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
		f.practice1();
		f.practice2();
		f.practice3();
		/*
		 * 삼항 연산자
		 * 
		 * 조건식 ? 값1 : 값2;
		 * 
		 * - 조건식에는 주로 비교, 논리 연산자가 사용된다. - 조건식의 결과가 true이면 값1을 반환한다. - 조건식의 결과가 false이면
		 * 값2를 반환한다.
		 * 
		 * 
		 */

	}

	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.print("정수 값을 입력해주시오 : ");
		int result = sc.nextInt();
		// 0이다 포함
		String resulttf = result > 0 ? "양수" : result == 0 ? "0이다" : "음수";
		System.out.println(resulttf);
	}

	/*
	 * 실습문제 1 사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 크거나 같은 경우 "결과가 100 이상입니다." 아닌
	 * 경우 "결과가 100 보다 작습니다." 출력
	 */
	public void practice1() {
		System.out.println("정수값 두개를 입력해주세요 : ");
		int int1 = sc.nextInt();
		int int2 = sc.nextInt();
		int int3 = int1 * int2;
		String result = int3 >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.";
		System.out.println(result);

	}
	/*
	 * 실습문제 2 사용자한테 문자 하나를 입력받아 입력한 문자가 대문자이면 "알파벳 대문자이다." 아닌 경우 "알파벳 대문자가 아니다" 출력
	 */

	public void practice2() {
		System.out.print("문자를 하나 입력해주세요 : ");
	    char char1 = sc.next().charAt(0);
	    String result = 65 <= char1 && char1 <= 90 ? "알파벳 대문자입니다." : "알파벳 대문자가 아닙니다.";
	    // String result = 'A' <= char1 && char1 <= 'Z'
	    System.out.println(result);

	}
	/*
	 * 실습문제 3 두 정수를 입력 받고 + 또는 -를 입력받아서 계산을 출력 단, + 또는 - 이외의 문자를 입력하는 경우
	 * "잘못 입력했습니다." 출력
	 * 
	 * 예시) 첫번째 수 > 3 두번째 수 > 4 연산자 입력 (+ 또는 -) > + 3 + 4 = 7
	 * 
	 * 연산자 입력 > - 3 - 4 = -1
	 * 
	 * 연산자 입력 > * 잘못 입력했습니다.
	 *
	 */

	public void practice3() {
		System.out.println("정수값 두개를 입력해주세요 : ");
		int int1 = sc.nextInt();
		int int2 = sc.nextInt();
		int intd = int1 + int2;
		int intm = int1 - int2;
		System.out.print("연산자 + 또는 -를 선택해주세요 : ");
	    char ch1 = sc.next().charAt(0);
	    String result = ch1 == '+' ? Integer.toString(intd) : ch1 == '-' ? Integer.toString(intm): "잘못 입력했습니다.";
	    //Integer.toString() 기본형 등을 문자열로 형 변환 가능!!!
	    
//	    // 조건문 사용! 
//	    if(ch1 == '-' || ch1 == '+') {
//	    	System.out.printf("%d %c %d = %d", int1, ch1, int2, ch1 == '+' ? intd : intm);
//	    } else {
//	        System.out.println("잘못 입력했습니다.");
//	    }
//	    // String.format을 사용하는 방법
//	    result = ch1 == '+'
//	    		? String.format("%d + %d = %d", int1, int2, (int1 + int2))
//	    				: ch1 == '-'
//	    						? String.format("%d - %d = %d", int1, int2, (int1 - int2))
//	    								: "잘못 입력했습니다.";
	    
	    System.out.println(result);
	    
	}
}
