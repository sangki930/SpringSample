package com.example.mvc.v5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.example.mvc.v3.FrontControllerV3;
import com.example.mvc.v3.MyModelAndView;
import com.example.mvc.v4.FrontControllerV4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class V4HandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean support(Object handler) {
		// TODO Auto-generated method stub
		return handler instanceof MyHandlerAdapter;
	}

	@Override
	public MyModelAndView handler(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws ServletException, IOException {
		FrontControllerV4 controller = (FrontControllerV4) handler;
		
		Map<String, String> paramMap = new HashMap<>();
		req.getParameterNames().asIterator().forEachRemaining(
				paramName -> paramMap.put(paramName, req.getParameter(paramName))
				);
		
		Map<String, Object> model = new HashMap<>();
		String viewName = controller.service(paramMap, model);
		
		MyModelAndView mav = new MyModelAndView(viewName);
		mav.setModel(model);
		return mav;
	}

}
