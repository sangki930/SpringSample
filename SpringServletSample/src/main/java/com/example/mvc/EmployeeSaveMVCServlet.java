package com.example.mvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;


@WebServlet(urlPatterns="/mvc/employees/save")
public class EmployeeSaveMVCServlet extends HttpServlet{

	private EmployeeRepository repository = EmployeeRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
