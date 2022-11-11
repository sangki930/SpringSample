package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Member 아이디
	
	private String name; // Member 이름
	
	private String account; // Member 계정명
	
	private String password; // 계정 비밀번호
	
	private boolean isUsed; // 개인정보 이용동의
	
}
