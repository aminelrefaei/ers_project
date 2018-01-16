package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class ViewAllPendingRequestsController {

	public static String viewPendingRequests(HttpServletRequest request) {
		List<Request> reqs = EmployeeService.listAllPendingRequests();
		request.setAttribute("requestsList", reqs);
		return "allResolvedRequests.jsp";
	}
}
