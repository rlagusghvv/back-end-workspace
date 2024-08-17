package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;

import mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	public void write (Board board) {
		boardMapper.write(board);
	}
	
	public List<Board> list (){
		return boardMapper.list();
	}
	
}
