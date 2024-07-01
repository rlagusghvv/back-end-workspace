package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);

	/*
	 * If문
	 * 
	 * if(조건식) { 조건식이 참(true)일 때 실행 // 중괄호는 생략도 가능!! - 실행문이 한줄일때 사용 가능! }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용!
	 */
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다."를 출력
		System.out.println("성적을 입력해주세요.");
		int score = sc.nextInt();
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}

	/*
	 * if-else문
	 * 
	 * if(조건식) { 조건식이 참(true)일 때 실행 } else { 조건식이 거짓(false)일 떄 실행 }
	 */

	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다", 아니면 "불합격입니다."를 출력
		System.out.println("성적을 입력해주세요.");
		int score = sc.nextInt();
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}

		// 삼항연산자
		System.out.println(score >= 60 ? "합격입니다." : "불합격입니다.");
	}

	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("name의 주소값 : " + System.identityHashCode(name));
		System.out.println("김현호의 주소값 : " + System.identityHashCode("김현호"));

		if (name.equals("김현호")) { // name.equals 스트링 클래스에서 제공하는 기능! 주소값이 아닌 실제 문자열을 직접 비교!
			System.out.println("본인입니다.");
		} else {
			System.out.println("본인이 아닙니다.");
		}
	}

	/*
	 * if - else if - else문
	 * 
	 * if (조건식1) { 조건식 1이 참(true)일 떄 실행 } else if (조건식2) { 조건식1이 거짓(false)이면서 조건식2이
	 * 참(true)일 때 실행 } else { 조건식1, 조건식2 모두 거짓(false)일 때 실행 }
	 * 
	 * - else if는 수가 제한이 없음!
	 */
	public void method4() {
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력!
		System.out.println("숫자를 입력하시오");
		int num = sc.nextInt();

		// if문 // if문 중첩도 가능! but 가급적 사용 X 좋은 코드는 아님!
		if (num > 0) {
			System.out.println("양수");
		} else if (num == 0) {
			System.out.println("0이요");
		} else {
			System.out.println("음수");
		}
		// 삼항연산자
		String result = num > 0 ? "양수" : num == 0 ? "0이다." : "음수";
		System.out.println(result);
	}

	public void practice1() {
		/*
		 * 사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력 - 90점 이상은 A등급 - 90점 미만 80점 이상은 B등급 - 80점 미만
		 * 70점 이상은 C등급 - 70점 미만 60점 이상은 D등급 - 60점 미만 F등급
		 */
		System.out.println("본인의 점수를 입력해주세요.");
		int score = sc.nextInt();
		char grade = ' ';
		if (score < 60) {
			grade = 'F';
		} else if (score < 70) {
			grade = 'D';
		} else if (score < 80) {
			grade = 'C';
		} else if (score < 90) {
			grade = 'B';
		} else {
			grade = 'A';
		}
		System.out.println("입력하신 점수에 따른 등급은 " + grade + "등급 입니다.");

	}

	public void practice2() {
		/*
		 * 세 정수를 입력했을 때 짝수만 출력
		 * 
		 * num1 입력 : 3 num2 입력 : 4 num2 입력 : 6
		 * 
		 * 4 6
		 * 
		 */
		System.out.println("정수 3개를 입력해주세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println("---------------------------");
		if (num1 % 2 == 0) {
			System.out.println(num1);
		}
		if (num2 % 2 == 0) {
			System.out.println(num2);
		}
		if (num3 % 2 == 0) {
			System.out.println(num3);
		}

//		if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) {
//			System.out.println(num1);
//			System.out.println(num2);
//			System.out.println(num3);
//		} else if (num1 % 2 == 0 && num2 % 2 == 0) {
//			System.out.println(num1);
//			System.out.println(num2);
//		} else if (num2 % 2 == 0 && num3 % 2 == 0) {
//			System.out.println(num2);
//			System.out.println(num3);
//		} else if (num1 % 2 == 0 && num3 % 2 == 0) {
//			System.out.println(num1);
//			System.out.println(num3);
//		} else if (num3 % 2 == 0) {
//			System.out.println(num3);
//		} else if (num1 % 2 == 0) {
//			System.out.println(num1);
//		} else if (num2 % 2 == 0) {
//			System.out.println(num2);
//		}
	}
	
	public void practice3() {
		/*
		 * 정수 1개를 입력했을 때 음(minus)/양(plus)/0(zero)와 짝(even)/홀(odd) 출
		 * 
		 * 정수 입력 : -3
		 * minus
		 * odd
		 */
		
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();
		if (num > 0) {
			System.out.println("plus");
		} else if (num < 0) {
			System.out.println("minus");
		} else {
			System.out.println("zero");
		}
		
		if (num == 0) {
			System.out.println("zero");
		} else if (num % 2 == 0){
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
			
	}

	public static void main(String[] args) {
		A_If a = new A_If();
//        a.method1();
//          a.method2();
//		a.method3();
//		a.method4();
//		a.practice1();
//		a.practice2();
		a.practice3();
	}

}
