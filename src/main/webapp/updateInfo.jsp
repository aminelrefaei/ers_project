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
	<div class="requestForm">
    <form class="form-horizontal" action="updateInfo.do" method="post">
        <div class="form-group">
            <label for="inputEmail" class="control-label col-xs-2">First Name</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="firstname" placeholder="First Name" required>
            </div>
        </div>
        
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Last Name</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="lastname" placeholder="Last Name" required>
            </div>
        </div>
        
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Email</label>
            <div class="col-xs-10">
                <input type="email" class="form-control" name="email" placeholder="Email" required>
            </div>
        </div>
        
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Password</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form>
</div>
	</div>
</body>
</html>