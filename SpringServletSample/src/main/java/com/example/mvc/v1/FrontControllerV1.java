package com.example.mvc.v1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FrontControllerV1 {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
