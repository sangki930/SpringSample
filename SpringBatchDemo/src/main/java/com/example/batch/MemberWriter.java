package com.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.domain.Member;
import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberWriter implements ItemWriter<List<Member>>{

	private final MemberService memberService;
	
	@Override
	public void write(List<? extends List<Member>> items) throws Exception {
		// TODO Auto-generated method stub
		items.stream().forEach(members->log.info(members.toString()));
	}

}
