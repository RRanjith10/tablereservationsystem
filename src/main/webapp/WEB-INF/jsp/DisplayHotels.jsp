<%@ page import="com.mindtree.entity.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DisplayHotelPage</title>
</head>
<body>
<br>
<font color="black" size="4">Logged in as : ${validuserName}</font><br>
<h2><center>  Select the hotel </center></h2> <br><br><br>

<form action="viewHotel" method="get">

<table align="center" style="border: none;">

<tr><td><b>Hotel name</b></td><td><b>Address</td><td><b>City</b></td><td><b>State</b></td><td><b>Select</b></td></tr>


<c:forEach items="${retrieveHotels}" var="e">
<tr><td><c:out value="${e.getHname()}"/></td><td><c:out value="${e.getAddress()}"/></td>
<td><c:out value="${e.getCity()}"/></td><td><c:out value="${e.getState()}"/></td><td><a href="view.do"><button value="<c:out value="${e.getHid()}"/>" id="btn" name="btn">View Hotel</button></a></td></tr>
</c:forEach>

</table>
<br><br>
<center> <a href="search">Change Search</a></center> 


</form>
</body>
</html>