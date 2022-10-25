package com.edu.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.edu.board.service.BoardService;
import com.edu.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService biz;
	
	@GetMapping("/getBoardList")
	public void getBoardList(BoardVO vo, Model model) {
		List<BoardVO> boardList = biz.getBoardList(vo);
		model.addAttribute("boardList", boardList);
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(BoardVO vo) {
		biz.insertBoard(vo);
		return "redirect::getBoardList";
	}
	
	@PutMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		biz.updateBoard(vo);
		return "redirect::getBoardList";
	}
	
	@DeleteMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		biz.deleteBoard(vo);
		return "redirect::getBoardList";
	}
}
