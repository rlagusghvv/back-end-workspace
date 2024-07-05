package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();

	}

	/*
	 * 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오. 사용자 입력 : 5 5 4 3 2 1
	 */
	public void method1() {
		System.out.print("숫자를 입력하세요 (1 ~ 100) : ");
		int num = sc.nextInt();

		for (int i = num; i >= 1; i--) {
			System.out.println(i);
		}

	}

	// 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
	public void method2() {
		int result = 0;
		int count = 0;
		int num = 1;

		while (true) {
			if (num % 2 == 0) {
				result -= num;
			} else {
				result += num;
			}
			num++;
			count++;
			if (result == 100) {
				break;
			}
		}
		System.out.println(count);
	}

	/*
	 * 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요.
	 * 
	 * 문자열 : banana 문자 : a banana 안에 포함된 a 개수 : 3
	 * 
	 */
	public void method3() {
		
		System.out.print("문자열을 입력하세요 : ");
		String text = sc.next();
		System.out.print("문자 입력하세요 : ");
  	    char text1 = sc.next().charAt(0);
		int a = 0;
		
		// 향상된 for문!
//		for(char[] s : text.toCharArray()) {
//			if(ch == s) count++
//		}
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == text1) {
				a++;
			}
		}
        System.out.println(text + "안에 포함된 " + text1 + "의 개수는 : " + a);
	}

	/*
	 * 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10) 7 3 4 2 3 4 0
	 */
	public void method4() {
		while (true) {
			int num = (int) (Math.random() * 11);
			System.out.println(num);
			if (num == 0) {
				break;
			}
		}
	}

	/*
	 * 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)
	 * 
	 * 1 : 3 2 : 2 3 : 1 4 : 0 5 : 4 6 : 0
	 * 
	 */
	public void method5() {
		
		
		// 이거 복습해봐 배열쓰는법! 
//		int [] dice = new int[6];
//		for (int i = 0; i < 10; i++) {
//			int random = (int) (Math.random()*6);
//			dice[random]++;
//		}
//		
//		for(int i = 0; i < dice.length; i++) {
//			System.out.println((i+1) + " : " + dice[i]);
//		}
		
		int num = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		
		for(int i = 1; i <= 10; i++) {
        num = (int)(Math.random()*6+1);
        switch(num) {
        case 1:
        	num1++;
        break;
        case 2:
        	num2++;
        break;
        case 3:
        	num3++;
        break;
        case 4:
        	num4++;
        break;
        case 5:
        	num5++;
        break;
        case 6:
        	num6++;
        break;
        }
             
		} System.out.println("1 : " + num1 + " | 2 : " + num2 + " | 3 : " + num3 + " | 4 : " + num4 +
				" | 5 : " + num5 + " | 6 : " + num6);
	}

	/*
	 * 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고,
	 * 사용자에게는 직접 가위바위보를 받으세요. 사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.
	 * 
	 * 당신의 이름을 입력해주세요 : 김미경 가위바위보 : 가위 컴퓨터 : 가위 김미경 : 가위 비겼습니다.
	 * 
	 * 가위바위보 : 가위 컴퓨터 : 바위 김미경 : 가위 졌습니다 ㅠㅠ
	 * 
	 * 가위바위보 : 보 컴퓨터 : 바위 김미경 : 보 이겼습니다 ! 비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
	 */
	public void method6() {
	 System.out.println("이름을 입력해주세요");
	 String name = sc.next();
	 int trans = 0;
	 int same = 0;
	 int lose = 0;
	 
	 while (true) {
		 int num = (int)(Math.random()*3+1);
		 System.out.println("가위, 바위, 보! (입력해주세요!)");
		 String input = sc.next();
		 switch(input) {
		 case "가위":
			 trans = 1;
			 break;
		 case "바위":
			 trans = 2;
			 break;
		 case "보":
			 trans = 3;
			 break;
		 }
		switch(num) {
		case 1:
			System.out.println("컴퓨터 : 가위");
		    break;
		case 2:
			System.out.println("컴퓨터 : 바위");
		    break;
		case 3:
			System.out.println("컴퓨터 : 보");
		    break;
		}
		 if(num == trans) {
			 System.out.println("비겼습니다.");
			 same++;
		 } else if((trans == 1 && num == 3) || (trans == 2 && num == 1) || (trans == 3 && num == 1)) {
			 break;
		 } 
		 else {
			 System.out.println("졌습니다.");
			 lose++;
		 }
	 }
	 System.out.println("이겼습니다! 비긴 횟수 : " + same + " 진 횟수 : " + lose);
    
//	 System.out.println("당신의 이름을 입력해주세요 : ");
//	 String name2 = sc.nextLine();
//	 String[] rps = {"가위", "바위", "보"};
//	 int win2 = 0;
//	 int lose2 = 0;
//	 int draw2 = 0;
//	 
//	 while(true) {
//		 System.out.println("가위바위보 : ");
//		 String input = sc.nextLine();
//		 
//		 // 0 - 가위, 1 - 바위, 2 - 보
//		 int computer = (int) (Math.random() * 3);
//		 System.out.println("컴퓨터 : " + rps[computer]);
//		 
//		 System.out.println(name + " : " + input);
//		 
//		 // 배열에서 인덱스 찾기 -> 사용자가 입력한 값을 숫자로!
//	     int num10 = Arrays.asList(rps).indexOf(input);
//		 
//		 if (computer == num10) {
//			 // 비겼을 경우
//			 System.out.println("비겼습니다.");
//			 draw2++;
//		 } else if ((num10 == 0 && computer == 2) || (num10 == 1 && computer == 0) || (num10 == 2 && computer ==1) ) {
//			 // 이겼을 경우
//			 System.out.println("이겼습니다!");
//			 win2++;
//			 break;
//		 } else {
//			// 졌을 경우
//			 lose2++;
//			 System.out.println("졌습니다 ㅠㅠㅠㅠ");
//		 }
//	 } System.out.println("비긴 횟수 : " + draw2 + ", 진 횟수 : " + lose2 + ", 이긴 횟수 : " + win2);
	} 

}