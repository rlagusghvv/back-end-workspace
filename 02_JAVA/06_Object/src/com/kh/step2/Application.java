package com.kh.step2;

import com.kh.step2.model.Card;

public class Application {

	public static void main(String[] args) {
		
		// 클래스 변수는 객체 생성 없이 호출 가능!
		System.out.println(Card.width);
		System.out.println(Card.height);
		Card c = new Card();
		
	    c.kind = "Heart";
	    c.number = 7;
	    
	    Card c2 = new Card();
	    c2.kind = "Spade";
	    c2.number = 3;
	    
	    // 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다!
	    Card.width = 50;
	    c2.height = 90;
	    
	    System.out.println("첫번째 카드는 " + c.kind + " " + c.number + "이며, " + "크기는 " + Card.width + " X " + Card.height + "입니다!");
	    System.out.println("두번째 카드는 " + c2.kind + " " + c2.number + "이며, " + "크기는 " + Card.width + " X " + Card.height + "입니다!");
	}

}
