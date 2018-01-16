package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeInfoController {

	public static String info(HttpServletRequest request) {
		
		return "currentEmployeeInfo.jsp";
	}
	
	
}
