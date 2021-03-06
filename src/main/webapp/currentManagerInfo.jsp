<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<a href="managerHome.jsp" class="btn btn-primary" role="button">Home</a>
<a href="empsInfo.do" class="btn btn-primary" role="button">View Employees</a>
<a href="viewPendingRequests.do" class="btn btn-primary" role="button">View Pending Reimbursement Requests</a>
<a href="viewResolvedRequests.do" class="btn btn-primary" role="button">View Resolved Reimbursement Requests</a>
<a href="logOut.do" class="btn btn-primary" role="button">Logout</a>
</head>

<body>
	<div class="col-lg-10 col-lg-offset-1">
		<div class="employee-table-title">
			<h2>My Information</h2>
		</div>
		<div id="employee-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Address</th>
						<th>Password</th>
					</tr>
				</thead>

				<tbody>
						<tr>
							<td><c:out value="${loggedEmployee.employeeId}"></c:out></td>
							<td><c:out value="${loggedEmployee.firstName}"></c:out></td>
							<td><c:out value="${loggedEmployee.lastName}"></c:out></td>
							<td><c:out value="${loggedEmployee.emailAddress}"></c:out></td>
							<td><c:out value="${loggedEmployee.loginPassword}"></c:out></td> 
						</tr>
			
				</tbody>
			</table>
			<a href="updateInfo.do" class="btn btn-primary" role="button">Update info</a>
		</div>

	</div>
</body>
</html>
