package com.example.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trace.TraceStatus;
import com.example.trace.traceVO.TraceV1;
import com.example.v1.service.SampleServiceV1;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleControllerV1 {

	private final SampleServiceV1 sampleService;
	private final TraceV1 trace;
	
	@GetMapping("/v1/request")
	public ResponseEntity<?> request(String itemId) {
		
		TraceStatus status = null;
		try{
			status = trace.begin("SampleController.request()");
			sampleService.makeSample(itemId);
			trace.end(status);
		}catch(Exception e) {
			trace.exception(status, e);
			throw e;
//			return new ResponseEntity<String>(e.getStackTrace().toString(),HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
}
