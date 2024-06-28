package com.kh.variable;

public class A_Variable {
	/*
	 * 변수(Variable) : 값을 저장하는 "공간"
	 */
	// 실행할 메서드가 있는 클래스를 생성(new)
	public static void main(String [] args) {
		A_Variable variable = new A_Variable();
		
		// 생성한 클래스로 메서드 실행(호출)
		variable.printValue();
	    variable.variableTest();
	    variable.constant();
	}
    public void printValue() {
    	// 원의 둘레와 원의 넓이를 출력하시오.
        // 원의 둘레 = 반지름 X 2 X 3.141592...
    	// 원의 넓이 = 반지름 X 반지름 X 3.141592...
    	
       // 변수를 사용하지 않는 경우
       System.out.println(10 * 2 * 3.141592);
       System.out.println(10 * 10 * 3.141592);
       
       System.out.println("-----------------");
       
       // 변수를 사용하는 경우
       int r = 10;
       double pi = 3.141592;
       
       System.out.println(r * 2 * pi);
       System.out.println(r * r * pi); //syso 입력 후 command + Shift + space -> Enter!
      
    }
    
   public void variableTest() {
	   /*
	    * 변수의 선언
	    * 
	    *  자료형 변수명;
	    *  - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당받을지에 대한 정보
	    *  - 변수명 : 변수의 이름으로 값을 읽고,쓰고, 지우는 작업을 할 때 사용
	    *  
	    *  
	    * * 변수의 초기화
	    * 
	    *   변수명 = 값;
	    *   - 변수에 처음으로 값을 저장하는 것!
	    *   - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자!
	    */
	   
	   // * 기본 자료형(Primitive type) : 실제 값을 저장
	   // 스택 메모리에 생성된 공간에 실제 변수값이 저장
	   // 1. 논리형 : 1byte(8bit)
	   boolean isTrue; // 변수 선언!
	   isTrue = true; // 변수 초기화
	   
	   boolean isFalse = false; // 변수 선언과 함께 초기화!
	   
	   // 2. 문자형 : 2byte(=16bit)
	   char ch = 'A';
//	   ch = 'ab'; 에러 발생! 한글자만 들어갈 수 있음!
//	   ch = "b"; 에러 발생! ''으로 작성되어야함!
	   
	   // 3. 정수형
	   byte bNum = 1; // 1byte(=8bit) (-128 ~ 127까지 총 256의 공간 - 2^8)
//	   byte bnum = 128; 에러 발생! 해당 자료형이 가지고 있는 공간보다 큰 데이터가 기입되었기 때문에! -> 오버플로우(Overflow)
	   short sNum = 128; //2byte(=16bit) 
	   int iNum = 922337283; // 4byte (기본)
	   long lNum = 922337283458l; // 8byte - 숫자 뒤에 L(l)을 입력
	   
	  System.out.println(lNum);
	  
	   // 4. 실수형
	   float fNum = 1.2f; // 4byte - 숫자 뒤에 F(f)를 입력
	   double dNum = 1.2; // 8byte (기본)
			   
	   System.out.println(fNum);
	   
	   // * 참조 자료형 : 4byte, 기본형을 제외한 나머지 (클래스) : 주소 값을 저장
	   // 실제 데이터 값은 힙 메모리에 저장,
	   // 스택 메모리의 변수 공간에는 실제 변수값이 저장된 힙 메모리 내 위치값이 저장됨 
	   String name = "장영태"; // 여러 글자가 올때는 무~조~건 "" 사용해야함!
	   String name2 = new String("장영태");
	   
	   System.out.println(name);
	   System.out.println(name2);
	   
	   // 변수의 네이밍 규칙 
	   // 1. 대소문자 구분한다.
	   int number;
//	   string number; 자료형이 달라도 변수명이 같으면 에러 발생!
	   int NUMBER;
	   int Number;
	   // 세 변수는 대소문자의 차이지만 다른 변수로 인식
	   
	   // 2. 숫자로 시작하면 안 된다.
//	   int 1age; - 에러 발생
	   int a2g3e4; // 가능!
	   
	   // 3. 특수문자는 '_', '$'만 사용 가능!
	   int _age;
	   int age$;
//	   int %age;
//	   int age@; - 다른 특수문자는 에러 발생!
	   
	   // 4. 예약어(Reserved word)를 사용하면 안 된다.
//	   int int;
//	   int public;
//	   int void;
	   int int1;
	   int public2;
	   int void3; // 숫자가 붙으면 예약어가 아니기 때문에 사용 가능!
	   
	   // 5. (권장사항) 낙타표기법(카멜케이스!)
	   // 첫글자는 항상 소문자!, 여러 단어가 오면 대문자로 구분
	   int maxnumber;
	   int max_number; // 자바에서 X, 파이썬에서 O (스네이크 기법)
//	   권장사항! 해당 기법을 꼭 사용하지 않는다고 해서 변수가 생성되지 않거나, 오류가 나지는 않음!
	   int maxNumber; // 자바에서는 이렇게 변수명을 지정하는 것을 권장!
   }
   
   public void constant() {
	   /*
	    * 상수
	    * 
	    * final 자료형 변수명;
	    * 
	    * - 변하지 않는 값으로 특정 변수의 값이 변경되는 것을 원하지 않을 때 사용!
	    * - 초기화 이후에는 값 변경이 불가! (값을 그때 그때 변경할 수 있는 변수와의 차이!)
	    * - 상수의 네이밍 규칙은 모든 글자 대문자로 표기! 여러 단어가 오면 _로 구분
	    */
	   
	   int age = 20;
	   age = 25; // 숫자가 25로 변경된 것을 확인할 수 있음
	   System.out.println(age);
	   
	   final int AGE = 30;
//	   AGE = 40; 에러 발생! 상수는 값이 변경될 수 없음
	   System.out.println(AGE);
   }
}
