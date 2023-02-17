package com.example.v1.repository;

import org.springframework.stereotype.Repository;

import com.example.trace.TraceStatus;
import com.example.trace.traceVO.TraceV1;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SampleRepositoryV1 {

	private final TraceV1 trace;
	
	// 저장
	public void save(String itemId) {
		
		TraceStatus status = null;
		try{
			status = trace.begin("SampleRepositoryV1.save()");
			if(itemId.equals("ex")) {
				throw new IllegalArgumentException("예외 발생!!");
			}
			sleep(1000);
		}catch(Exception e) {
			trace.exception(status, e);
			throw e;
//			return new ResponseEntity<String>(e.getStackTrace().toString(),HttpStatus.EXPECTATION_FAILED);
		}
		
	}

	private void sleep(int millis) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(millis);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
