package com.my.spring.web.ch04.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.spring.web.ch04.domain.Employee;
import com.my.spring.web.ch04.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("ch04/employee/{employeeId}")
	public String getEmployee(@PathVariable int employeeId, Model model) {//모델은 핸들러 내부에서 
		Employee employee = employeeService.getEmployee(employeeId); //서비스에서 얻어온다.
		model.addAttribute("employee", employee);
		
		return "ch04/employee";
	}
}
