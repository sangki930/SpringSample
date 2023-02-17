package com.example.trace.traceVO;

import org.springframework.stereotype.Component;

import com.example.trace.TraceId;
import com.example.trace.TraceStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // Bean으로 등록
public class TraceV1 {
	
	private static final String START_PREFIX = "-->";
	private static final String COMPLETE_PREFIX = "<--";
	private static final String EX_PREFIX = "<X-";

	// 로그 시작
	public TraceStatus begin(String message) {
		TraceId traceId = new TraceId();
		Long startTimeMs = System.currentTimeMillis();
		// 로그 출력
		log.info("[{}] {}{}",traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()),message);
		return new TraceStatus(traceId,startTimeMs,message);
	}
	
	// 로그 정상 종료
	public void end(TraceStatus status) {
		complete(status,null);
	}
	
	// 로그 예외 종료
	public void exception(TraceStatus status, Exception e) {
		complete(status, e);
	}
	
	// (비공개 메서드)
	public void complete(TraceStatus status, Exception e) {
		Long stopTimeMs = System.currentTimeMillis();
		long resultTimeMs = stopTimeMs - status.getStartTimeMs();
		TraceId traceId = status.getTraceId();
		if(e==null) {
			log.info("[{}] {}{} time={}ms",traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()),status.getMessage(),resultTimeMs);
		}else {
			log.info("[{}] {}{} time={}ms ex={}",traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()),status.getMessage(),resultTimeMs,e.toString());
		}
	}
	
	// (비공개 메서드)
	private String addSpace(String prefix, int level) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<level;i++) {
			sb.append( (i==level-1)? "|" + prefix : "|   " );
		}
		
		return sb.toString();
	}
}
