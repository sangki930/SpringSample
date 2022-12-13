package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/employees")
public class EmployeeListServlet extends HttpServlet{

	private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
	
	// ALT + SHIFT + v
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		List<Employee> employeeList = employeeRepository.findAll();
		PrintWriter writer = resp.getWriter();
	
		writer.write("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>LIST</h1>\r\n"
				+ "	<table>\r\n"
				+ "		<thead>\r\n"
				+ "			<tr>ID</tr>\r\n"
				+ "			<tr>EMPNO</tr>\r\n"
				+ "			<tr>NAME</tr>\r\n"
				+ "			<tr>TEAM</tr>\r\n"
				+ "		</thead>\r\n"
				+ "		<tbody>\r\n");
				
				for(Employee e : employeeList) {
					writer.write("			<tr>\r\n"
							+ "				<td>"+e.getId()+"</td>\r\n"
							+ "				<td>"+e.getEmpno()+"</td>\r\n"
							+ "				<td>"+e.getName()+"</td>\r\n"
							+ "				<td>"+e.getTeam()+"</td>\r\n"
							+ "			</tr>\r\n");
				}
				
				writer.write(
				 "		</tbody>\r\n"
				+ "	</table>\r\n"
				+ "	<a href=\"/servlet/employees/new-form\">NEW</a>\r\n"
				+ "	\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
