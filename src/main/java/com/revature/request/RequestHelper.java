package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.AllEmployeesInfoController;
import com.revature.controller.EmployeeInfoController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.LogoutController;
import com.revature.controller.ManagerInfoController;
import com.revature.controller.NewRequestController;
import com.revature.controller.PendingRequestsController;
import com.revature.controller.ResolvedRequestsController;
import com.revature.controller.UpdateInfoController;
import com.revature.controller.ViewAllPendingRequestsController;
import com.revature.controller.ViewAllRequestsController;
import com.revature.controller.ViewAllResolvedRequestsController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/ers_project/login.do":
			return LoginController.login(request);
		case "/ers_project/home.do":
			return HomeController.home(request);
		case "/ers_project/logOut.do":
			return LogoutController.logOut(request);
		case "/ers_project/newRequest.do":
			return NewRequestController.newRequest(request);
		case "/ers_project/empsInfo.do":
			return AllEmployeesInfoController.empsInfo(request);
		case "/ers_project/info.do":
			return EmployeeInfoController.info(request);
		case "/ers_project/managerInfo.do":
			return ManagerInfoController.managerInfo(request);
		case "/ers_project/viewRequests.do":
			return ViewAllRequestsController.viewRequests(request);
		case "/ers_project/updateInfo.do":
			return UpdateInfoController.updateInfo(request);
		case "/ers_project/employeePendingRequests.do":
			return PendingRequestsController.pendingRequests(request);
		case "/ers_project/employeeResolvedRequests.do":
			return ResolvedRequestsController.resolvedRequests(request);
		case "/ers_project/viewResolvedRequests.do":
			return ViewAllResolvedRequestsController.viewResolvedRequests(request);
		case "/ers_project/viewPendingRequests.do":
			return ViewAllPendingRequestsController.viewPendingRequests(request);
			

		default:
			return "404.jsp";
		}
	}
}
