package com.example.v1.service;

import org.springframework.stereotype.Service;

import com.example.repository.SampleRepository;
import com.example.trace.TraceStatus;
import com.example.trace.traceVO.TraceV1;
import com.example.v1.repository.SampleRepositoryV1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceV1 {

	private final SampleRepositoryV1 sampleRepositoryV1;
	private final TraceV1 trace;
	
	public void makeSample(String itemId) {
		
		TraceStatus status = null;
		try{
			status = trace.begin("SampleController.makeSample()");
			sampleRepositoryV1.save(itemId);
			trace.end(status);
		}catch(Exception e) {
			trace.exception(status, e);
			throw e;
//			return new ResponseEntity<String>(e.getStackTrace().toString(),HttpStatus.EXPECTATION_FAILED);
		}
	}
}
