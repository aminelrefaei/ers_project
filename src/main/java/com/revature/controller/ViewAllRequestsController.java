package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class ViewAllRequestsController {

	public static String viewRequests(HttpServletRequest request) {
			List <Request> reqs = EmployeeService.listAllPendingRequests();
			request.setAttribute("requestsList", reqs);
		return "AllPendingRequests.jsp";
	}
	}

