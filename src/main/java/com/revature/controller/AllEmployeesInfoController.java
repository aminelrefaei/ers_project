package com.revature.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class AllEmployeesInfoController {
	
	public static String empsInfo(HttpServletRequest request) {
		List <Employee> emp = EmployeeService.getEmployeeService().listAllUsers();
		request.setAttribute("employeeList", emp);
		return "empInfo.jsp";
	}

}
