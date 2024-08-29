package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.vo.User;

import mapper.TestMapper;

@Service
public class TestService {

	@Autowired
	private TestMapper testMapper;
	
	public void register(User vo) {
		testMapper.register(vo);
	}
	
	public List<User> view(){
		return testMapper.view();
	}
}
