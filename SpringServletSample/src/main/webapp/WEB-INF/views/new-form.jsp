<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>NEW FORM</h1>
	<form action="save" method="post">
	empno: <input type="text" name="empno"><br>
	name: <input type="text" name="name"><br>
	team: <input type="text" name="team"><br>
	<button type="submit">전송</button>
	</form>
	<a href="../employees">LIST</a>
</body>
</html>