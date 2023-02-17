package com.example.trace.tracev1;

import org.junit.jupiter.api.Test;

import com.example.trace.TraceStatus;
import com.example.trace.traceVO.TraceV1;

public class TraceV1Test {
	
	@Test
	void begin_end() {
		TraceV1 traceV1 = new TraceV1();
		TraceStatus status = traceV1.begin("hello");
		traceV1.end(status);
	}
	
	@Test
	void begin_exception() {
		TraceV1 traceV1 = new TraceV1();
		TraceStatus status = traceV1.begin("hello");
		traceV1.exception(status,new IllegalArgumentException());
	}

}
