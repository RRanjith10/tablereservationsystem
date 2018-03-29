
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bridge Creek | Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Nunito:700,400" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<script src="js/index.js" ></script>
</head>
<body>
<div class="background-body">

    <div class="login-container">
    <h1 class="heading-page"><center>Login</center></h1>

    <font color="red">${message}</font>

		<form action="checkLogin" method="post" >  
            <div class="form-fields">
                <div>
                    <span>User ID</span>
                    <input type="text" class="inputtext" name="emailId" required="required" /><form:errors path="user.emailId"/>
                </div>
                <div>
                    <span>Password</span>
                    <input type="password" class="inputtext" name="password" required="required" /><form:errors path="user.password"/>
                </div>
                <div class = "login-btn-container">
                <input class="input-btn" type="submit" value="Login" />
                </div>
            </div>
    </form>  


    </div>
    
</div>
 

</body>
</html>