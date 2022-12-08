package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Member;

@SpringBootTest
public class MemberServiceTest {

	@Test
	public void newMemberTest() {
		Member member = Member.builder().id(1L).account("test").build();
		System.out.println(member);
	}

}
