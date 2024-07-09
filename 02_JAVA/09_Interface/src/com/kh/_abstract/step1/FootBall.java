package com.kh._abstract.step1;

public class FootBall extends Sports {

	public FootBall(int numberOfPlayes) {
		super(numberOfPlayes);
		
	}

	@Override
	public void rule() {
		System.out.println("FootBall의 선수 수는" + this.numberOfPlayes + "명, 손이 아닌 발로 공을 차야 한다.");
	}

}
