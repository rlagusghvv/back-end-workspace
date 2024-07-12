package com.kh.stream.intermediate;

import java.util.Arrays;

/*
 * 반복 
 * - 요소 전체를 반복하는 역할
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 */
public class D_Looping {

	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5};
		
		// 1 ~ 5 중 짝수의 합계
		// peek
	    int reslut = Arrays.stream(values).filter(value -> value % 2 == 0).peek(value -> System.out.println(value)).sum();
	    System.out.println(reslut);
	    
	    // forEach
	    Arrays.stream(values).filter(value -> value % 2 == 0).forEach(value -> System.out.println(value));
	    int reslut2 = Arrays.stream(values).filter(value -> value % 2 == 0).sum();
	    System.out.println(reslut2);

	}

}
