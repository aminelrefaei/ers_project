package com.revature.controller;

import javax.servlet.http.HttpServletRequest;


import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;

public class LoginController {

	public static String login(HttpServletRequest request) {

		// If it's a GET we just return the view.
		if (request.getMethod().equals(FinalUtil.HTTP_GET)) {
			return "loginpage.html";
		}

		// POST logic
		Employee loggedEmployee = EmployeeService.getEmployeeService().login(
				new Employee(
						request.getParameter("email"), 
						request.getParameter("password")
				));
		System.out.println("LOGIN CONTROLLER: " + loggedEmployee);
		
		request.setAttribute("loggedEmployee", loggedEmployee);
		
		// Wrong Credentials
		if (loggedEmployee.getEmailAddress().equals("")) {
			return "loginpage.html";
		} else {
		
			request.getSession().setAttribute("loggedEmployee", loggedEmployee);

			
			Employee logged = (Employee) request.getSession().getAttribute("loggedEmployee");
			
			System.out.println("Parameters(email and password from form): " + request.getParameter("email") +":" + request.getParameter("password"));
			boolean loggedEmployee1 = EmployeeService.getEmployeeService().isManager(logged);

			if (loggedEmployee1 == true) {
				return "managerHome.jsp";
			} else
				return "employeeHome.jsp";
		}
		}
	}

