
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Success</title>
</head>
<body>
<form action="validateUser" method="post" >  

<h1><center>Payment</center></h1>
<br><br><br><br><br>
<h3>Payment Successful!!! </h3>  <br><br>
<h3><font color="black">${message}</font></h3>
<a href="search"><center>Search Hotels Again</center></a>  
         
    </form>  
</body>
</html>