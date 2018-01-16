package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class AjaxPendingRequestsController {

	public static Object getPendingRequest(HttpServletRequest request, HttpServletResponse response) {		
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM reimbursement WHERE employeeId=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, loggedEmployee.getEmployeeId());
			ResultSet result = statement.executeQuery();

			List<Request> requestList = new ArrayList<>();
			while (result.next()) {
				requestList.add(new Request
						(result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getInt("TOTAL"),
						result.getString("DESCRIPTION"),
						result.getString("STATUS"),
						result.getInt("RESOLVEDBY")));
			}

			return requestList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all requests from the logged emp", e);
		}
		return new ArrayList<>();
		
	}

}