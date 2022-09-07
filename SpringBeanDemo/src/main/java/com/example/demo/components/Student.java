package com.example.demo.components;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Student implements Person{

	public Student() {
		log.info("Student Bean ����");
	}
	
	@Override
	public void introduce() {
		log.info("���� �л��Դϴ�.");
	}
	
}
