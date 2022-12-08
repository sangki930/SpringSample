package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getMemberById(@PathVariable Long id) throws Exception{
		Member member = memberService.getMember(id);
		log.info("===> 회원조회 결과 : "+member);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addMember")
	public ResponseEntity<?> addMember(@RequestBody Member member){
		memberService.addMember(member);
		log.info("===> 회원 추가 완료");
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateMember")
	public ResponseEntity<?> updateMember(@RequestBody Member member){
		memberService.updateMember(member);
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteMember/{id}")
	public ResponseEntity<?> deleteMember(@PathVariable Long id){
		
		Member member = Member.builder().id(id).build();
		memberService.deleteMember(member);
		return new ResponseEntity<Member>(new Member(),HttpStatus.OK);
	}
	
	
}
