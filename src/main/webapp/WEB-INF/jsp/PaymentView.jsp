
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PaymentGateWay</title>
<script>
function checkCardNoLength() {
    var textBox = document.getElementById("cardNo");
	var textLength = textBox.value.length;
	//alert(textLength);
}
</script>
</head>
<body>
 <font color="black" size="4">Logged in as : ${validuserName}</font><br>
 
<font color="red">${message}</font>
<c:set var="billTotal" value= "${billTotal}"/>
		<form action="makePayment" method="post" >  

<h1><center>Make your Payment here!!!</center></h1>
<br><br><br><br><br>
        <fieldset style="width: 1500px" >  
            <legend > Confirm and Pay </legend>  
            <table align="center" > 
            
           
                <tr>  
                    <td>Total Payment</td>  
                    <td><input type="text" name="billTotal" id="billTotal" value="${billTotal}" required="required" readonly/></td>  
                </tr>  
                <tr>  
                    <td>Select Card type</td>  
                    <td><input type="text" list="cardList" name="cardtype" id="cardtype" required="required" /></td>  
                </tr>
                <datalist id="cardList">
				  <option value="Credit Card">
				  <option value="Debit Card">
				</datalist>  
                 <tr>  
                    <td>Enter Bank Name</td>  
                    <td><input type="text" name="bankName" id="bankName" required="required" /></td>  
                </tr>
                <tr>  
                    <td>Enter Card Number</td>  
                    <td><input type="text" name="cardNo" id="cardNo" required="required" placeholder="Enter 10 digit account no."/></td>  
                </tr>
                <tr>  
                    <td>Enter CVV Number</td>  
                    <td><input type="password" name="cvv" id="cvv" required="required" /></td>  
                </tr>   
                <tr>  
                    <td><input type="submit" value="Confirm Payment" onclick="checkCardNoLength()"/></td>  
                </tr>  
            </table>  
         
    </form>  
</body>
</html>