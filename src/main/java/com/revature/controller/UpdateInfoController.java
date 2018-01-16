package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class UpdateInfoController {

	public static String updateInfo(HttpServletRequest request) {
		
		if (request.getMethod().equals("GET")) {
			return "updateInfo.jsp";
		}
		
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			int statementindex = 0;
			String command = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, EMAILADDRESS = ?, LOGINPASSWORD = ? WHERE EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			System.out.println("yerrrrrrrrr");
			statement.setString(++statementindex, firstname);
			statement.setString(++statementindex, lastname);
			statement.setString(++statementindex, email);
			statement.setString(++statementindex, password);
			statement.setInt(++statementindex, loggedEmployee.getEmployeeId());
			
			statement.executeUpdate();
			System.out.println("Information Updated!");
			
			String command2 = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			PreparedStatement statement2 = connection.prepareStatement(command2);
			statement2.setInt(1, loggedEmployee.getEmployeeId());
			ResultSet result = statement2.executeQuery();
			
			while(result.next()) {
				Employee updatedEmployee = new Employee(
						result.getInt("EMPLOYEEID"),
						result.getString("FIRSTNAME"),
						result.getString("LASTNAME"),
						result.getString("EMAILADDRESS"),
						result.getString("LOGINPASSWORD")
						
						);
				request.getSession().setAttribute("loggedEmployee", updatedEmployee);
				
			}
			
			
			return "updateInfo.jsp";
			
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}
		System.out.println("Failed to update information, redirecting..");
		return "updateInfo.jsp";
	}
}
