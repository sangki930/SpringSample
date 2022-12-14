package com.example.mvc.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@WebServlet(urlPatterns = "/v2/*")
@Log4j2
public class FrontControllerServletV2 extends HttpServlet{

	private Map<String,FrontControllerV2> requestMapping = new HashMap<>();
	
	public FrontControllerServletV2() {
		requestMapping.put("/v2/employees/new-form", new EmployeeNewControllerV2());
		requestMapping.put("/v2/employees/save", new EmployeeSaveControllerV2());
		requestMapping.put("/v2/employees", new EmployeeListControllerV2());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FrontControllerV2 controller = requestMapping.get(req.getRequestURI());
		MyView view = controller.service(req, resp);
		view.render(req, resp);
	}

}
