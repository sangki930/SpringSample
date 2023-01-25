package com.example.service;

import java.util.List;

import com.example.domain.Member;

public interface MemberService{

	// 전 회원 불러오기
	public List<Member> getMemberList();
	
	// 회원정보 가져오기
	public Member getMember(Long id);
	
	// 회원 추가
	public Member addMember(Member member);
	
	// 회원 수정
	public Member updateMember(Member member);
	
	// 회원 삭제(논리적)
	public Member deleteMemberLogical(Member member);
	
	// 회원 삭제(물리적)
	public void deleteMember(Member member);
	
	// id로 회원삭제
	public void deleteMemberById(Long id);
}
