package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class ResolvedRequestsController {

	public static String resolvedRequests(HttpServletRequest request) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");

		List<Request> reqs = EmployeeService.getResolved(loggedEmployee);
		request.getSession().setAttribute("requestList", reqs);
		for (Request req : reqs) {
			System.out.println(req.getDescription());
		}
		return "employeeResolvedRequests.jsp";
	}
}
