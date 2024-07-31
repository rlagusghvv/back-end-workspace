package com.kh.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
//	public MemberService(MemberMapper memberMapper) {
//		this.memberMapper = memberMapper;
//	}
	
	public void register(Member member) {
		mapper.register(member);	// MemberMapper.java와 member.xml에서 1:1 매핑한 member 값을 여기에서 불러옴
	}
	
	public List<Member> allMember() {
		return mapper.allMember();
	}
	
	public Member login(Member member) {
		return mapper.login(member);
		}
	
	public void update(Member member) {
		mapper.update(member);
	}
}
