<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<a href="managerHome.jsp" class="btn btn-primary" role="button">Home</a>
<a href="managerInfo.do" class="btn btn-primary" role="button">My Info</a>
<a href="empsInfo.do" class="btn btn-primary" role="button">View Employees</a>
<a href="viewResolvedRequests.do" class="btn btn-primary" role="button">View Resolved Reimbursement Requests</a>
<a href="logOut.do" class="btn btn-primary" role="button">Logout</a>
</head>

<body>
	<div class="col-lg-10 col-lg-offset-1">
		<div class="employee-table-title">
			<h2> All Resolved Reimbursement Requests</h2>
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
					<c:forEach items="${requestScope.requestsList}" var="reimbursement">
						<tr>
						<td><c:out value="${reimbursement.getTicketId()}"></c:out></td>
							<td><c:out value="${reimbursement.getEmployeeId()}"></c:out></td>
							<td><c:out value="${reimbursement.getTotal()}"></c:out></td>
							<td><c:out value="${reimbursement.getDescription()}"></c:out></td>
							<td><c:out value="${reimbursement.getStatus()}"></c:out></td>
							<td><c:out value="${reimbursement.getResolvedBy()}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
		<div>
			<a href="createNewRequestForm.jsp" class="btn btn-primary" role="button">Submit New Request</a>
		</div>
	</div>
</body>
</html>
