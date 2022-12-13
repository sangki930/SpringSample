<%@page import="com.example.entity.Employee"%>
<%@page import="com.example.repository.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmployeeRepository employeeRepository = EmployeeRepository.getInstance();

	String empno = request.getParameter("empno");
	String name = request.getParameter("name");
	String team = request.getParameter("team");
	Employee employee = new Employee(empno,name,team);
	Employee savedEmployee = employeeRepository.save(employee);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SUCCESS!</h1>
	<ul>
	<li>id=<%=savedEmployee.getId()%></li>
	<li>empno=<%=savedEmployee.getEmpno()%></li>
	<li>name=<%=savedEmployee.getName()%></li>
	<li>team=<%=savedEmployee.getTeam()%></li>
	</ul>
	<a href="/jsp/employees/new-form.jsp">NEW FORM</a>
	<a href="/jsp/employees/list.jsp">LIST</a>
</body>
</html>