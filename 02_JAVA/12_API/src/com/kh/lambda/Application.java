package com.kh.lambda;

/*
 * 람다식(Lambda Expressions) => 자바스크립트의 화살표 함수!
 * - 자바에서 함수적 프로그래밍을 위해 자바 8부터 람다식을 지원
 * - 람다식은 매개변수를 가지는 함수와 같은 코드 블록이지만, 런타임 시에는 인터페이스의 익명 구현 객체를 생성한다.
 * - 람다식을 사용하면, 코드가 간결해지고, 컬렉션 요소들을 필터링하거나 매핑해 원하는 결과를 쉽게 가져올 수 있다.
 */
public class Application {

	public static void main(String[] args) {
		Application a = new Application();
		int a1 = 10;
		int b = 3;
		
		System.out.println(a.plus(a1, b));
		System.out.println(a.minus(a1, b));
		System.out.println(a.multiple(a1, b));
		System.out.println(a.divide(a1, b));
		
		System.out.println();
		
		// 람다식으로 바꾸기!
		Mathinterface plusLambda = (int x, int y) -> {
			return x + y;
		};
		
		Mathinterface minusLambda = (int x, int y) -> x - y;
		Mathinterface multipleLambda = (int x, int y) -> x * y;
		Mathinterface divideLambda = (int x, int y) -> x / y;
		
	    System.out.println(plusLambda.calc(a1, b));
	    System.out.println(minusLambda.calc(a1, b));
	    System.out.println(multipleLambda.calc(a1, b));
	    System.out.println(divideLambda.calc(a1, b));
 
	}
	
	public int plus(int a, int b) {
		return a + b;
	}
	
	public int minus(int a, int b) {
		return a - b;
	}
	
	public int multiple(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a / b;
	}

}
