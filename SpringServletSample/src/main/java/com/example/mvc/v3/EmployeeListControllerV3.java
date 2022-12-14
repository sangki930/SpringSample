package com.example.mvc.v3;

import java.util.List;
import java.util.Map;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

public class EmployeeListControllerV3 implements FrontControllerV3{

	private EmployeeRepository repository = EmployeeRepository.getInstance();

	@Override
	public MyModelAndView service(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		List<Employee> employees = repository.findAll();
		
		MyModelAndView mav = new MyModelAndView("list");
		mav.getModel().put("employees", employees);
		
		return mav;
	}
	

	
}
