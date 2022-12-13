package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringServletSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServletSampleApplication.class, args);
	}

}
