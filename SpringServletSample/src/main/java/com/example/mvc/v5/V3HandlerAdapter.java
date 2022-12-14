package com.example.mvc.v5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.example.mvc.v3.FrontControllerV3;
import com.example.mvc.v3.MyModelAndView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class V3HandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean support(Object handler) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MyModelAndView handler(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws ServletException, IOException {
FrontControllerV3 controller = (FrontControllerV3) handler;
		
		Map<String, String> ParamMap = new HashMap<>();
		req.getParameterNames().asIterator().forEachRemaining(
				paramName->ParamMap.put(paramName, req.getParameter(paramName))
				);
		
		return controller.service(ParamMap);
	}

}
