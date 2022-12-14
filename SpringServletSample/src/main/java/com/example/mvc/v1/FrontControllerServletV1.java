package com.example.mvc.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@WebServlet(urlPatterns = "/v1/*")
@Log4j2
public class FrontControllerServletV1 extends HttpServlet{

	private Map<String,FrontControllerV1> requestMapping = new HashMap<>();
	
	public FrontControllerServletV1() {
		requestMapping.put("/v1/employees/new-form", new EmployeeNewControllerV1());
		requestMapping.put("/v1/employees/save", new EmployeeSaveControllerV1());
		requestMapping.put("/v1/employees", new EmployeeListControllerV1());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		log.info("{}",requestMapping.size());
		
		
		FrontControllerV1 controller = requestMapping.get(req.getRequestURI());
		controller.service(req, resp);
	}

}
