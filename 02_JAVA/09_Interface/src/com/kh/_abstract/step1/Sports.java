package com.kh._abstract.step1;

public abstract class Sports {

	protected int numberOfPlayes; // 참여자 수  

	public Sports(int numberOfPlayes) {
		this.numberOfPlayes = numberOfPlayes;
	}
	
	// 추상메서드 -> 자식 클래스에서 무조건 재정의 해주어야 한다!
	public abstract void rule();
	
	
	
}
