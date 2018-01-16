package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.util.FinalUtil;

/* Class that executes business logic related to employees */
public class EmployeeService {

	/*Singleton transformation of Employee Service object */
	private static EmployeeService employeeService;
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeService();
		}
		
		return employeeService;
	}
	
	/* Calls the insert method of the DAO */
	public boolean insertRequest(Request request) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insert(request);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Employee> listAllUsers() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectAll();
	}
	
	/* Calls select method of the DAO by username and performs login logic */
	public Employee login(Employee employee) {
		System.out.println("LOGIN FUNCTION ENTERED");
		System.out.println(employee);
		Employee loggedEmployee = EmployeeDaoJdbc.getEmployeeDaoJdbc().select(employee);
        System.out.println(loggedEmployee);

        if(loggedEmployee.getLoginPassword().equals(employee.getLoginPassword())) {
            return loggedEmployee;
        }
        
        return new Employee();
	}
	
	/* Calls the whichHome method of the DAO, employee is a manager, return true. If not, return false */
	public boolean isManager(Employee employee) {    
        return EmployeeDaoJdbc.getEmployeeDaoJdbc().whichHome(employee);
    }
	
	public Employee infor(Employee employee) {
		Employee loggedEmployee = EmployeeDaoJdbc.getEmployeeDaoJdbc().select(employee);
		System.out.println(loggedEmployee);
        if(loggedEmployee.getLoginPassword().equals(employee.getLoginPassword())) {
            return loggedEmployee;
        }
        
        return new Employee();
		
	}
	
	public Employee info(Employee employee) {
		System.out.println("LOGIN FUNCTION ENTERED");
		System.out.println(employee);
		Employee loggedEmployee = EmployeeDaoJdbc.getEmployeeDaoJdbc().selectOne(employee);
        System.out.println(loggedEmployee);

        if(loggedEmployee.getLoginPassword().equals(employee.getLoginPassword())) {
            return loggedEmployee;
        }
        
        return new Employee();
	}
	
	public static List<Request> listAllPendingRequests() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getPendingRequests();
	}
	
	public static List<Request> getPending(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getPendingRequests(employee);

}
	public static List<Request> getResolved(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getResolvedRequests(employee);

}
	public static List<Request> listAllResolvedRequests() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getResolvedRequests();
	}
}
