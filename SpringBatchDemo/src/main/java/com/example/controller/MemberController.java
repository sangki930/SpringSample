package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Member;
import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Member>> getMemberList(
			){
		return null;
	}
	
	@GetMapping
	public ResponseEntity<Member> getMember(
			@PathVariable Long id
			){
		Member member = memberService.getMember(id);
		
		return new ResponseEntity<Member>(HttpStatus.OK);
	}
	
	@PatchMapping
	public ResponseEntity<?> updateMember(){
		return null;
	}
}
