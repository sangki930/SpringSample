package com.edu.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	MemberDAO dao = new MemberDAO();
	
	public void memberInsert(Member member){
		dao.memberInsert(member);
	}
	
}
