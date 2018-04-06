<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bridge Creek | Payment</title>
<link href="css/main.css" rel="stylesheet">
<script>
function checkCardNoLength() {
    var textBox = document.getElementById("cardNo");
	var textLength = textBox.value.length;
}
</script>
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

		<div class="payment-container">
			<font color="red">${message}</font>
			<c:set var="billTotal" value="${billTotal}" />
			<form action="makePayment" method="post">
				<h1>
					<center>Make your Payment</center>
				</h1>
				<div class="form-fields">
					<div>
						<span>Total</span> <input type="text" name="billTotal"
							id="billTotal" value="${billTotal}" class="inputtext"  required="required" readonly />
					</div>
					<div>
						<span>Select Card type</span> <input type="text" list="cardList"
							name="cardtype" id="cardtype" class="inputtext" required="required" />
						<datalist id="cardList">
						<option value="Credit Card">
						<option value="Debit Card">
						</datalist>
					</div>
					<div>
						<span>Enter Bank Name</span> <input type="text" name="bankName"
							id="bankName" class="inputtext" required="required" />
					</div>
					<div>
						<span>Enter Card Number</span> <input type="text" name="cardNo"
							id="cardNo" class="inputtext"  required="required" maxlength="16" />
					</div>
					<div>
						<span>Enter CVV</span> <input type="password" name="cvv" id="cvv"
							required="required" class="inputtext" maxlength="3" />
					</div>
					<div class="login-btn-container">
						<input class="input-btn" type="submit" value="Pay"
							onclick="checkCardNoLength()" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>