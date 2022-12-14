package com.example.mvc.v4;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyView {

	private String viewPath;

	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}
	
	public void render(Map<String,Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		for(String keyName : model.keySet()) {
//			req.setAttribute(keyName, model.get(keyName));
//		}
		
		model.forEach((key,value)->req.setAttribute(key, value));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
	
}
