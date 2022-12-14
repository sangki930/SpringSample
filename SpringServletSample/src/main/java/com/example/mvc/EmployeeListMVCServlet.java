package com.example.mvc;

import java.io.IOException;
import java.util.List;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/mvc/employees")
public class EmployeeListMVCServlet extends HttpServlet{

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> employees = repository.findAll();
		
		req.setAttribute("employees", employees);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
		dispatcher.forward(req, resp);
		
	}

	
}
