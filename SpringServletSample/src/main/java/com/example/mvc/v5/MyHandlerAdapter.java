package com.example.mvc.v5;

import java.io.IOException;

import com.example.mvc.v3.MyModelAndView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

	public boolean support(Object handler);
	
	public MyModelAndView handler(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException;

}
