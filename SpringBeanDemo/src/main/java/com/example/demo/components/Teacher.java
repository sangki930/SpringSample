package com.example.demo.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component(value = "teacher")
@Slf4j
public class Teacher implements Person{

	public Teacher() {
		log.info("Teacher Bean ����");
	}
	
	@Override
	public void introduce() {
		// TODO Auto-generated method stub
		log.info("���� �������Դϴ�.");
	}

}
