//package com.revature.controller;
//
//import java.util.List;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.revature.model.Employee;
//import com.revature.model.Request;
//import com.revature.service.EmployeeService;
//
//public class AllRequestsController {
//	
//	public static String requestsInfo(HttpServletRequest request) {
//		List <Request> reqs = EmployeeService.listAllRequests();
//		request.setAttribute("requestsList", reqs);
//		return "empInfo.jsp";
//	}
//
//}
