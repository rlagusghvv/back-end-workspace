package com.kh.operator;

import java.util.Scanner;

public class G_Compound {
	Scanner sc = new Scanner(System.in);

	/*
	 * 복합 대입 연산자 - 산술연산자와 대입연산자를 결합한 형태 - 연산처리 속도가 빨라짐
	 * 
	 * +=, -=, *=, /=, %=
	 * 
	 * a += 3; : a = a + 3; a -= 3; : a = a - 3; a *= 3; : a = a * 3; a /= 3; : a =
	 * a / 3; a %= 3; : a = a % 3;
	 * 
	 * ++a; or a++; => a = a + 1; => a += 1; --a; or a--; => a = a - 1; => a -= 1;
	 */

	public static void main(String[] args) {
		G_Compound g = new G_Compound();

		int number = 12;

		number += 3;
		System.out.println(number); // 15

		number -= 5;
		System.out.println(number); // 10

		number *= 6;
		System.out.println(number); // 60

		number /= 3;
		System.out.println(number); // 20

		number %= 3;
		System.out.println(number); // 2

		String str = "Hello";
		str += ", Java!";
		System.out.println(str); // Hello, Java!

	}
    // 항 개수에 따라서 연산자의 우선순위가 달라짐
	// 항 개수가 많을 수록 연산자 우선순위 low!
}
