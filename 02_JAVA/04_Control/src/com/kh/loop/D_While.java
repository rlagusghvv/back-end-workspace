package com.kh.loop;

import java.util.Scanner;

public class D_While {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
	}

	/*
	 * While문
	 * 
	 * while(조건식) { 조건이 true인 경우 계속 실행 }
	 */
	// 1 ~ 5까지 출력 : for -> while
	// 숫자나 인덱스, 배열 등은 for문 사용을 추천

	public void method1() {
		int result = 1;
		while (result <= 5) {
			System.out.println(result);
			result++;
		}
	}

	/*
	 * 무한루프 & break 문 - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용! - 반복문이 중첩되어 있는 경우 break문이
	 * 포함되어 있는! 반복문에서만 빠져나간다.
	 */
	public void method2() {
		while (true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			if (num == 0) {
				break;
			}

		}

//	   for(;;) {}   
	}

	/*
	 * do { 실행 코드 } while (조건식);
	 * 
	 * - 조건과 상관없이 무조건 한 번은 실행! - 거의 쓸일은 없음..
	 */

	public void method3() {
		int number = 1;

		while (number == 0) {
			System.out.println("while");
		}
		do {
			System.out.println("do-while");
		} while (number == 0); // 실행문이 조건보다 앞에 있기 때문에 최소 한번 이상은 실행이 됨!
	}
	/*
	 * 숫자 맞히기 게임 1과 100사이의 값을 입력해서 임의로 지정한 (Random)값을 맞히면 게임 끝! 게임이 끝나면 몇 번 만에 맞혔는지
	 * 출력
	 * 
	 * (예 : 57) 1과 100 사이의 값 입력 > 35 더 큰 수를 입력하세요. 1과 100 사이의 값 입력 > 70 더 작은 수를
	 * 입력하세요. 1과 100 사이의 값 입력 > 57 3번 만에 맞혔습니다.
	 */

	public void method4() {
		int num = (int) (Math.random() * 100 + 1);
		int input = 0;
		int inputnum = 0;
		while (true) {
			System.out.print("숫자를 맞춰보세요. ");
			input = sc.nextInt();
			inputnum++;
			if (input < num) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (input > num) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("정답입니다! " + inputnum + "번만에 맞추셨습니다!");
				break;
			}
		}
	}

	/*
	 * --------------------------------- 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------- 선택 > 1 예금액 > 5000
	 * --------------------------------- 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------- 선택 > 2 출금액 > 2000
	 * --------------------------------- 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------- 선택 > 3 잔고 > 3000
	 * --------------------------------- 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------- 선택 > 4 종료되었습니다.
	 */
	public void method5() {
		int input = 0;
		int output = 0;
		int account = 0;
		while (account >= 0) {
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.println("메뉴를 선택해주세요.");
			int select = sc.nextInt();
			// switch로도 가능함! - 다만, break의 문제?
//			switch (select) {
//			case 1:
//				System.out.println("예금 메뉴를 선택했습니다. 예금액을 입력해주세요");
//				input = sc.nextInt();
//				account = account + input;
//				System.out.println("잔고는 " + account + "원 입니다.");
//				break;
//			case 2:
//				System.out.println("출금 메뉴를 선택했습니다. 출금액을 입력해주세요");
//				System.out.println("잔고는 " + account + "원 입니다.");
//				output = sc.nextInt();
//				account = account - output;
//				System.out.println("잔고는 " + account + "원 입니다.");
//				break;
//			case 3:
//				System.out.println("잔고 메뉴를 선택했습니다.");
//				System.out.println("잔고는 " + account + "원 입니다.");
//				break;
//			case 4:
//				System.out.println("종료 메뉴를 선택했습니다.");
//				System.out.println("프로그램이 종료됩니다.");
//				break;
//			default:
//				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
//			}
//			if(select == 4) break; or while문의 조건을 select != 4로 바꿔주기 
//			or boolean 변수 생성해주고, 4번 선택시 해당 변수 값 false로 변경!

			if (select == 1) {
				System.out.println("예금 메뉴를 선택했습니다. 예금액을 입력해주세요");
				input = sc.nextInt();
				account = account + input;
				System.out.println("잔고는 " + account + "원 입니다.");
			} else if (select == 2) {
				System.out.println("출금 메뉴를 선택했습니다. 출금액을 입력해주세요");
				System.out.println("잔고는 " + account + "원 입니다.");
				output = sc.nextInt();
				account = account - output;
				System.out.println("잔고는 " + account + "원 입니다.");
			} else if (select == 3) {
				System.out.println("잔고 메뉴를 선택했습니다.");
				System.out.println("잔고는 " + account + "원 입니다.");
			} else if (select == 4) {
				System.out.println("종료 메뉴를 선택했습니다.");
				System.out.println("프로그램이 종료됩니다.");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			System.out.println("잔액이 없습니다. 오류입니다.");
		}

	}
}
