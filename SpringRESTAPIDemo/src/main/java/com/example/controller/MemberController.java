package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Member;
import com.example.domain.dto.ChangePasswordDTO;
import com.example.domain.dto.ErrorDescDTO;
import com.example.exception.NoSuchMemberException;
import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	
	// 회원 전체 조회
	@GetMapping(value = "/getMemberList")
	public ResponseEntity<?> getMemberList(
			@RequestHeader Map<String,Object> header,
			@RequestBody Map<String,Object> body
			){
		
		// 유효한 사용자인지 검증
		if(header==null) {
			return new ResponseEntity<>("유효하지 않은 사용자입니다.",HttpStatus.UNAUTHORIZED);
		}
		
		List<Member> memberList = memberService.getMemberList();
		
		return new ResponseEntity<>(memberList,HttpStatus.OK);
	}
	
	// 회원 조회
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getMemberById(@PathVariable Long id) throws Exception{
		Member member = memberService.getMember(id);
		log.info("===> 회원조회 결과 : "+member);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	// 회원 추가
	@RequestMapping(method = RequestMethod.POST, value = "/addMember")
	public ResponseEntity<?> addMember(@RequestBody Member member){
		memberService.addMember(member);
		log.info("===> 회원 추가 완료");
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	// 회원 수정
	@RequestMapping(method = RequestMethod.PUT, value = "/updateMember")
	public ResponseEntity<?> updateMember(@RequestBody Member member){
		memberService.updateMember(member);
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
	// 회원 완전 삭제
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteMember/{id}")
	public ResponseEntity<?> deleteMember(@PathVariable Long id){
		
		Member member = Member.builder().id(id).build();
		memberService.deleteMember(member);
		return new ResponseEntity<Member>(new Member(),HttpStatus.OK);
	}
	
	// 비밀번호 변경
	@RequestMapping(method = RequestMethod.PATCH, value = "/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
		
		try {
			Member member = memberService.changePassword(changePasswordDTO.getAccount(), changePasswordDTO.getPassword());
		} catch (NoSuchMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorDescDTO<Member> ret = new ErrorDescDTO<>(HttpStatus.BAD_REQUEST.value(), 
					e.getMessage());
			return new ResponseEntity<>(ret,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Member>(new Member(),HttpStatus.OK);
	}
	
}
