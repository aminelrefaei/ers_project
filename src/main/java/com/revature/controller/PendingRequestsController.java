package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class PendingRequestsController {

	public static String pendingRequests(HttpServletRequest request) {
		System.out.println("Entering Pending Controller.....");
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");	
		System.out.println(loggedEmployee.getFirstName());
		
		
		List<Request> reqs = EmployeeService.getPending(loggedEmployee);
		request.getSession().setAttribute("requestList", reqs);
		for (Request req : reqs) {
			//System.out.println(req.getDescription());
		}
		return "employeePendingRequests.jsp";
	}
}
