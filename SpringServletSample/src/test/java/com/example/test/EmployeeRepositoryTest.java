package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class EmployeeRepositoryTest {

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Test
	public void repositoryTest() {
		
		Employee e1 = new Employee("11233","박상기","금융DT수행팀");
		Employee e2 = new Employee("11234","박승기","금융DT컨설팅팀");
		Employee e3 = new Employee("11235","박산기","항공관리시스템");
		
		Employee saveE1 = repository.save(e1);
		Employee saveE2 = repository.save(e2);
		Employee saveE3 = repository.save(e3);
		
		// assert
		assertEquals(saveE1, e1);
		
		assertThat(saveE2).isEqualTo(e2);
		
		log.info("{}==>{}",e1,saveE1);
		log.info("{}==>{}",e2,saveE2);
		log.info("{}==>{}",e3,saveE3);
		
		List<Employee> employees = repository.findAll();
		employees.forEach(log::info);
		
	}

}
