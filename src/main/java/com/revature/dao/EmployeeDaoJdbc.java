package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for Employees data access */
public class EmployeeDaoJdbc implements EmployeeDao {

	/* Singleton transformation of JDBC implementation object */
	private static EmployeeDaoJdbc employeeDaoJdbc;

	private EmployeeDaoJdbc() {

	}

	public static EmployeeDaoJdbc getEmployeeDaoJdbc() {
		if (employeeDaoJdbc == null) {
			employeeDaoJdbc = new EmployeeDaoJdbc();
		}

		return employeeDaoJdbc;
	}

	 /* Regular insert statement for Employee */
	@Override
	 public boolean insert(Request request) {
	 try(Connection connection = ConnectionUtil.getConnection()) {
	 int statementIndex = 0;
	 String command = "INSERT INTO REIMBURSEMENT (EMPLOYEEID, TOTAL ,DESCRIPTION, STATUS, RESOLVEDBY) VALUES(?,?,?,?,?)";
	
	 PreparedStatement statement = connection.prepareStatement(command);
	
	 //Set attributes to be inserted
	 statement.setInt(++statementIndex, request.getEmployeeId());
	 statement.setInt(++statementIndex, request.getTotal());
	 statement.setString(++statementIndex, request.getDescription());
	 statement.setString(++statementIndex, request.getStatus());
	 statement.setInt(++statementIndex, request.getResolvedBy());
	
	 if(statement.executeUpdate() > 0) {
	 return true;
	 }
	 } catch (SQLException e) {
	 LogUtil.logger.warn("Exception creating a new employee", e);
	 }
	 return false;
	 }
	
	/* Select Employee based on his username */
	@Override
	public Employee select(Employee employee) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			System.out.println(employee);
			String command = "SELECT * FROM EMPLOYEE WHERE EMAILADDRESS = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, employee.getEmailAddress());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				return new Employee(result.getInt("EMPLOYEEID"), result.getString("FIRSTNAME"),
						result.getString("LASTNAME"), result.getString("EMAILADDRESS"),
						result.getString("LOGINPASSWORD"));
			}

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a employee", e);
		}
		return new Employee();
	}

	@Override
	public boolean whichHome(Employee employee) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			System.out.println(employee);
			String command = "SELECT employeerole.roletypeid from employee inner join employeerole on employee.employeeid = employeerole.employeeid WHERE employee.employeeid = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, employee.getEmployeeId());
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				System.out.println("ROLETYPEID: " + result.getInt(1));
				if (result.getInt("roletypeid") == 2) {
					return true;
				}
			}

		} catch (SQLException e) {
			StackTraceElement e1;
		}
		return false;
	}


	/* Select all employees */
	public List<Employee> selectAll() {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM EMPLOYEE";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Employee> employeeList = new ArrayList<>();
			while (result.next()) {
				employeeList.add(new Employee(result.getInt("EMPLOYEEID"), result.getString("FIRSTNAME"),
						result.getString("LASTNAME"), result.getString("EMAILADDRESS"),
						result.getString("LOGINPASSWORD")));
			}

			return employeeList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}
		return new ArrayList<>();
	}

	public Employee selectOne(Employee employee) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			System.out.println(employee);
			String command = "SELECT * FROM EMPLOYEE WHERE EMAILADDRESS = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, employee.getEmailAddress());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				return new Employee(result.getInt("EMPLOYEEID"), result.getString("FIRSTNAME"),
						result.getString("LASTNAME"), result.getString("EMAILADDRESS"),
						result.getString("LOGINPASSWORD"));
			}

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a employee", e);
		}
		return new Employee();
	}

	public List<Request> getPendingRequests() {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS='Pending'";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Request> requestList = new ArrayList<>();
			while (result.next()) {
				requestList.add(new Request(result.getInt("TICKETID"), result.getInt("EMPLOYEEID"),
						result.getInt("TOTAL"), result.getString("DESCRIPTION"), result.getString("STATUS"),
						result.getInt("RESOLVEDBY")));
			}

			return requestList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}
		return new ArrayList<>();
	}

	public List<Request> getResolvedRequests() {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS='Approved'OR STATUS='Denied'";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Request> requestList = new ArrayList<>();
			while (result.next()) {
				requestList.add(new Request(result.getInt("TICKETID"), result.getInt("EMPLOYEEID"),
						result.getInt("TOTAL"), result.getString("DESCRIPTION"), result.getString("STATUS"),
						result.getInt("RESOLVEDBY")));
			}

			return requestList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}
		return new ArrayList<>();
	}

	public List<Request> getPendingRequests(Employee employee) {
		System.out.println("getting connection");
		try (Connection connection = ConnectionUtil.getConnection()) {
			System.out.println();
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS='Pending' AND EMPLOYEEID=?";
			PreparedStatement statement = connection.prepareStatement(command);
			System.out.println("yerrrrrrrrr");
			statement.setInt(1, employee.getEmployeeId());
			ResultSet result = statement.executeQuery();

			List<Request> requestList = new ArrayList<>();
			while (result.next()) {
				requestList.add(new Request(result.getInt("TICKETID"), result.getInt("EMPLOYEEID"),
						result.getInt("TOTAL"), result.getString("DESCRIPTION"), result.getString("STATUS"),
						result.getInt("RESOLVEDBY")));
			}

			return requestList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}
		return new ArrayList<>();
	}

	public List<Request> getResolvedRequests(Employee employee) {
		System.out.println("getting connection");
		try (Connection connection = ConnectionUtil.getConnection()) {
			System.out.println();
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS='Approved'OR STATUS='Denied' AND EMPLOYEEID=?";
			PreparedStatement statement = connection.prepareStatement(command);
			System.out.println("yerrrrrrrrr");
			statement.setInt(1, employee.getEmployeeId());
			ResultSet result = statement.executeQuery();

			List<Request> requestList = new ArrayList<>();
			while (result.next()) {
				requestList.add(new Request(result.getInt("TICKETID"), result.getInt("EMPLOYEEID"),
						result.getInt("TOTAL"), result.getString("DESCRIPTION"), result.getString("STATUS"),
						result.getInt("RESOLVEDBY")));
			}

			return requestList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}
		return new ArrayList<>();
	}
}
