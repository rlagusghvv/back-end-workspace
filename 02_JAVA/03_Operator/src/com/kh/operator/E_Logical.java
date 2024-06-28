package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
    Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.method3();
		/**
		 * 논리 연산자
		 * - 두 개의 논리값을 연산해주는 연산자 
		 * - 논리연산한 결과마저 논리값 
		 * 
		 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true인 경우만 결과값이 true
		 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중 하나만 true인 경우에도 true
		 */

	}
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100사이의 값인지 확인
		
		System.out.print("정수값을 입력해주세요 : ");
		int num1 = sc.nextInt();
	    boolean result = num1 >= 1 && num1 <= 100;
		System.out.println("입력값은 1부터 100사이의 값 일까요?");
	    System.out.println(num1 + " " + result);
	}
	public void method2() { 
		int number = 10;
		boolean result = false;
		
		
		// &&
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false = false
		
		// && 연산자를 기준으로 앞에서 이미 false인 경우 굳이 뒤쪽의 연산을 수행하지 않음!
		// Short Cut Evaluation!!
		// 아래 number가 10인 이유!
		
		result = number < 5 && ++number > 0;
		System.out.println(result); // false
		System.out.println(number); // 10
		
		// ||
		// true || true = true
		// false || true = true
		// true || false = true
		// false || false = false
		result = (number < 20) || (++number > 0);
		
		System.out.println(result); // true
		System.out.println(number); // 10
	}
	/*
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * A ~ Z : 65 ~ 90, a ~ Z : 97 ~ 122
	 */
	public void method3() {
    System.out.print("문자를 입력하시오 : ");
    char word = sc.next().charAt(0);
    boolean result = (65 <= word && word <= 90) || (97 <= word && word <= 122);
    System.out.println(word + "는 알파벳이 " + result);
	}
}
