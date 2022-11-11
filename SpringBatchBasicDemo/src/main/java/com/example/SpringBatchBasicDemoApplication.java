package com.example;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing // Spring Batch를 활용하기 위한 꼭 필요한 어노테이션
public class SpringBatchBasicDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchBasicDemoApplication.class, args);
	}

}
