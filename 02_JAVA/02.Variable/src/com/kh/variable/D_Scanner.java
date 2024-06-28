package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	
	/*
	 * Scanner
	 * - 화면(Console)으로부터 데이터를 "입력" 받는 클래스 
	 * 
	 * 1. import java.util.Scanner; 추가 
	 * 
	 * 2. Scanner 객체 생성 
	 *    Scanner 변수명 = new Scanner(System.in);
	 *    
	 * 3. Scanner 메서드 사용 
	 *    입력값이
	 *    - 문자열일 때 : sc.next() - 공백이 있는 경우 공백 이전까지
	 *                  sc.nextLine() - 공백 포함 엔터 전까지 
	 *    - 정수일 때 : sc.netInt() 
	 *    - 실수일 때 : sc.nextFloat(), sc.nextDouble()
	 *    
	 *    => 권장사항! sc.netLine()만 사용! WHY? 얘만 enter 처리!
	 */
	
	public static void main(String[] args) {
    
	Scanner sc = new Scanner(System.in); // 해당 객체 생성 문을 먼저 작성하고 Scanner를 클릭하면 자동 import 가능!
	
    System.out.print("당신의 이름은 무엇입니까? > ");
    
    String name = sc.nextLine(); // enter 처리 X
    
    System.out.print("당신의 나이는요? > ");
    
//    int age = sc.nextInt(); // enter 처리 X
//    sc.nextLine();
    
    int age = Integer.parseInt(sc.nextLine());
    // Integer.parseInt(int로 바꾸고 싶은 값) 으로 받으면 nextLine을 int, 정수형으로 사용 가능!
   
    
    System.out.print("당신의 집은 어디입니까? > ");
    
    String home = sc.nextLine(); 
    
    System.out.print("당신의 키는요? > (소수점 첫째 자리까지 입력하세요.)");
//    double height = sc.nextDouble(); // enter 처리 X
//    sc.nextLine();
    double height = Double.parseDouble(sc.nextLine());
    
    System.out.print("당신의 성별은 뭔가요? > (남/여)");
//    char gender = sc.nextLine().charAt(0); // 앞서 처리되지 않은 enter 처리가 되면서 입력받을 수 없게됨.
    // charAt () 내 숫자만큼의 순번의 글자를 1개 가지고옴! () 내 숫자는 index!
    String input = sc.nextLine();
    char gender = input.charAt(0);
    
    System.out.println("내 이름은 " + name + "입니다." + "우리집은 " + home + "에요." + "나이는 " + age + "살 이구요" + " 키는 " + height + "요 " + gender);
	
	System.out.printf("내 이름은 %s입니다. 우리집은 %s에요. 나이는 %d살 이구요 키는 %f요 %c", name, home, age, height, gender);
	}
}
