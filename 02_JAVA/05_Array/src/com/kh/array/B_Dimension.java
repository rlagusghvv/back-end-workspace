package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class B_Dimension {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		B_Dimension b = new B_Dimension();
//		b.method1();
		b.method2();
	}
	/*
	 * 다차원 배열 : '[]'의 개수가 차원의 수를 의미
	 * 
	 * 1. 2차원 배열의 선언 자료형[][] 배열명; 자료형 배열명[][]; 자료형[] 배열명[];
	 * 
	 * * 2차원 배열의 생성 배열명 = new 자료형[(행)크기][(열)크기];
	 * 
	 * * 2차원 배열의 선언과 초기화를 동시에 진행 자료형[][] 배열명 = new 자료형[(행)크기][(열)크기];
	 * 
	 * 배열명[0][0] = 값; 배열명[0][1] = 값; ...
	 */

	// 선언과 동시에 초기화
	public void method1() {
		int[][] array = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		System.out.println(Arrays.toString(array[0]));
		System.out.println(Arrays.toString(array[1]));
		System.out.println(Arrays.toString(array[2]));
		System.out.println("-------------------------------");
		// 반복문 사용
		for (int i = 0; i < array.length; i++)
		{ System.out.println(Arrays.toString(array[i]));}
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]); // 주소가 다 다르다?
		
		// 반복문을 통해 전체 다 꺼내기!
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.println(array[i][j]);
			}
		}
			// 향상된 for문
			for(int[] i : array) {
				for(int j : i) {
					System.out.println(j);
				}
			}
			for (int[] i : array) {
				System.out.println(i);
			}
		}
	
	// 가변 배열 : 다타원 배열에서 마지막 차수의 크기를 지정하지 않고 다르게 지정
	/*
	 * [1,2,3]
	 * [1,2,3,4,5]
	 * [1,2,3]
	 * [1,2]
	 */
    public void method2() {
    	int[][] array = {{1,2,3},{1,2,3,4,5},{1,2,3},{1,2}};
    	
    	for (int i = 0; i < array.length; i++) {
    	System.out.println(Arrays.toString(array[i]));}
    }
}
