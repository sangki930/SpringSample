package com.example.demo.components;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// @Component�� �����ڰ� ���� �ۼ��� class�� Bean���� ���
@Component
@Slf4j
public class SampleComponent {

	String str;
	int attr;
	
	public SampleComponent() {
		log.info("SampleComponent Bean ����");
	}
}
