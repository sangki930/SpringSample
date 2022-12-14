<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
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
				<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.empno}</td>
					<td>${employee.name}</td>
					<td>${employee.team}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="employees/new-form">NEW</a>
</body>
</html>