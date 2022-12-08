package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(modifyOnCreate = true) // Jpa Auditing 실행
@SpringBootApplication
public class SpringRestapiSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestapiSampleApplication.class, args);
	}

}
