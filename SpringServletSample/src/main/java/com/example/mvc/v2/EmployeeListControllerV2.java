package com.example.mvc.v2;

import java.io.IOException;
import java.util.List;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeListControllerV2 implements FrontControllerV2{

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Override
	public MyView service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> employees = repository.findAll();
		
		req.setAttribute("employees", employees);
		
		
		return new MyView("/WEB-INF/views/list.jsp");
		
	}

	
}
