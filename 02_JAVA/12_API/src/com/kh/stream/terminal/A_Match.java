package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 매칭
 * - 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사하는 역할
 * - allMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하는지 조사
 * - anyMatch : 최소한 한 개의 요소가 매개 값으로 주어진 조건을 만족하는지 조사
 * - noneMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하지 않는지 조사
 */
public class A_Match {

	public void method1() {
		int[] values = { 2, 4, 6 };
		boolean result = Arrays.stream(values).allMatch(value -> value % 2 == 0);
		System.out.println("짝수만 가지고 있는가? " + result); // true

		boolean result2 = Arrays.stream(values).anyMatch(value -> value % 3 == 0);
		System.out.println("3의 배수가 하나라도 존재하는가?  " + result2); // true

		boolean result3 = Arrays.stream(values).noneMatch(value -> value % 5 == 0);
		System.out.println("모두가 5의 배수가 아닌가? " + result3); // true

	}

	public void method2() {
		List<Student> students = Arrays.asList(new Student("김현호", 20, "남자", 80, 50),
				new Student("우현성", 19, "남자", 75, 60), new Student("김경주", 18, "여자", 50, 100),
				new Student("주준영", 21, "남자", 60, 45), new Student("조창현", 19, "남자", 70, 90),
				new Student("김진주", 22, "여자", 80, 50));
		
		// 나이가 20살 이상인 학생들이 모두 남자인지 확인
	    boolean result = students.stream()
	    		.filter(age -> age.getAge() >= 20)
	    		.allMatch(gender -> gender.getGender().equals("남자"));

		System.out.println("나이가 20살 이상인 학생들이 모두 남자인지? " + result);
		
		// 남학생 중 평균이 70점 이상인 학생이 한 명이라도 존재하는지 확인
	    boolean result2 = students.stream()
	    		.filter(gender -> gender.getGender().equals("남자"))
	    		.anyMatch(avg -> (avg.getMath()+ avg.getEnglish())/2 >= 70);
	    System.out.println("남학생 중 평균이 70점 이상인 학생이 한 명이라도 존재하는지? " + result2);
	}

	public static void main(String[] args) {
		A_Match a = new A_Match();
//		a.method1();
		a.method2();
	}

}
