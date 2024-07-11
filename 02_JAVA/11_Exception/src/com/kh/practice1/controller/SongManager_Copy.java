package com.kh.practice1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.practice1.model.Song;
import com.kh.practice1.model.Song_copy;

public class SongManager_Copy {
       Song_copy scp = new Song_copy();
       Scanner sc = new Scanner(System.in);
       ArrayList array = new ArrayList();
       private List<Song> songs;
       
       

	public void mainmenu() {
    	   System.out.println("===== 메인 메뉴 =====");
    	   System.out.println("1. 마지막 위치에 곡 추가");
    	   System.out.println("2. 첫 위치에 곡 추가");
    	   System.out.println("3. 전체 곡 목록 출력");
    	   System.out.println("4. 특정 곡 검색");
    	   System.out.println("5. 특정 곡 삭제");
    	   System.out.println("6. 특정 곡 수정");
    	   System.out.println("7. 가수 명 내림차순 정렬");
    	   System.out.println("8. 곡 명 내림차순 정렬");
    	   System.out.println("9. 종료");
       }
       
       public int mainInput() {
    	   int num = 0;
    	   System.out.print("메뉴 번호 입력 : ");
    	   try {num = sc.nextInt();}
    	   catch (Exception e) {
    		   System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요");
    		   mainmenu();
    	   }
    	   return num;
       }
       
       public void mainSelect(int num) {
    	   switch(num) {
    	   case 1:
    		   backInput();
    		   break;
    	   case 2:
    		   break;
    	   case 3:
    		   break;
    	   case 4:
    		   break;
    	   case 5:
    		   break;
    	   case 6:
    		   break;
    	   case 7:
    		   break;
    	   case 8:
    		   break;
    	   case 9:
    		   break;
    	   default:
    		   System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
    		   
    	   }
       }
       
       public void backInput () {
    	  System.out.println("곡 명 : ");
    	  String song = sc.nextLine();
    	  System.out.println("가수 명 : ");
    	  String singer = sc.nextLine();
    	  songs.add(new Song(song, singer));
    	  System.out.println("추가 완료");
    	  
       }
	
}
