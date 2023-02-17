package com.example.trace;

import lombok.AllArgsConstructor;

// 로그의 상태 정보를 나타내는 클래스
@AllArgsConstructor
public class TraceStatus {
	
	private TraceId traceId; // 추적ID(트랜잭션ID, LEVEL을 갖고 있음)
	private Long startTimeMs; // 시작시간
	private String message; // 시작 시 사용하는 메시지
	
	public TraceId getTraceId() {
		return traceId;
	}

	public Long getStartTimeMs() {
		return startTimeMs;
	}

	public String getMessage() {
		return message;
	}

}
