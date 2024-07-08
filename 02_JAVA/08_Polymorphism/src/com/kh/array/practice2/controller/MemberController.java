package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {

	private Member[] member = new Member[3];
	public int count = 0;
    int i = 0;

    // 맴버 추가
    public void insertMember(Member m) {
    	member[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(),m.getGender(),m.getAge());
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
    
    public void updateMember(String id, String name, String email, String password) {
    	// 맴버의 index 찾기
    	int index = searchMemberID(id);
    	member[index].setName(name);
    	member[index].setName(email);
    	member[index].setName(password);
    	
    	
    }
    
    // 맴버 조회
    public Member[] printAll() {
    	return member;
    }
    
}