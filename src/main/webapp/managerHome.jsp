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

<a href="managerInfo.do" class="btn btn-primary" role="button">My Info</a>
<a href="empsInfo.do" class="btn btn-primary" role="button">View Employees</a>
<a href="viewPendingRequests.do" class="btn btn-primary" role="button">View Pending Reimbursement Requests</a>
<a href="viewResolvedRequests.do" class="btn btn-primary" role="button">View Resolved Reimbursement Requests</a>
<a href="logOut.do" class="btn btn-primary" role="button">Logout</a>

</head>

<body>
	
	<div class="col-lg-10 col-lg-offset-1">
		<div class="manager-table-title">
			<h2>Welcome, manager</h2>
		</div>
		
		
	</div>
<script type="text/javascript">
	function statusClick(clicked_id)
	{   document.getElementById(clicked_id).session_start();}
</script>
</body>
</html>