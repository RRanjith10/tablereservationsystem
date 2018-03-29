
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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

		<form action="checkLogin" method="post" >  

<h1><center>Login</center></h1>
<br><br><br><br><br>
        
            <table align="center" > 
            
           
                <tr>  
                    <td>Enter the user ID</td>  
                    <td><input type="text" class="inputtext" name="emailId" required="required" /><form:errors path="user.emailId"/> </td>  
                </tr>  
                <tr>  
                    <td>Enter the password</td>  
                    <td><input type="password" class="inputtext" name="password" required="required" /><form:errors path="user.password"/></td>  
                </tr>  
                <br>
                <tr>  
                    <td><input type="submit" value="Login" /></td>  
                </tr>  
            </table>  
       
    </form>  
</body>
</html>