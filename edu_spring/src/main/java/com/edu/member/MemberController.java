package com.edu.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@Autowired
	MemberService bir;

	@GetMapping("/getMember.do")
	public String getMember() {
		return "";
	}
	
	@PostMapping("/insert.do")
	public String memberInsert(Member member,@RequestParam("id") String id, Model model) {
		System.out.println(member);
		bir.memberInsert(member);
		model.addAttribute("msg","메시지입니다."); //attribute 등록
		return "memberOutput";
	}
}
