package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	public static void main(String[] args) {
    VariablePractice variable = new VariablePractice();
    variable.method1();
    variable.method2();
    variable.method3();
    variable.method4();
    variable.method5();
    variable.method6();
    variable.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int adult = 10000;
		int student = 7000;
		
		System.out.println(adult * 2 + student * 3 + "원");
		System.out.println("------------------------------------------");
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		int xy = y;
		int yz = z;
		int zx = x;
		
		System.out.println("x = " + xy + "\ny = " + yz + "\nz = " + zx);
		System.out.println("------------------------------------------");
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
    int int1 = 23;
    int int2 = 7;
    
    System.out.println("더하기 : " + (int1+int2) + "\n빼기 : " + (int1-int2) + "\n곱하기 : "
    		+ (int1*int2) + "\n나누기 몫 : " + (int1/int2));
    System.out.println("------------------------------------------");
	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 :");
	  double g = sc.nextDouble();
	  System.out.print("세로 :");
	  double s = sc.nextDouble();
	  sc.nextLine();
	  
	  System.out.println("가로 : " + g + "\n세로 : " + s + "\n면적 : " + (g*s) + "\n둘레 : " + ((g+s)*2));
	  System.out.println("------------------------------------------");
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		System.out.println("첫번째 문자 : " + str.charAt(0) + "\n두번째 문자 : " + str.charAt(1) + "\n마지막 문자 : " + str.charAt(str.length()-1)  );
		System.out.println("------------------------------------------");
		
		
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
	    char char1 = sc.next().charAt(0);
	    char char2 = (char)(char1 + 1);
	    int int1 = char1;
	    System.out.println(char1 + " unicode : " + int1 + "\n" + char2 + " unicode : " + (int1 + 1));
	    System.out.println("------------------------------------------");
	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 성적을 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		int math = sc.nextInt();
		double avg = (double)(kor + eng + math) / 3;
		System.out.print("국어 : " + kor + "\n영어 : " + eng + "\n수학 : " + math + "\n총점 : " + (kor+eng+math));
		System.out.printf("\n평균 : %.2f\n", avg);
		// printf 안쓰고 소수점 2자리까지로 잘라내는 방법은 없나요??
		System.out.println("------------------------------------------");
	}

}
