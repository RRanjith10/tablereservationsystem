<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bridge Creek | Search Hotels</title>
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
		<div class="login-container">
			<h1 class="heading-page">Search</h1>
			<form action="searchHotels" method="post">
				<table align="center">
					<tr>
						<td>Enter the City to search</td>
						<td><input type="text" class="input-drop-down" list="cities"
							name="searchbycity" required="required" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Search" /></td>
					</tr>
					<datalist id="cities"> <c:forEach items="${citieslist}"
						var="t">
						<option value="<c:out value="${t}"/>">
					</c:forEach> </datalist>
				</table>
			</form>
		</div>
	</div>
</body>
</html>