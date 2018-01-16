package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class NewRequestController {

	public static String newRequest(HttpServletRequest request) {
		
		
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		int empId = loggedEmployee.getEmployeeId();
		int reqTotal = Integer.parseInt(request.getParameter("total"));
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		
		Request req = new Request(empId, reqTotal, description,status);
		
		EmployeeService.getEmployeeService().insertRequest(req);
				
		request.getParameter("");
		
		return "employeePendingRequests.jsp";
	}
}
