<%@ page import="com.mindtree.entity.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bridge Creek | Display Hotels</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<div class="background-body">
		<div class="app-bar">
			<h2>
				<img class="app-bar-icon" src="icons/logo.svg" />BRIDGE CREEK
			</h2>
			<div style="display: flex">
				<img class="app-bar-icon" style="height: 28px" src="icons/user.svg" />
				<div style="line-height: 30px;">${validuserName}</div>
			</div>
		</div>
        <div style="text-align: right;padding-right: 20px;">
				<a href="search">Modify Search</a>
		</div>
		<form action="viewHotel" method="get">
			<table align="center" class="display-hotel-table">

				<tr class="dis-hotel-table-heading">
					<th>Hotel name</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Select</th>
				</tr>
				<c:forEach items="${retrieveHotels}" var="e">
					<tr>
						<td><c:out value="${e.getHname()}" /></td>
						<td><c:out value="${e.getAddress()}" /></td>
						<td><c:out value="${e.getCity()}" /></td>
						<td><c:out value="${e.getState()}" /></td>
						<td><a href="view.do"><button
									value="<c:out value="${e.getHid()}"/>" id="btn" name="btn">View
									Hotel</button></a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<br>			
        </form>
	</div>
</body>
</html>