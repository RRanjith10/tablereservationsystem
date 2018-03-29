
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style> 
.inputtext {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
}

.inputtext:focus {
    border: 3px solid #555;
}
</style>
</head>
<body>
 
<font color="red">${message}</font>

		<form action="saveRegistration" method="post" >  

<h1><center>Register</center></h1>
<br><br><br><br><br>
            
            <table align="center" > 
            
           
                <tr>  
                    <td>Enter a valid Email ID</td>  
                    <td><input type="text" name="emailId" class="inputtext" required="required" /><form:errors path="user.emailId"/> </td>  
                </tr>  
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="password"  class="inputtext" required="required" /><form:errors path="user.password"/></td>  
                </tr> 
                <tr>  
                    <td>Customer Name</td>  
                    <td><input type="text" name="custName" class="inputtext" required="required" /><form:errors path="user.custName"/> </td>  
                </tr> 
                <tr>  
                    <td>Contact Number</td>  
                    <td><input type="text" name="phoneNo" class="inputtext" required="required" /><form:errors path="user.phoneNo"/> </td>  
                </tr>  
                <tr>  
                    <td><input type="submit" value="Register" /></td>  
                </tr>  
            </table>  
  
    </form>  
</body>
</html>