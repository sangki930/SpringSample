package com.example.mvc.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@WebServlet(urlPatterns = "/v3/*")
@Log4j2
public class FrontControllerServletV3 extends HttpServlet{

	private Map<String,FrontControllerV3> requestMapping = new HashMap<>();
	
	public FrontControllerServletV3() {
		requestMapping.put("/v3/employees/new-form", new EmployeeNewControllerV3());
		requestMapping.put("/v3/employees/save", new EmployeeSaveControllerV3());
		requestMapping.put("/v3/employees", new EmployeeListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FrontControllerV3 controller = requestMapping.get(req.getRequestURI());
		
		// 1. req-> getParameter -> HashMap paramMap
		Map<String,String> paramMap = new HashMap<>();
		
//		Enumeration<String> paramNames = req.getAttributeNames();
//		while(paramNames.hasMoreElements()) {
//			String paramName = paramNames.nextElement();
//			paramMap.put(paramName, req.getParameter(paramName));
//		}
		
		
//		System.out.println("TEST==>"+req.getParameter("empno"));
		// Java 8 이후
		req.getParameterNames().asIterator().forEachRemaining(
				paramName->paramMap.put(paramName, req.getParameter(paramName))
				);
		// controller 실행 -> ModelAndView를 받음
		MyModelAndView mav = controller.service(paramMap);
		
		// viewResolver (viewName -> viewPath)
		MyView view = viewResolver(mav.getViewName());
		
		// view.render
		view.render(mav.getModel(), req, resp);
		
	}
	
	private MyView viewResolver(String viewName) {
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		return new MyView(prefix+viewName+suffix);
	}

}
