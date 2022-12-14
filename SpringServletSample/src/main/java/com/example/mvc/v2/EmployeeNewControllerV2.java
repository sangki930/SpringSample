package com.example.mvc.v2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeNewControllerV2 implements FrontControllerV2{

	@Override
	public MyView service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return new MyView("/WEB-INF/views/new-form.jsp");
	}

}
