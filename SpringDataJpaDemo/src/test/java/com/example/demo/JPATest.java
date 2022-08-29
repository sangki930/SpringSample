package com.example.demo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJpaTest // JPA �׽�Ʈ�� ������ �ѹ��
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
public class JPATest {
	
	@Test
	public void test() {
		
	}
	

}
