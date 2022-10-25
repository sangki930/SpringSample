package com.edu.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BoardController {

	@GetMapping("/getMem.bo")
	public void f1() {
		
	}
	@PostMapping("/insert.do")
	public void f2() {
		
	}
	@PutMapping("/update.do")
	public void f3() {
		
	}
//	@DeleteMapping("/getList.do")
//	@RequestMapping(value = "/getList.do", method = RequestMethod.GET)

}
