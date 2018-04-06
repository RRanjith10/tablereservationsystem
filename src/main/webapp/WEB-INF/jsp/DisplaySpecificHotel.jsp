<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bridge Creek | Selected hotel</title>
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
		<c:set var="e" value="${selectedHotel}" />
		<div class="hotelblock">
      <form name="form1" action="placeReservation" method="post">
			<input class="hotel-details" style="background: transparent;border: 0px;" name="hname" value="${e.getHname()}"></input>
			<div style="display: flex; justify-content: space-between;">
				<div class="hotel-details-con">
					<input style="background: transparent;border: 0px;" class="hotel-address"  name="address"  value ="${e.getAddress()}"></input>
					<input style="background: transparent;border: 0px;" name="city" value ="${e.getCity()}"></input>
					<input style="background: transparent;border: 0px;" name="state"  value ="${e.getState()}"></input>
				</div>
				<div>
					<button class="button" id="myBtn">Book</button>
				</div>
			</div>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<span class="close">&times;</span>
					<div>
						<div>Email id</div>
						<div>
							<input class="inputtext" type="text" name="userMailId"
								value="${validuserEmailId}" readonly />
						</div>
					</div>
					<div>
						<div>Select Table</div>
						<div>
							<input class="inputtext" type="text" list="tablesList"
								name="tableSelected" required="required" />
						</div>
					</div>
					<div>
						<div>No. of persons</div>
						<div>
							<input class="inputtext" type="text" name="personCount"
								required="required" />
						</div>
					</div>
          <div>
						<div>Select from menu</div>
						<div>
							<input type="text" class="inputtext" list="menulist" name="menuSelected"
								id="menuSelected" />
						</div>
					</div>
          <button  class="button" style="width: 100%;margin-top: 20px;" type="button" name="addbtn" onclick="myFunction()">ADD</button>
					<datalist id="tablesList"> <c:forEach
						items="${tableList}" var="t">
						<option value="<c:out value="${t.getTableName()}"/>">
					</c:forEach> </datalist>
					<table id="menuTable" border="1">
						<tr>
							<td>Item Selected</td>
							<td>Price of the item</td>
							<td>Quantity</td>
						</tr>
					</table>
          					<input type="text" hidden name="menuS" id="menuS" />
					<button type="submit" class="button" style="width: 100%;margin-top: 20px;" name="addbtn" onclick="readTable()">Place
						Reservation</button>
					</form>
					<datalist id="menulist"> <c:forEach items="${menuList}"
						var="m">
						<option
							value="<c:out value="${m.getMenuName()}"/>----Rs.<c:out value="${m.getMenuRate()}"/>.00">
					</c:forEach> </datalist>
				</div>
			</div>
		</div>
	</div>
	<script src="js/index.js">
</script>
</body>
</html>