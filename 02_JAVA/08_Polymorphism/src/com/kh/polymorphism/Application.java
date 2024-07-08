package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;

/*
 * 다형성(Polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 생성하는 것
 * 
 */
public class Application {
   
    
	public static void main(String[] args) {

		EmployeeController ec = new EmployeeController();
	    Scanner sc = new Scanner(System.in);
	    
		Employee e1 = new Employee("우현성", 10000);
		Engineer e2 = new Engineer("이동엽", 9000, "자바", 200);
		Manager m1 = new Manager("윤유진", 7000, "총무부");
		Secretary s1 = new Secretary("송준호", 6000, "우현성");

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(m1);
		System.out.println(s1);

		Employee e3 = new Engineer("이동엽", 9000, "자바", 200);
		Employee m2 = new Manager("윤유진", 7000, "총무부");
		Employee s2 = new Secretary("송준호", 6000, "우현성");
		
		// 다형성 + 객체 배열
		Employee[] empArr = {e1, e3, m2, s2};	
		
	    for(Employee employee : empArr) {
	    	System.out.println(employee);
	    }
		
		
		System.out.println(e3);
		System.out.println(m2);
		System.out.println(s2);

		// 이름으로 사람 찾기
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
	    System.out.println(ec.findEmployeeByName(name, empArr));
	    
	    // 찾은 사람의 연봉은?
	    System.out.println(ec.getAnnualSalary(ec.findEmployeeByName(name, empArr)));
	    
	    // 전체 총합
	    System.out.println(ec.getTotalSalary(empArr));
	    
   
	}
	
	
}