package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/employees/save")
public class EmployeeSaveServlet extends HttpServlet {
	
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
		
		PrintWriter writer = resp.getWriter();
		
		writer.write(
				"<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Servlet</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>SUCCESS!</h1>\r\n"
				+ "	<ul>\r\n"
				+ "	<li>id="+savedEmployee.getId()+"</li>\r\n"
				+ "	<li>empno="+savedEmployee.getEmpno()+"</li>\r\n"
				+ "	<li>name="+savedEmployee.getName()+"</li>\r\n"
				+ "	<li>team="+savedEmployee.getTeam()+"</li>\r\n"
				+ "	</ul>\r\n"
				+ "	<a href=\"/servlet/employees/new-form\">NEW FORM</a>\r\n"
				+ "	<a href=\"/servlet/employees\">LIST</a>\r\n"
				+ "</body>\r\n"
				+ "</html>"
				);

	}
	
}
