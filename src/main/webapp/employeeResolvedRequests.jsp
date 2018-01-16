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

<a href="employeeHome.jsp" class="btn btn-primary" role="button">Home</a>
<a href="info.do" class="btn btn-primary" role="button">My Info</a>
<a href="employeePendingRequests.do" class="btn btn-primary" role="button">Pending Reimbursement Requests</a>
<a href="logOut.do" class="btn btn-primary" role="button">Logout</a>
</head>

<body>
	<div class="col-lg-10 col-lg-offset-1">
		<div class="employee-table-title">
			<h2>My Resolved Requests</h2>
		</div>
		<div id="employee-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Ticket ID</th>
						<th>Employee ID</th>
						<th>Total</th>
						<th>Description</th>
						<th>Status</th>
						<th>Resolved By</th>
					</tr>
				</thead>

				<tbody>

					<tr>
						<td><c:out value="${requestList[0].ticketId}"></c:out></td>
						<td><c:out value="${requestList[0].employeeId}"></c:out></td>
						<td><c:out value="${requestList[0].total}"></c:out></td>
						<td><c:out value="${requestList[0].description}"></c:out></td>
						<td><c:out value="${requestList[0].status}"></c:out></td>
						<td><c:out value="${requestList[0].resolvedBy}"></c:out></td>
					<tr>
						<td><c:out value="${requestList[1].ticketId}"></c:out></td>
						<td><c:out value="${requestList[1].employeeId}"></c:out></td>
						<td><c:out value="${requestList[1].total}"></c:out></td>
						<td><c:out value="${requestList[1].description}"></c:out></td>
						<td><c:out value="${requestList[1].status}"></c:out></td>
						<td><c:out value="${requestList[1].resolvedBy}"></c:out></td>
					</tr>
					<tr>
						<td><c:out value="${requestList[2].ticketId}"></c:out></td>
						<td><c:out value="${requestList[2].employeeId}"></c:out></td>
						<td><c:out value="${requestList[2].total}"></c:out></td>
						<td><c:out value="${requestList[2].description}"></c:out></td>
						<td><c:out value="${requestList[2].status}"></c:out></td>
						<td><c:out value="${requestList[2].resolvedBy}"></c:out></td>
					</tr>
					<tr>
						<td><c:out value="${requestList[3].ticketId}"></c:out></td>
						<td><c:out value="${requestList[3].employeeId}"></c:out></td>
						<td><c:out value="${requestList[3].total}"></c:out></td>
						<td><c:out value="${requestList[3].description}"></c:out></td>
						<td><c:out value="${requestList[3].status}"></c:out></td>
						<td><c:out value="${requestList[3].resolvedBy}"></c:out></td>
					</tr>
					</tr>
				</tbody>
			</table>
			<a href="createNewRequestForm" class="btn btn-primary" role="button">Submit
				new request</a>
		</div>

	</div>
</body>
</html>
