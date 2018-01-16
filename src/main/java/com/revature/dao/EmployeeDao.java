package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Request;

/* Contract interface that uses DAO design pattern rules that can be implemented
 * by many types of technologies like JDBC, Hibernate, MongoDB, etc.
 */
public interface EmployeeDao {
	public boolean insert(Request request);
	public Employee select(Employee employee);
	public List<Employee> selectAll();
	public boolean whichHome(Employee employee);
}
