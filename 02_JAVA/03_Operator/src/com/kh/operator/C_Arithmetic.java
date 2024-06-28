package com.kh.operator;

public class C_Arithmetic {
	// 코드 정렬 깔끔하게 하고 싶다면!
	// 해당 영역 잡고! command + shift + f!
	/*
	 * 산술 연산자 + : 더하기 - : 빼기 * : 곱하기 / : 나누기 % : 나머지
	 */
	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
//    c.method1();
		c.method2();

	}

	public void method1() {
		int num1 = 10;
		int num2 = 3;

		System.out.println(" + : " + (num1 + num2)); // 13
		System.out.println(" - : " + (num1 - num2)); // 7
		System.out.println(" * : " + (num1 * num2)); // 30
		System.out.println(" / : " + (num1 / num2)); // 3
		System.out.println(" % : " + (num1 % num2)); // 1
	}

	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b; // 16 // a = 6
		int d = c / a; // 2
		int e = c % a; // 4
		int f = e++; // 4 // e = 5
		int g = (--b) + (d--); // 11 // b = 9, d = 1
		int h = c-- * b; // 144 // c = 15
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		// 6 + 9 / (14/4) * (11-1) % (6 + 144)
	} // 6 + 3 * 10 % 150
		// 6 + 30 % 150
		// 6 + 30 = 36
}
