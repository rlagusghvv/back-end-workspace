package com.kh;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.model.Book;
import com.kh.model.Member;
import com.kh.model.PrintRentBook;

// 스키마 : sample
// 테이블 : member, book, publisher, rent

public class Application {

	private Scanner sc = new Scanner(System.in);
	private BookController bk = new BookController();
	
	// 로그인 했을 시 사용자 정보를 담는 객체!
	private Member member = new Member();
	
	public static void main(String[] args) {

		Application app = new Application();
		app.mainMenu();
		

	}

	public void mainMenu() {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll() {
		// 반복문을 이용해서 책 리스트 출력
		ArrayList<Book> book = bk.printBookAll();
		for(Book b : book) {
			String pubName = b.getPub_name();
			System.out.println("책 번호 : " + b.getBk_no() + " / 제목 : " + b.getBk_title() + 
					" / 저자 : " + b.getBk_author() + ((pubName != null) ? " / 출판사 : " + b.getPub_name() : ""));
		}
	}

	// 2. 책 등록
	public void registerBook() {
		// 책 제목, 책 저자를 사용자한테 입력 받아
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
		System.out.print("등록할 책 이름을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("등록할 책의 저자 이름을 입력해주세요 : ");
		String author = sc.nextLine();
		if (bk.registerBook(title, author)) {
			System.out.println("성공적으로 책을 등록했습니다.");
		}
		else {
			System.out.println("책을 등록하는데 실패했습니다. 이미 등록된 서적입니다.");
		}
	}

	// 3. 책 삭제
	public void sellBook() {
		// printBookAll로 전체 책 조회를 한 후
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
		printBookAll();
		System.out.print("책 번호를 확인 후 삭제할 책 번호를 입력해주세요 : ");
		int bk_no = Integer.parseInt(sc.nextLine());
		if (bk.checkBook(bk_no)) {
			System.out.println("대여중인 책은 삭제가 불가합니다.");
		}
		else if (bk.sellBook(bk_no)){
			System.out.println("성공적으로 책을 삭제했습니다.");
		}
		else {
			System.out.println("책을 삭제하는데 실패했습니다.");
		}
	}

	// 4. 회원가입
	public void registerMember() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
		System.out.println("회원가입을 도와드리겠습니다.");
		System.out.print("아이디를 입력해주세요 : ");
		String member_id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String member_pwd = sc.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		String member_name = sc.nextLine();
		if (bk.registerMember(member_id, member_pwd, member_name)) {
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		}
		else {
			System.out.println("회원가입에 실패했습니다. 다시 시도해주세요.");
		}
		
	}

	// 5. 로그인
	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력 받아 
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
		System.out.println("로그인을 도와드리겠습니다.");
		System.out.print("아이디를 입력해주세요 : ");
		String member_id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String member_pwd = sc.nextLine();
		String member_name = bk.login(member_id, member_pwd);
		if (member_name != null) {
			System.out.println(member_name + "님, 환영합니다!");
			member = new Member(member_id, member_pwd, member_name);
			memberMenu();
		}
		else {
			System.out.println("로그인에 실패했습니다. 로그인 정보를 확인해주세요.");
		}
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() {
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		printBookAll();
		System.out.print("대여할 책 번호를 선택해 입력해주세요. : ");
		int rent_book_no = Integer.parseInt(sc.nextLine());
		
		if (bk.rentBook(member.getMember_name(), rent_book_no)) {
			System.out.println("성공적으로 책을 대여했습니다.");
		}
		else {
			System.out.println("책 대여에 실패했습니다.");
		}
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook() {
		ArrayList<PrintRentBook> list = bk.printRentBook(member.getMember_name());
		for(PrintRentBook p : list) {
			System.out.println(p);
		}
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	}

	// 3. 대여 취소
	public void deleteRent() {
		printRentBook();
		System.out.print("대여를 취소할 대여 번호를 입력해주세요 : ");
		int rent_no = Integer.parseInt(sc.nextLine());		
		if (bk.deleteRent(rent_no)) {
			System.out.println("성공적으로 대여를 취소했습니다.");
		}
		else {
			System.out.println("대여를 취소하는데 실패했습니다.");
		}
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
	}

	// 4. 회원탈퇴
	public void deleteMember() {
		if(bk.deleteMember(member.getMember_name())) {
			System.out.println("회원탈퇴 완료!");
		}
		else
		{
			System.out.println("회원탈퇴에 실패했습니다.");
		}
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}

}
