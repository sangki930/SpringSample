<%@page import="com.example.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.example.repository.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
	List<Employee> employees = employeeRepository.findAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>LIST</h1>
		<table>
			<thead>
				<th>ID</th>
				<th>EMPNO</th>
				<th>NAME</th>
				<th>TEAM</th>
			</thead>
			<tbody>
				<% for(Employee e : employees) {
					// out.write("<tr>");
				%>
				<tr>
					<td><%=e.getId()%></td>
					<td><%=e.getEmpno()%></td>
					<td><%=e.getName()%></td>
					<td><%=e.getTeam()%></td>
				</tr>
				<% }%>
			</tbody>
		</table>
	<a href="/jsp/employees/new-form.jsp">NEW</a>
</body>
</html>