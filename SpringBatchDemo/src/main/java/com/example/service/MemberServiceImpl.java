package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	
	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	@Override
	public Member getMember(Long id) {
		// TODO Auto-generated method stub
		return memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("알 수 없는 오류 발생"));
	}

	@Override
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	@Override
	public Member updateMember(Member member) {
		// TODO Auto-generated method stub
		// ID는 절대로 수정하면 안됨
		return memberRepository.save(member);
	}

	@Override
	public Member deleteMemberLogical(Member member) {
		// TODO Auto-generated method stub
		Member del = memberRepository.findById(member.getId()).orElseThrow(()->new IllegalArgumentException("알 수 없는 오류 발생"));
		del.setUsed(false);
		memberRepository.save(del);
		return del;
	}

	// Member 인스턴스로 물리적 삭제
	@Override
	public void deleteMember(Member member) {
		// TODO Auto-generated method stub
		memberRepository.delete(member);
	}

	// ID로 회원 물리적 삭제
	@Override
	public void deleteMemberById(Long id) {
		// TODO Auto-generated method stub
		memberRepository.deleteById(id);
	}

	
}
