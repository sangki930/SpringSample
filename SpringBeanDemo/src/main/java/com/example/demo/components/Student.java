package com.example.demo.components;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Student implements Person{

	public Student() {
		log.info("Student Bean 생성");
	}
	
	@Override
	public void introduce() {
		log.info("저는 학생입니다.");
	}
	
}
