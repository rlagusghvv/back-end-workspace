package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {

	public static void main(String[] args) {
		D_Comparison d = new D_Comparison();
//		d.method1();
		d.method2();
		/*
		 * 비교 연산자 
		 * a < b : a가 b보다 작은가?
		 * a > b : a가 b보다 큰가? 
		 * a <= b : a가 b보다 작거나 같은가?
		 * a >= b : a가 b보다 크거나 같은가?
		 * a == b : a와 b가 같은가?
		 * a != b : a와 b가 같지 않은가?
		 * 
		 * - 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false
		 */

	}
	
	public void method1() {
	   int a = 10;
	   int b = 25;
	   
	   System.out.println(a == b); // false
	   System.out.println(a <= b); // true
	   
	   boolean result = a > b;
	   System.out.println(result);
	   
	   System.out.println((a * 2) > (b / 5)); // true
	   
	   System.out.println("a가 짝수인가? : " + ((a%2) == 0)); // true
	   
	   // 홀수인지를 구하는 다양한 방법 
	   // 2로 나눴을 때 나머지가 0이 아닌 경우 = 2로 나누어 떨어지지 않는다는 의미 == 홀
	   System.out.println("b가 홀수인가? : " + ((b%2) != 0)); // true
	   System.out.println("b가 홀수인가? : " + !((b%2) == 0)); // true
	   System.out.println("b가 홀수인가? : " + ((b%2) == 1)); // true
	}
	
   public void method2() {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("첫번째 정수 입력 > ");
	   int number1 = sc.nextInt();
	   System.out.print("두번째 정수 입력 > ");
	   int number2 = sc.nextInt();
	   
	   // 첫번째 수가 두번째 수보다 큽니까?
	   System.out.println(number1 > number2);
	   // 첫번째 수가 짝수입니까?
	   System.out.println(number1%2 == 0);
	   
	   System.out.println(number2 > 'A'); // A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
   }

}
