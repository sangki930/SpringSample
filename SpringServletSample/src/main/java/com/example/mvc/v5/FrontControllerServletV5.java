package com.example.mvc.v5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.mvc.v3.EmployeeListControllerV3;
import com.example.mvc.v3.EmployeeNewControllerV3;
import com.example.mvc.v3.EmployeeSaveControllerV3;
import com.example.mvc.v3.MyModelAndView;
import com.example.mvc.v3.MyView;
import com.example.mvc.v4.EmployeeListControllerV4;
import com.example.mvc.v4.EmployeeNewControllerV4;
import com.example.mvc.v4.EmployeeSaveControllerV4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

	private Map<String, Object> requestMapping = new HashMap<>();
	private List<MyHandlerAdapter> handlerAdapterList = new ArrayList<>();
	
	public FrontControllerServletV5() {
		requestMapping.put("/v5/employees/new-form", new EmployeeNewControllerV3());
		requestMapping.put("/v5/employees/save", new EmployeeSaveControllerV3());
		requestMapping.put("/v5/employees", new EmployeeListControllerV3());
		handlerAdapterList.add(new V3HandlerAdapter());
		
		requestMapping.put("/v5/employees/new-form", new EmployeeNewControllerV4());
		requestMapping.put("/v5/employees/save", new EmployeeSaveControllerV4());
		requestMapping.put("/v5/employees", new EmployeeListControllerV4());
		handlerAdapterList.add(new V4HandlerAdapter());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object handler = requestMapping.get(req.getRequestURI());
		MyHandlerAdapter handlerAdapter = null;
		for(MyHandlerAdapter myHandlerAdapter : handlerAdapterList) {
			if(myHandlerAdapter.support(handler)) {
				handlerAdapter = myHandlerAdapter;
			}
		}
		
		MyModelAndView mav = handlerAdapter.handler(req, resp, handler);
		MyView view = viewResolver(mav.getViewName());
		view.render(req, resp);
	}

	
	private MyView viewResolver(String viewName) {
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		return new MyView(prefix+viewName+suffix);
	}
}
