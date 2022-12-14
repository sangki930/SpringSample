package com.example.mvc.v4;

import java.util.List;
import java.util.Map;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

public class EmployeeListControllerV4 implements FrontControllerV4{

	private EmployeeRepository repository = EmployeeRepository.getInstance();

	@Override
	public String service(Map<String, String> paramMap, Map<String, Object> model) {
		// TODO Auto-generated method stub
		List<Employee> employees = repository.findAll();
		model.put("employees",employees);
		return "list";
	}
	
}
