package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Employee;
import com.example.repository.EmployeeJpaRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	@RequestMapping("/spring/employees/new-form")
	public String employeeNew() {
		return "new-form";
	}
	
	@PostMapping("/spring/employees/save")
	public ModelAndView employeeSave(
			@RequestParam("empno") String empno,
			@RequestParam("name") String name,
			@RequestParam("team") String team
			) {
		Employee employee = new Employee(empno, name, team);
		Employee savdEmployee = employeeJpaRepository.save(employee);
		
		ModelAndView mav = new ModelAndView();
		
		mav.getModel().put("employee", savdEmployee);
		mav.setViewName("save");
		
		return mav;
	}
	
	@GetMapping("/spring/employees")
	public String employeeList(Model model) {
		
		model.addAttribute("employees",employeeJpaRepository.findAll());
		return "list";
	}
}
