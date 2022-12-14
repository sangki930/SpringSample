package com.example.mvc.v3;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyModelAndView {

	private String viewName;
	private Map<String,Object> model = new HashMap<>();
	
	public MyModelAndView(String viewName) {
		this.viewName = viewName;
	}
	
	public MyModelAndView(String viewName, Map<String, Object> model) {
		this.viewName = viewName;
		this.model = model;
	}
	
}
