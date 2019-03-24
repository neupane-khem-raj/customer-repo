package com.EmployeeRecord.EmployeeRecord.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EmployeeRecord.EmployeeRecord.domain.AddTaskRepository;
import com.EmployeeRecord.EmployeeRecord.domain.DepartmentRepository;
import com.EmployeeRecord.EmployeeRecord.domain.EmployeeRepository;
import com.EmployeeRecord.EmployeeRecord.domain.StartJobRepository;

@Controller
public class EmployeeController {
	@Autowired
	private AddTaskRepository addtaskrepo;
	@Autowired
	private DepartmentRepository deparementrepo;
	@Autowired
	private EmployeeRepository employeerepo;
	@Autowired
	private StartJobRepository startjobrepo;
	
	@RequestMapping(value ="/employeeList")
	public String employeeRecord(Model model) {
	model.addAttribute("employees", employeerepo.findAll());
		return "employeeList";
	}
}
