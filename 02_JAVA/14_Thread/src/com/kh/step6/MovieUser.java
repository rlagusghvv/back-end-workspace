package com.kh.step6;

// 영화관에서 좌석을 예매하는 일을 전담하는 쓰레드라고 간주
public class MovieUser implements Runnable {
	
	private boolean seat = false; // 좌석 예매가 끝나면 true
	

	public synchronized void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "님, 예매하러 오셨습니다..!!");
		
		if(seat == false) {
			System.out.println(name + "님, 좌석 예매 성공하셨습니다.");
			seat = true;
		} else {
			System.out.println(name + "님, 해당 죄석은 이미 예매 완료된 좌석입니다.");
		}
	}
}
