package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SampleConfig {

	// @Bean은 개발자가 직접 제어가 어려운 외부라이브러리 등을 Bean으로 등록할 때 씀
	@Bean
	public void execute() {
		for(int i=0;i<5;i++) {
			log.info("이것은 execute Bean입니다.===>"+i);
		}
	}
	
	@Bean
	public ArrayList<Integer> intArray(){
		ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4));
		log.info("이것은 intArray Bean입니다.");
		return (ArrayList<Integer>)list;
	} 
}
