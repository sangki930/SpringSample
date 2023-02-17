package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.dto.Message;
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
	
	@GetMapping("/batch")
	public ResponseEntity<Message> runBatch(){
		log.info("배치 실행");
		return new ResponseEntity<Message>(new Message("배치 실행"),HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Member>> getMemberList(
			){
		log.info("회원 전체 조회");
		List<Member> memberList = memberService.getMemberList();
		log.info("조회결과==>{}",memberList.toString());
		return new ResponseEntity<List<Member>>(memberList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Member> getMember(
			@PathVariable Long id
			){
		Member member = memberService.getMember(id);
		log.info("id : {} 회원 조회 성공", id);
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
	// 회원 추가
	@PostMapping("/addMember")
	public ResponseEntity<?> addMember(
			@RequestBody Member member
			){
		log.info("회원 추가 성공==>{}", member.toString());
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
	// 미사용
	@PutMapping("/{id}")
	public ResponseEntity<?> refreshMember(
			@PathVariable Long id
			) {
		log.info("회원 수정 성공==>{}", id);
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	// 미사용
//	@PatchMapping("/{id}")
//	public ResponseEntity<?> updateMember(
//			@PathVariable Long id
//			){
//		return new ResponseEntity<String>("",HttpStatus.OK);
//	}
//	
	@PatchMapping("/{id}")
	public ResponseEntity<?> deleteMemberLogical(
			@PathVariable Long id
			){
		Member member = Member.builder().id(id).build();
		member = memberService.deleteMemberLogical(member);
		log.info("해당 {}는 논리적 삭제가 되었습니다.",id);
		return new ResponseEntity<Member>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteMember(
			@PathVariable Long id
			){
		return new ResponseEntity<String>("물리적으로 삭제",HttpStatus.OK);
	}
	
}