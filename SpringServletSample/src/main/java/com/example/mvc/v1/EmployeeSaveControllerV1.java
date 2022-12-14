package com.example.mvc.v1;

import java.io.IOException;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EmployeeSaveControllerV1 implements FrontControllerV1{

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		String empno = req.getParameter("empno");
		String name = req.getParameter("name");
		String team = req.getParameter("team");
		
		Employee employee = new Employee(empno,name,team);
		Employee savedEmployee = repository.save(employee);
		req.setAttribute("employee", savedEmployee);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/save.jsp");
		dispatcher.forward(req, resp);
	}

	
}
