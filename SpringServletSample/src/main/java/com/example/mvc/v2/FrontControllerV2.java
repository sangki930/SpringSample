package com.example.mvc.v2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FrontControllerV2 {

	public MyView service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
