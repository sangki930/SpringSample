<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>SUCCESS!</h1>
	<ul>
	<li>id=${employee.id}</li>
	<li>empno=${employee.empno}</li>
	<li>name=${employee.name}</li>
	<li>team=${employee.team}</li>
	</ul>
	<a href="new-form">NEW FORM</a>
	<a href="../employees">LIST</a>
</body>
</html>