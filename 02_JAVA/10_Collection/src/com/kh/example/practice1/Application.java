package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;

import com.kh.list.model.Person;

public class Application {

	    public static void main(String[] args) {
	        int[] winning = {4, 28, 35, 39, 44, 45};
	        int[] winningResult = new int[6];
	        int count = 0;
	        boolean found = false;

	        while(!found) {
	            count++;
	            int[] random = new int[6];
	            for (int i = 0; i < random.length; i++) {
	                random[i] = (int)(Math.random() * 45 + 1);
	                // 중복 방지
	                for (int j = 0; j < i; j++) {
	                    if (random[i] == random[j]) {
	                        i--; // 중복된 경우 다시 랜덤 번호 생성
	                        break;
	                    }
	                }
	            }
	            
	            System.out.println("로또 번호 : " + Arrays.toString(winning));
	            System.out.println("내 번호 : " + Arrays.toString(random));
	            
	            int matchCount = 0;
	            for (int i = 0; i < winning.length; i++) {
	                for (int j = 0; j < random.length; j++) {
	                    if (winning[i] == random[j]) {
	                        matchCount++;
	                        break;
	                    }
	                }
	            }
	            
	            if (matchCount == 6) {
	                winningResult = random;
	                found = true;
	            }
	        }

	        System.out.println("당첨! : " + Arrays.toString(winningResult));
	        System.out.println("시도 횟수: " + count);
	    }
	}

