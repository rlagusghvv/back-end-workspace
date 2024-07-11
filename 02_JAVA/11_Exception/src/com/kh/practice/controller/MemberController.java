package com.kh.practice.controller;

import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Member;

public class MemberController {

	private Member[] member = new Member[3];
	public int count = 0;
	int i = 0;

	// 맴버 추가
	public void insertMember(Member m) throws DuplicateNameException {

		int index = searchMemberID(m.getId());

		if (index == -1) {
			member[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(),
					m.getAge());
		} else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException();
		}

//    	System.out.println(Arrays.toString(member));
	}

	// 맴버 아이디 검색 -> 맴버 index를 아이디로 조회
	public int searchMemberID(String id) {
    	for(int i = 0; i < member.length; i++) {
    		if(member[i] != null && member[i].getId().equals(id)) {
    			// 기존 맴버 배열에 아이디가 있는 경우!
    			return i;
    		} 
    	}
    	// 아이디가 없는 경우
    	       return -1;
	}

	public int checkUpdateId(String id) throws RecordNotFoundException {
		for (int i = 0; i < member.length; i++) {
			if (member[i] != null && member[i].getId().equals(id)) {
				// 기존 맴버 배열에 아이디가 있는 경우!
				 return i;
			} else {
				throw new RecordNotFoundException();
			}
		}
		// 아이디가 없는 경우
		return -1;

	}

	public void updateMember(String id, String name, String email, String password) throws RecordNotFoundException {
		// 맴버의 index 찾기
		int index = checkUpdateId(id);
		member[index].setName(name);
		member[index].setName(email);
		member[index].setName(password);

	}

	// 맴버 조회
	public Member[] printAll() {
		return member;
	}

}