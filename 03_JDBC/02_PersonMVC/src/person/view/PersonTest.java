package person.view;

import java.util.ArrayList;
import java.util.Scanner;


import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	
	PersonController pc = new PersonController();
    Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		PersonTest pt = new PersonTest();
		while (true)
			switch(pt.menu()) {
			case 1:
				pt.dbc();
				break;
			case 2:
				pt.addPerson();
				break;
			case 3:
				pt.updatePerson();
				break;
			case 4:
				pt.removePerson();
				break;
			case 5:
				pt.searchAllPerson();
				break;
			case 6:
				pt.searchPerson();
				break;
			case 0:
				System.out.println("종료합니다.");
			    
				return;
			default:
				System.out.println("잘못입력하셨습니다. 번호를 확인해주세요.");
				
			}
		
		// 이 부분은 테스트 용도로만!
	}
	
	// 각 Controller에 메서드들 연결하는 건 각 메서드들에서 구현

	// person 테이블에 데이터 추가 - INSERT
	
	
	public int menu () {
		System.out.println("===== 메인 메뉴 =====");
		System.out.println("1. DB 연결");
		System.out.println("2. 데이터 추가");
		System.out.println("3. 데이터 수정");
		System.out.println("4. 데이터 삭제");
		System.out.println("5. 전체 회원 보기");
		System.out.println("6. 회원 정보 찾기");
		System.out.println("0. 종료");
		System.out.print("원하시는 메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	public void dbc () {
		pc.dbc();
	    System.out.println("서버 연결 완료!");
	}
	public void addPerson() {
		System.out.println("테이블에 데이터를 추가합니다. INSERT");
		System.out.print("이름을 입력해주세요 : ");
	    String name = sc.nextLine();
	    System.out.print("나이를 입력해주세요 : ");
	    int age = Integer.parseInt(sc.nextLine());
	    System.out.print("주소를 입력해주세요 : ");
	    String addr = sc.nextLine();
	    
		pc.addPerson(name, age, addr);
	    System.out.println(name + "님 회원가입 완료!");
	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() {
		System.out.println("이름을 입력받아 주소를 수정합니다. UPDATE");
		System.out.print("이름을 입력해주세요 : ");
	    String name = sc.nextLine();
	    System.out.print("수정할 주소를 입력해주세요 : ");
	    String addr = sc.nextLine();
	    
	    pc.updatePerson(name, addr);
	    System.out.println(name + "님 주소 수정 완료!");
			// ~~님, 정보 수정 완료!
	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() {
		System.out.println("이름을 입력받아 데이터를 삭제합니다. DELETE");
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		pc.removePerson(name);
		System.out.println(name + "님 회원 탈퇴 완료!");
			// ~~님, 회원탈퇴 완료!
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson() {
		System.out.print("찾는 사람의 이름을 입력해주세요. : ");
		String name = sc.nextLine();
		pc.searchPerson(name);
	}
	
}
