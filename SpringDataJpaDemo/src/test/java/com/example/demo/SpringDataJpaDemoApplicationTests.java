package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sampleone.SampleOne;

@SpringBootTest
class SpringDataJpaDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void entityTest() {
		SampleOne sample = new SampleOne();
	}
}
