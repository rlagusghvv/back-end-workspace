package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kh.list.model.Person;

public class Application_explanation {

	public static void main(String[] args) {
		ArrayList<Integer> lotto = new ArrayList<Integer>();

		// 기존 로또 번호는 6개, 보너스 번호가 필요해 1개 더 추가
		while (lotto.size() < 7) {
			int num = (int) (Math.random() * 45 + 1);
			if (!lotto.contains(num)) {
				lotto.add(num);
			}
		}
		
		// 0 ~ 6까지 범위 지정해서 로또 번호 6개 따로, 보너스 번호 따로!
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = lotto.get(6);
        int count = 0;
		while (true) {
			count++;
			ArrayList<Integer> myLotto = new ArrayList();

			while (myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				if (!myLotto.contains(num)) {
					myLotto.add(num);
				}
			}
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("내 로또 번호 : " + myLotto);

			

			// 무한 루프를 멈추는 조건! 로또 번호와 내 번호가 정확히 일치! 1등 당첨!
			if (lottoList.equals(myLotto)) {
				System.out.println("1등 당첨! 횟수 : " + count);
				break;
			}
			
			int match = 0;
			for(Integer num : lottoList) {
				if(myLotto.contains(num)) {
					match++;
				}
			}
			if(match == 5) {
				if(myLotto.contains(bonus)) {
				System.out.println("2등 당첨! 보너스 번호 : " + bonus + ", 횟수 : " + count);
				break;
				} else {
					System.out.println("3등 당첨! 횟수 : " + count);
				}
			} else if(match == 4) {
				System.out.println("4등 당첨! 횟수 : " + count);
			} else if (match == 3) {
				System.out.println("5등 당첨! 횟수 : " + count);
			}
		}
	}
}
