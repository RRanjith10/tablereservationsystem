<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bridge Creek | Payment</title>
<link href="css/main.css" rel="stylesheet">
<script src="js/index.js" ></script>
</head>
<body>
<div class="background-body">
    <div style="text-align: center;top: 15%;position: absolute;width: 100%;">
        <img src="icons/check.svg" height=130/>
        <form action="validateUser" method="post" >  
            <h3>Payment Success </h3>  <br><br>
            <h3><font color="black">${message}</font></h3>
            <a href="search"><center>Search Again</center></a>  
        </form>
    </div>  
</div>
</body>
</html>