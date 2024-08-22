package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

import mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public void insert(Board vo) {
		mapper.insert(vo);
	}
	
	public List<Board> selectAll(Paging paging) {
		
		/*
		 * limit가 10인 경우
		 * page = 1 -> offset = 0
		 * page = 2 -> offset = 10
		 * page = 3 -> offset = 20 ...
		 * 
		 * offset = limit * (page - 1)
		 * */
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		
		return mapper.selectAll(paging);
	}
	
	public int total() {
		return mapper.total();
	}
	
	public Board select(int no) {
		return mapper.select(no);
	}
	
	public void update(Board vo) {
		mapper.update(vo);
	}
	
	public void delete(int no) {
		mapper.delete(no);
	}
}






