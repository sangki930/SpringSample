package com.example.demo.components;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// @Component는 개발자가 직접 작성한 class를 Bean으로 등록
@Component
@Slf4j
public class SampleComponent {

	String str;
	int attr;
	
	public SampleComponent() {
		log.info("SampleComponent Bean 생성");
	}
}
