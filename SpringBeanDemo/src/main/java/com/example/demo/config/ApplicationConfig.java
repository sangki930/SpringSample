package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.components.Person;
import com.example.demo.components.SampleComponent;

@Configuration
public class ApplicationConfig {

	@Autowired
	private SampleComponent sc;
	
	@Qualifier(value = "teacher")
	@Autowired
	private Person person;
	
	@Bean
	public void print() {
		System.out.println("Application Config ½ÇÇà");
		
	}
}
