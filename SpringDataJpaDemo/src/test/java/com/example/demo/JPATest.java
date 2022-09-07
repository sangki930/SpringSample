package com.example.demo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sampleone.SampleOne;
import com.example.demo.sampleone.repository.SampleOneRepository;

@SpringBootTest
@DataJpaTest // JPA 테스트할 때마다 롤백됨
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
public class JPATest {
	
	@Autowired
	private SampleOneRepository sor;
	
	@Order(1)
	@DisplayName("SampleOne add")
	@Transactional
	public void addSampleOne() {
		SampleOne sampleOne = SampleOne.builder()
									.attr1("1234")
									.attr2("asdsada")
									.build();
		sor.save(sampleOne);
	}
	
	@Order(2)
	@DisplayName("SampleOne add")
	public void getSampleOne() {
		System.out.println(sor.getById(1L));
	}
	
	

}
