package com.kh.loop;

import java.util.Scanner;

public class C_For {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
//		c.method12();
		c.method13();
	}

	/*
	 * for문
	 * 
	 * for(초기식; 조건식; 증감식;) { 실행 코드 }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문 - 초기식 : 반복문이 수행될 때 단 한 한번만 실행, 반복문 안에서 사용할 변수를 선언하고
	 * 초기값 대입 - 조건식 : 결과가 true이면 실행 코드를 실행, false이면 실행하지 않고 반복문을 빠져나감 - 증감식 : 반복문에서
	 * 사용하는 변수의 값을 증감, 주로 증감 연산자를 사용
	 * 
	 */

	// 1 ~ 5 출력
	public void method1() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	// 5 ~ 1 출력
	public void method2() {

		System.out.println("---------------------------");
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}

	public void method3() {

		System.out.println("---------------------------");
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		/*
		 * continue문 - continue문은 반복문 안에서 사용 - continue를 만나면 "현재 구문" 종료 - 반복문을 빠져나가는 건
		 * 아님! 다음 반복을 계속 수행!
		 */
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}

	public void method4() {
		// 1~10까지의 합계
		int result = 0;
		for (int i = 1; i <= 10; i++) {
			result = result + i; // result += i;
		}
		System.out.println(result);
	}

	public void method5() {
		System.out.println("마지막 수를 지정해주세요.");
		int num = sc.nextInt();
		int result = 0;
		for (int i = 1; i <= num; i++) {
			result += i;
		}
		System.out.println(result);
	}

	// 1부터 랜덤값까지의 합계
	public void method6() {
		/*
		 * java.lang.Math 클래스에서 제공하는 random() 메서드 사용 호출할 때 마다 매번 다른 랜덤값을 얻어낼 수 있음!!!
		 */

		double random = Math.random(); // 0.0 <= random < 1.0
		random = Math.random() * 10; // 0.0 <= random < 10.0
		random = Math.random() * 10 + 1;// 1.0 <= random < 11.0
		System.out.println((int) random);

		int num = (int) random; // 1 ~ 10까지의 랜덤값
		int result = 0;
		for (int i = 1; i <= num; i++) {
			result += i;
		}
		System.out.println(result);
	}

	public void method7() {
		/*
		 * 사용자에게 입력받은 문자열을 세로로 출력 사용자 입력 : Hello H e l l o
		 */
		System.out.println("문자열을 입력해주세요.");
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

		/*
		 * 향상된 for문 for(데이터타입 변수 : 배열) { 변수 : 배열의 값을 하나씩 가지고 옴! }
		 * 
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열 - String.charAt(int index) : 인덱스에 있는
		 * 문자를 char 형식으로 반환 - String.toCharArray() : 모든 문자들이 들어 있는 char[] 형식의 데이터 반환
		 */
		System.out.println("---------------------------");
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			System.out.println(ch);
		}

	}

	public void method8() {
		/*
		 * 구구단 - 2단 출력
		 */
		for (int i = 1; i < 10; i++) {
			System.out.println(i * 2);
		}

	}

	// 중첩 for문
	// 2 ~ 9단 출력
	public void method9() {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "X" + j + "=" + (i * j));
			}
			System.out.println((i) + "단 ---------------");
		}

	}

	/*
	 * ***** 
	 * ***** 
	 * ***** 
	 * *****
	 */
	public void method10() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
    /*
     * 1****
     * *2***
     * **3**
     * ***4*
     * ****5
     */
	public void method11() {
		String result = "";
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				
				if (i == j) 
				{ System.out.print(i);}
				else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
		
	}
	/*
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 * ******
	 */
	public void method12() {
//		for (int i = 1; i <= 6; i++) {
//			for (int j = 1; j <= 6; j++) {
//				System.out.print('*');
//				if (i == j) {
//					break;
//				}
//			}
//			System.out.println();
//		}
//	}
		for(int i = 0; i < 6; i++) {
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
}
	/*     *
	 *    **
	 *   ***
	 *  ****
	 * *****
	 */
	public void method13() {
		for(int i = 0; i < 5; i++) {
		for (int j= 4; j >= 0; j--) {
			if (i < j) {
				System.out.print(" ");;
			} else {
				System.out.print("*");
			}
		}
		System.out.println();
	}
		
	}
}
