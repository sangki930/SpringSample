package com.edu.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.board.repository.BoardMybatis;
import com.edu.board.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	BoardMybatis dao;
	
	public List<BoardVO> getBoardList(BoardVO vo){
		return dao.getBoardList(vo);
	}
	
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

}
