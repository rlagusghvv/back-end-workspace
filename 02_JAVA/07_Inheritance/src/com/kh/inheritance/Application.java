package com.kh.inheritance;

import com.kh.inheritance.child.Notebook;
import com.kh.inheritance.child.SmartPhone;

public class Application {

	public static void main(String[] args) {
		
		Notebook b = new Notebook();
		Notebook notebook = new Notebook("애플", "app-01", "맥북 프로 16", 3400000, "M3");
		SmartPhone smartphone = new SmartPhone("애플", "iphone-1", "아이폰 15 프로", 3500000, "SKT");
		
		smartphone.setAgency("LGU");
		smartphone.setBrand("삼성");
	    smartphone.setpCode("samsung-02");
	    
		System.out.println(notebook);
		System.out.println(smartphone);

	}

}
