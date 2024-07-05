package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {

		Member m = new Member("damas1110", "rlagusgh0329", "김현호", 28, 'M', "010-2472-2652", "damas1110@naver.com");
		
		System.out.println(m);
		
		m.changeName("김현우");
		
		m.printName();
	}

}
