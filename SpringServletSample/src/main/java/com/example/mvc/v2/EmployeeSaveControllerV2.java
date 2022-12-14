package com.example.mvc.v2;

import java.io.IOException;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EmployeeSaveControllerV2 implements FrontControllerV2{

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Override
	public MyView service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		String empno = req.getParameter("empno");
		String name = req.getParameter("name");
		String team = req.getParameter("team");
		
		Employee employee = new Employee(empno,name,team);
		Employee savedEmployee = repository.save(employee);
		req.setAttribute("employee", savedEmployee);
		
		return new MyView("/WEB-INF/views/save.jsp");
	}

	
}
