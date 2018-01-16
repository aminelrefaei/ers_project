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

<a href="logOut.do" class="btn btn-primary" role="button">Logout</a>
<a href="home.do" class="btn btn-primary" role="button">Home</a>
</head>

<body>
	<div class="col-lg-10 col-lg-offset-1">
		<div class="employee-table-title">
			<h2>Information</h2>
		</div>
		<div id="employee-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>	Ticket ID	</th>
						<th>	Date Submitted	</th>
						<th>	Request Type	</th>
						<th>	Description		</th>
						<th>	Amount			</th>
						<th>	Status			</th>
						<th>	Date Resolved	</th>
						<th>	Resolved By	</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="reimb" items="${reimbs}">
			            <tr>
			                <td>	<fmt:formatDate type="date" dateStyle="long" 
				                		value="${reimb.date_submitted}" />							</td>
							<td>	<c:out value="${reimb.type_id.type}">				</c:out>	</td>
							<td>	<c:out value="${reimb.description}">				</c:out>	</td>
							<td>	<fmt:setLocale value="en_US"/>
									<fmt:formatNumber type ="currency" 
										value="${reimb.amount}"/>									</td>
							<td>	<c:out value="${reimb.status_id.status}">			</c:out>	</td>
							<td>	<fmt:formatDate type="date" dateStyle="long"  
										value="${reimb.date_resolved}" />							</td>
							<td>	<c:if test="${reimb.resolver_id.user_id !=0}">
										<c:out value="${reimb.resolver_id.fullName}">	</c:out>
									</c:if>															</td>
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
