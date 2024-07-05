package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	public static void main(String[] args) {
    Calculator c = new Calculator();
    
    /*
     * 변수 호출 방법
     * - 참조변수.변수;
     * 
     * 메서드 호출 방법
     * - 참조변수.메서드명() // 매개변수가 없는 경우
     * - 참조변수.메서드명(값1, 값2 ....); // 매개변수가 있는 경우!
     * 
     */
    
    c.a = 3;
    c.b = 98;
    System.out.println("더하기 : " + c.add());
    System.out.println("빼기 : " + c.substract());
    System.out.println("곱하기 : " + c.multiply(100,200)); // 해당 메서드에 매개변수를 받을 수 있도록 세팅한 경우
//    System.out.println("나누기 : " + c.quotient());
//    System.out.println("나머지 : " + c.remainder());
    System.out.println(Calculator.divide(c.b, c.a));
    System.out.println("팩토리얼 : " + Calculator.factorial(3));
    System.out.println("팩토리얼 : " + c.factorial2(4));
    }

}
