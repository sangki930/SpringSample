package com.example.mvc.v4;

import java.util.Map;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;


public class EmployeeSaveControllerV4 implements FrontControllerV4{

	private EmployeeRepository repository = EmployeeRepository.getInstance();

	@Override
	public String service(Map<String, String> paramMap, Map<String, Object> model) {
		String empno = paramMap.get("empno");
		String name = paramMap.get("name");
		String team = paramMap.get("team");
		
		Employee employee = new Employee(empno,name,team);
		Employee savedEmployee = repository.save(employee);
		
		model.put("employee", savedEmployee);
		return "save";
	}

	
}
