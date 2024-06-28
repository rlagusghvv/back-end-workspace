package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {

		// System.out.print(출력하고자 하는 값); -- 출력만! ln이 붙지 않으면 줄바꿈 없음!
		System.out.print("Hello");
		System.out.print("Hello\n"); // \n을 내부에 넣으면 ln이 붙은 것과 동일한 효과 
		// System.out.println(출력하고자 하는 값); -- 출력 후 줄바꿈 발생 O
		System.out.println("Hello");
		
		System.out.println("------------------------------------");
		
//		System.out.printf("출력하고자하는 형식(포맷)", 출력하고자 하는 값, 값, 값 ....);
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%
		System.out.print(iNum1 + "%" + " " + iNum2 + "%" + "\n");
		
		/*
		 * 포맷에 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능!)
		 * 
		 */
		
        System.out.printf("%d%% %d%% \n", iNum1, iNum2); // %가 포맷에 쓰이는 키워드이기 때문에 %를 붙여서 %가 문자로 쓰임을 알려줘야함.
	    
        System.out.println("------------------------------------");
        
        System.out.printf("%5d\n", iNum1); // 5칸 공간 확보 후 양수 오른쪽 정렬!
        System.out.printf("%-20d", iNum2); // 20칸 공간 확보 후 음수 왼쪽 정렬!
        System.out.printf("%d\n", iNum2);
        
        System.out.println("-------------------------------------");
        
        double dNum1 = 1.23456789;
        double dNum2 = 4.53;
        
        System.out.printf("%f\t%f\n", dNum1, dNum2); // %f는 무조건 소수점 6자리까지 출력! (이상인 경우 잘리고, 이하인 경우에는 0으로 채워짐)
        
        System.out.printf("%.3f\t%.2f\n", dNum1, dNum2); // %와 f사이에 .숫자를 넣으면 원하는 만큼의 소수점자리까지 표기 가능!
	    
        System.out.println("-------------------------------------");
        
        char ch = 'a';
        String str = "Hello";
        
        // a       Hello a
        System.out.printf("%s\t%s %s\n", ch, str, ch); // %s는 단일 문자도 포함함!
        System.out.printf("%C %S", ch, str); // 포맷 내 키워드를 대문자로 입력하면 대문자로 출력!
       
	}

}
