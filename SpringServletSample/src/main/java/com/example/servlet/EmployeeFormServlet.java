package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 최신 Servlet과 SpringBoot로 비교적 간단하게 Servlet개발이 가능함
 * web.xml에 mapping과정으로 했으나, @WebServlet으로 스캔하여 대신해줌
 * eclipe 단축키 : clt+shift+o -> 자동 import
*/
@WebServlet(urlPatterns="/servlet/employees/new-form")
public class EmployeeFormServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(
				"""
					<!DOCTYPE html>
					<html>
					<head>
					<meta charset="UTF-8">
					<title>Servlet</title>
					</head>
					<body>
						<h1>NEW FORM</h1>
						<form action="/servlet/employees/save" method="post">
						empno: <input type="text" name="empno"><br>
						name: <input type="text" name="name"><br>
						team: <input type="text" name="team"><br>
						<button type="submit">전송</button>
						</form>
						<a href="/servlet/employees">LIST</a>
					</body>
					</html>
				"""
				);
		
	}


//	//eclipe 단축키 : alt+shit+s -> Override/Implement Methods -> service() 선택 (protected)
//	//Servlet lifecycle : init() -> service() -> doGet, doPost... -> distroy() 
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		/*
//		 * Servlet은 response로 html와 같이 html문서를 전달할수도, json, image, file등과 같은 데이터도 전달가능
//		 * 초창기 servlet 프로그래밍 시절엔 html을 만들어 보냄  
//		 */
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("utf-8");
//		PrintWriter writer = resp.getWriter();
//		
//		writer.write(
//				"<!DOCTYPE html>\r\n"
//				+ "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<meta charset=\"UTF-8\">\r\n"
//				+ "<title>Servlet</title>\r\n"
//				+ "</head>\r\n"
//				+ "<body>\r\n"
//				+ "	<h1>NEW FORM</h1>\r\n"
//				+ "	<form action=\"/servlet/employees/save\" method=\"post\">\r\n"
//				+ "	empno: <input type=\"text\" name=\"empno\"><br>\r\n"
//				+ "	name: <input type=\"text\" name=\"name\"><br>\r\n"
//				+ "	team: <input type=\"text\" name=\"team\"><br>\r\n"
//				+ "	<button type=\"submit\">전송</button>\r\n"
//				+ "	</form>\r\n"
//				+ "	<a href=\"/servlet/employees\">LIST</a>\r\n"
//				+ "</body>\r\n"
//				+ "</html>"
//				);
//		
//	}
		
}
