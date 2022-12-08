package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.Member;
import com.example.exception.NoSuchMemberException;
import com.example.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	// 회원 전체 조회
	public List<Member> getMemberList(){
		return memberRepository.findAll();
	}
	
	// 회원 조회
	public Member getMember(Long id) throws NoSuchMemberException {
		return memberRepository.findById(id)
				.orElseThrow(()->new NoSuchMemberException("조회하고자 하는 회원이 없습니다."));
	}
	
	// 회원 추가
	public Member addMember(Member member) {
		return memberRepository.save(member);
	}
	
	// 회원 수정
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}
	
	// 회원 삭제
	public void deleteMember(Member member) {
		memberRepository.delete(member);
	}
}
