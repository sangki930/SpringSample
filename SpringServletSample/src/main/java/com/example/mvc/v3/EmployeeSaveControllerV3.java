package com.example.mvc.v3;

import java.util.Map;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;


public class EmployeeSaveControllerV3 implements FrontControllerV3{

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Override
	public MyModelAndView service(Map<String,String> paramMap) {
		
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("utf-8");
		
		String empno = paramMap.get("empno");
		String name = paramMap.get("name");
		String team = paramMap.get("team");
		
		Employee employee = new Employee(empno,name,team);
		Employee savedEmployee = repository.save(employee);
		
		MyModelAndView mav = new MyModelAndView("save");
		mav.getModel().put("employee", savedEmployee);
		
		return mav;
	}

	
}
