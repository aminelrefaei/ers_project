package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class ViewAllResolvedRequestsController {

	public static String viewResolvedRequests(HttpServletRequest request) {
		List<Request> reqs = EmployeeService.listAllResolvedRequests();
		request.setAttribute("requestsList", reqs);
		return "allResolvedRequests.jsp";
	}
}
