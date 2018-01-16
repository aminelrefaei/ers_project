package com.revature.model;

/* Main Employee POJO (bean) needed for example */
public class Employee{
	private int employeeid;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String loginPassword;
	
	public Employee() {
		this.firstName = "";
		this.lastName = "";
		this.emailAddress = "";
		this.loginPassword = "";
	}

	public Employee(int employeeid) {
		this();
		this.employeeid = employeeid;
	}
	
	public Employee(String emailAddress) {
		this();
		this.emailAddress = emailAddress;
	}
	
	public Employee(String emailAddress, String loginPassword) {
		this();
		this.firstName = "test";
		this.lastName = "testlast";
		this.emailAddress = emailAddress;
		this.loginPassword = loginPassword;
	}
	
	public Employee(int employeeid, String firstName, String lastName, String emailAddress, String loginPassword) {
		this();
		this.employeeid = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.loginPassword = loginPassword;
	}

	public int getEmployeeId() {
		return employeeid;
	}
	
	public void setId(int employeeid) {
		this.employeeid = employeeid;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	public int getRoleTypeId() {
		return getRoleTypeId();
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + "firstName=" + firstName + ", lastName=" + lastName + ", emailaddress=" + emailAddress + ", loginpassword="
				+ loginPassword + "]";
	}
}
