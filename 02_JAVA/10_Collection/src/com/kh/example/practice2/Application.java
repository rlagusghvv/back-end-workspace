package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.example.practice2.controller.MusicController;
import com.kh.example.practice2.model.Music;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public static void main(String[] args) {

		Application app = new Application();
		app.menu();
	}

	public void menu() {
		try {
			boolean check = true;
			while (check) {
				System.out.println("===== 메인메뉴 =====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 가수 명 내림차순 정렬");
				System.out.println("8. 곡 명 오름차순 정렬");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					addLastList();
					break;
				case 2:
					addFirstList();
					break;
				case 3:
					printAll();
					break;
				case 4:
					searchMusic();
					break;
				case 5:
					removeMusic();
					break;
				case 6:
					updateMusic();
					break;
				case 7:
					descArtist();
					break;
				case 8:
					ascSong();
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
				default:
					System.out.println("잘못 입력했습니다. 숫자를 확인해주세요.");

				}
			}
		} catch (Exception e) {
			System.out.println("잘못 입력했습니다. 메뉴 번호를 확인해주세요.");
			menu();
		}
	}

//	1. 마지막 위치에 곡 추가
	public void addLastList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡명 : ");
		String song = sc.nextLine();
		System.out.print("가수명 : ");
		String artist = sc.nextLine();
		boolean result = mc.addLastList(new Music(artist, song));
		if (result) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("추가 실패!");
		}

	}

//	2. 첫 위치에 곡 추가
	public void addFirstList() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡명 : ");
		String song = sc.nextLine();
		System.out.print("가수명 : ");
		String artist = sc.nextLine();
		boolean result = mc.addFirstList(new Music(artist, song));
		if (result) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("추가 실패!");
		}
	}

//	3. 전체 곡 목록 출력
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		ArrayList<Music> list = mc.printAll();
		for (Music music : list) {
			System.out.println(music);
		}

	}

//	4. 특정 곡 검색
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡명 : ");
		String song = sc.nextLine();
		Music music = mc.searchMusic(song);
		if (music != null) {
			System.out.println(music + "을 검색했습니다.");
		} else {
			System.out.println("검색한 곡을 찾지 못했습니다.");
		}
	}

//	5. 특정 곡 삭제
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡명 : ");
		String song = sc.nextLine();
		// song 조건에 따라서 : 정확하게 곡 입력해야 함!
		Music music = mc.removeMusic(song);
		if(music!=null) {
			System.out.println(music + "을 삭제했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
			
		}
	}

//	6. 특정 곡 수정
	public void updateMusic() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡명 : ");
		String search = sc.nextLine();
		System.out.print("수정할 곡명 : ");
		String song = sc.nextLine();
		System.out.print("수정할 가수명 : ");
		String artist = sc.nextLine();

		// search 조건에 따라서 : 정확하게 곡 입력되어야 함!
		Music update = new Music(artist, song);
		Music music = mc.updateMusic(search, update);
		
		if(music!=null) {
			System.out.println(music + "의 값이 변경 되었습니다.");
		} else {
			System.out.println("수정할 곡을 찾지 못했습니다.");		
		}
	}

//	7. 가수 명 내림차순 정렬
	public void descArtist() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");

		// 가수 명에 따라 내림차순 정렬!!
		for(Music music : mc.descArtist()) {
			System.out.println(music);
		}
	}

//	8. 곡 명 오름차순 정렬
	public void ascSong() {

		System.out.println("****** 곡 명 오름차순 정렬 ******");

		// 곡 명에 따라 오름차순 정렬!!
		for(Music music : mc.ascSong()) {
			System.out.println(music);
		}

	}
}
