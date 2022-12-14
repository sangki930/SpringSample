package com.example.mvc.v3;

import java.util.Map;

public class EmployeeNewControllerV3 implements FrontControllerV3{

	@Override
	public MyModelAndView service(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return new MyModelAndView("new-form");
	}

	

}
