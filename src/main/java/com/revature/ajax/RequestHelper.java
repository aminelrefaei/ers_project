package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AjaxPendingRequestsController;
import com.revature.controller.InvalidLoginController;
import com.revature.util.FinalUtil;

/* Request helper specifically for AJAX requests */
public class RequestHelper {

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {
//		case "/ers_project/checkUsername.ajax":
//			return CheckUsernameController.checkUsername(request, response);
		case "/ers_project/newPendingRequest.ajax":
			return AjaxPendingRequestsController.getPendingRequest(request, response);
		default:
			return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
