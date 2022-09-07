package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SampleConfig {

	// @Bean�� �����ڰ� ���� ��� ����� �ܺζ��̺귯�� ���� Bean���� ����� �� ��
	@Bean
	public void execute() {
		for(int i=0;i<5;i++) {
			log.info("�̰��� execute Bean�Դϴ�.===>"+i);
		}
	}
	
	@Bean
	public ArrayList<Integer> intArray(){
		ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4));
		log.info("�̰��� intArray Bean�Դϴ�.");
		return (ArrayList<Integer>)list;
	} 
}
