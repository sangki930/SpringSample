package com.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.domain.Member;
import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberReader implements ItemReader<List<Member>>{
	
	@Qualifier("batchmemberServiceForReader")
	private final MemberService memberService;

	@Override
	public List<Member> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		log.info("fetch members...");
		List<Member> memberList = memberService.getMemberList();
		log.info("fetch data size = {}",memberList.size());
		
		return memberList;
	}
	
}
