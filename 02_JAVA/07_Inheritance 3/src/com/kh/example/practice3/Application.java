package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee viewEmployee = new Employee();
		EmployeeController employeeController = new EmployeeController();
		
		while(true) {
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		int num = sc.nextInt();
		
		switch (num) {
		case 1:
			System.out.print("사원 번호 : ");
			int empNo = sc.nextInt();
			System.out.print("사원 이름 : ");
			String name = sc.next();
			System.out.print("사원 성별 : ");
		    char gender = sc.next().charAt(0);
		    System.out.print("전화 번호 : ");
			String phone = sc.next();
			employeeController.add(empNo, name, gender, phone);
			System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
			char yn = sc.next().charAt(0);
			if (yn == 'y') {
				System.out.print("사원 부서 : ");
				String dept = sc.next();
				System.out.print("사원 연봉 : ");
				int salary = sc.nextInt();
				System.out.print("보너스 율 : ");
			    double bonus = sc.nextDouble();
		    employeeController.add(empNo, name, gender, phone, dept, salary, bonus);}
		    break;
		   
		 
		case 2:
			System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			System.out.println("1. 전화 번호");
			System.out.println("2. 사원 연봉");
			System.out.println("3. 보너스 율");
			System.out.println("9. 돌아가기");
			System.out.print("메뉴 번호를 누르세요 : ");
			int num1 = sc.nextInt();
			 switch (num1) {
			 case 1: 
				 System.out.print("전화 번호 입력 : ");
				 phone = sc.next();
				 employeeController.modify(phone);
				 break;
			 case 2:
				 System.out.print("사원 연봉 입력 : ");
				 int salary = sc.nextInt();
				 employeeController.modify(salary);
				 break;
			 case 3:	 
				 System.out.print("보너스 율 입력 : ");
				 double bonus = sc.nextInt();
				 employeeController.modify(bonus);
				 break;
			 case 9:
				 break;
			 }
			 break;
			 
		case 3:
			System.out.println(employeeController.info());
			break;
		
		case 9:
			return;
			}
		
				
			
		}
	}

	public int employeeMenu() {

		return 0;
	}

	public void insertEmp() {
	}

	public void updateEmp() {
	}

	public void printEmp() {
	}
}
