package com.kh.practice1;
import java.util.Scanner;

import com.kh.practice1.controller.SongManager;

public class Application {
	private static SongManager songManager = new SongManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getInput();
            handleMenuOption(choice);
        }
    }

    private static void showMenu() {
        System.out.println("===== 메인 메뉴 =====");
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
    }

    private static int getInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                System.out.print("메뉴 번호 입력 : ");
            }
        }
    }

    private static void handleMenuOption(int choice) {
        switch (choice) {
            case 1:
                addSongLast();
                break;
            case 2:
                addSongFirst();
                break;
            case 3:
                songManager.printAllSongs();
                break;
            case 4:
                searchSong();
                break;
            case 5:
                deleteSong();
                break;
            case 6:
                updateSong();
                break;
            case 7:
                songManager.sortSongsBySingerDesc();
                break;
            case 8:
                songManager.sortSongsByTitleAsc();
                break;
            case 9:
                System.out.println("종료");
                System.exit(0);
                break;
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private static void addSongLast() {
        System.out.println("****** 마지막 위치에 곡 추가 ******");
        System.out.print("곡 명 : ");
        String title = sc.nextLine();
        System.out.print("가수 명 : ");
        String singer = sc.nextLine();
        songManager.addSongLast(title, singer);
    }

    private static void addSongFirst() {
        System.out.println("****** 첫 위치에 곡 추가 ******");
        System.out.print("곡 명 : ");
        String title = sc.nextLine();
        System.out.print("가수 명 : ");
        String singer = sc.nextLine();
        songManager.addSongFirst(title, singer);
    }

    private static void searchSong() {
        System.out.println("****** 특정 곡 검색 ******");
        System.out.print("검색할 곡 명 : ");
        String title = sc.nextLine();
        songManager.searchSong(title);
    }

    private static void deleteSong() {
        System.out.println("****** 특정 곡 삭제 ******");
        System.out.print("삭제할 곡 명 : ");
        String title = sc.nextLine();
        songManager.deleteSong(title);
    }

    private static void updateSong() {
        System.out.println("****** 특정 곡 수정 ******");
        System.out.print("검색할 곡 명 : ");
        String oldTitle = sc.nextLine();
        System.out.print("수정할 곡 명 : ");
        String newTitle = sc.nextLine();
        System.out.print("수정할 가수 명 : ");
        String newSinger = sc.nextLine();
        songManager.updateSong(oldTitle, newTitle, newSinger);
    }
}