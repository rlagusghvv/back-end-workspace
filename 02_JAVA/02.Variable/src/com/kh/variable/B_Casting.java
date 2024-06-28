package com.kh.variable;

public class B_Casting {

	public static void main(String[] args) {
		B_Casting casting = new B_Casting();
		casting.autoCasting();
		casting.casting();
		
		/*
		 * 형 변환
		 * - 값의 타입을 다른 타입으로 변환하는 것
		 * - boolean을 제외한 7개의 기본형은 서로 형변환이 가능
		 * 
		 */	
		}
	/*
	 * 자동 형 변환 (묵시적 형 변환)
	 * - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다.
	 */
	public void autoCasting() {
		// 정수
		byte b = 10; // 1byte
		short s = b; // 2byte
		int i = s; // 4byte
		long l = i; // 8byte
		
		// 실수
		float f = 1f; // 4byte
		double d = f; // 8byte
		
		d = i; // int(정수) -> double(실수)
	    f = l; // long(8byte, 정수) -> float(4byte, 실수)
	    // => 표현 가능한 수의 범위가 더 크기 때문에 바이크가 더 작아도 형 변환이 이뤄질 수 있음!
	    
	    double result = 12 + 3.3; // 숫자 계산식을 변수에 넣을 수도 있음
	    System.out.println(result);
	    
	    int result2 = b + s; // byte, short 타입의 데이터는 연산시 무조건 int 타입으로 변환
	    System.out.println(result2);
	    
	    long result3 = 30 + 30; // 60을 long 타입으로 형 변환
	    System.out.println(result3);
	    
	    long result4 = 30 + 30L; // int 30과 long 30을 더해서 60을 long 타입으로 형 변환
	    System.out.println(result4);
	}
	
	/*
	 * 강제 형 변환 (명시적 형 변환)
	 * 
	 * (자료형) 값;
	 * 
	 * - 범위가 큰 크기의 자료형의 데이터를 작은 크기의 자료형으로 변환하려고 할 때 사용 
	 * - 강제 형 변환의 경우 데이터의 손실이 발생할 수 있다.
	 * 
	 */
	public void casting() {
		double d = 4.12345678901234567890; // 소수점 15자리까지만 표현 가능! 값이 담아지는 것은 가능
		System.out.println(d); // 4.123456789012345
		
		float f = (float)d; // float은 6자리까지만 표현 / 강제 형변환을 하는 경우 변환되어지는 자료형의 최대 값까지만 값이 담겨
		System.out.println(f); // 4.123457
		
		int i = (int)f; // int가 정수형이기에 소수점 아래 값은 다 사라짐!
		System.out.println(i); // 4
		
		int sum = i + (int)d; // 4 + 4 = 8 
		System.out.println(sum);
		
		int sum2 = (int)(i + d); // (int)(4.0 + 4.123456789012345 = 8.123456789012345)
		System.out.println(sum2);
		
		int number = 129;
		byte bNum = (byte)number; // -127
		System.out.println(bNum);
//		129를 byte로 변환하면 다음과 같은 과정이 발생합니다:
//
//			•	129는 이진수로 0000 0000 0000 0000 0000 0000 1000 0001입니다.
//			•	8비트만 남기면 1000 0001입니다.
//			•	1000 0001은 음수이고, 이를 10진수로 변환하면 -127입니다.
//
//		그래서 int 129를 byte로 변환하면 -127이 됩니다. 이는 숫자의 크기와 부호를 나타내는 방식 때문에 발생하는 현상입니다.
		
		// char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문 
		// 쌍방향으로 형변환 가능
		// * char는 음수값 저장 불가 => 값의 범위가 0~65535이기 때문!
		
		int num = 'A';
		System.out.println(num); // 65
		
		char ch = 97;
		System.out.println(ch); // 'a'
	}
	

}
