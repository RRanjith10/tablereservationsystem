<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Nunito:700,400" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<script src="js/index.js" ></script>
</head>
<body>
<div class="background-body">
    <div class="registration-container">
        <h1 class="heading-page">Register</h1>
        <font color="red">${message}</font>
        <form action="saveRegistration" method="post" > 
            <div class="form-fields">
                <div>
                    <span>Email ID</span>
                    <input type="text" name="emailId" class="inputtext" required="required" /><form:errors path="user.emailId"/> 
                </div>
                <div>
                    <span>Password</span>
                    <input type="password" name="password"  class="inputtext" required="required" /><form:errors path="user.password"/>
                </div>
                <div>
                    <span>Name</span>
                    <input type="text" name="custName" class="inputtext" required="required" /><form:errors path="user.custName"/>
                </div>
                <div>
                    <span>Contact Number</span>
                    <input type="text" name="phoneNo" class="inputtext" required="required" /><form:errors path="user.phoneNo"/>
                </div>
                <div class = "login-btn-container">
                    <input class="input-btn" type="submit" value="Register"/>
                </div>
            </div>
      </form>  
    </div>
</div>
</body>
</html>