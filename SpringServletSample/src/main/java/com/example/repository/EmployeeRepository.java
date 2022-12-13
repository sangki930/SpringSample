package com.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.entity.Employee;

public class EmployeeRepository {

	private static Map<Long,Employee> store = new HashMap<>();
	private static long id = 0;
	private static EmployeeRepository instance = new EmployeeRepository();
	
	private EmployeeRepository(){}
	
	public static EmployeeRepository getInstance() {
		return instance;
	}
	
	public Employee findById(long id) {
		Optional<Employee> opt = Optional.ofNullable(store.get(id));
		return opt.orElseThrow(()->new IllegalArgumentException("오류입니다."));
	}
	
	public Employee save(Employee employee) {
		employee.setId(id++);
		store.put(id,employee);
		return employee;
	}
	
	public List<Employee> findAll(){
		return new ArrayList<>(store.values());
	}
}
