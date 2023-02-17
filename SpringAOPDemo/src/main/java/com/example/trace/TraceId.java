package com.example.trace;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TraceId {

	private String id;
	private int level;
	
	public TraceId() {
		this.id = createdId();
		this.level = 0;
	}

	private TraceId(String id, int level) {
		this.id=id;
		this.level = level;
	}
	
	// UUID 생성
	private String createdId() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().substring(0,8);
	}
	
	// 다음 UUID 생성
	private TraceId createNextId() {
		return new TraceId(id,level+1);
	}
	
	// 이전 UUID 확인
	private TraceId createPreviousId() {
		return new TraceId(id,level-1);
	}
	
	// 첫 번째 단계인지
	public boolean isFirstLevel() {
		return level == 0;
	}
}
