package com.example.mvc.v4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@WebServlet(urlPatterns = "/v4/*")
@Log4j2
public class FrontControllerServletV4 extends HttpServlet{

	private Map<String,FrontControllerV4> requestMapping = new HashMap<>();
	
	public FrontControllerServletV4() {
		requestMapping.put("/v4/employees/new-form", new EmployeeNewControllerV4());
		requestMapping.put("/v4/employees/save", new EmployeeSaveControllerV4());
		requestMapping.put("/v4/employees", new EmployeeListControllerV4());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FrontControllerV4 controller = requestMapping.get(req.getRequestURI());
		
		// 1. req-> getParameter -> HashMap paramMap
		Map<String,String> paramMap = new HashMap<>();
		
//		Enumeration<String> paramNames = req.getAttributeNames();
//		while(paramNames.hasMoreElements()) {
//			String paramName = paramNames.nextElement();
//			paramMap.put(paramName, req.getParameter(paramName));
//		}
		
		// Java 8 이후
		req.getParameterNames().asIterator().forEachRemaining(
				paramName->paramMap.put(paramName, req.getParameter(paramName))
				);
		log.info(paramMap);
		Map<String,Object> model = new HashMap<>();
		
		// controller 실행 -> ModelAndView를 받음
		String viewName = controller.service(paramMap,model);
		log.info(model.toString());
		// viewResolver (viewName -> viewPath)
		MyView view = viewResolver(viewName);
		
		// view.render
		view.render(model,req,resp);
		
	}
	
	private MyView viewResolver(String viewName) {
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		return new MyView(prefix+viewName+suffix);
	}

}
