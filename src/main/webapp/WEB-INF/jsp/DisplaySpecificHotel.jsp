<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specific hotel</title>

</head>
<body>
<font color="black" size="4">Welcome : ${validuserName}</font><br>
<h2><center> View your Hotel Details </center></h2>

<center> Enter the details<center> 
<form name="form1" action="placeReservation" method="post">
<table align="center" style="border: none;">

<c:set var="e" value= "${selectedHotel}"/>

<tr><td>Hotel name</td><td><input type="text" name="hname" value="<c:out value="${e.getHname()}"/>" /></td></tr>

<tr><td>Address</td><td><input type="text" name="address" value="<c:out value="${e.getAddress()}"/>" /></td></tr>
<tr><td>City</td><td><input type="text" name="city" value="<c:out value="${e.getCity()}"/>" /></td></tr>
<tr><td>State</td><td><input type="text" name="state" value="<c:out value="${e.getState()}"/>" /></td></tr>


<tr>  
                    <td>Email id</td>  
                    <td><input type="text" name="userMailId" value="${validuserEmailId}" readonly /></td>  
                </tr>
                 <tr>  
                    <td>Select Table</td>  
                    <td><input type="text" list="tablesList" name="tableSelected" required="required"/></td>  
                </tr>  
                  
                <td>No. of persons</td>  
                    <td><input type="text" name="personCount"  required="required"/></td>  
                </tr>

                
                <datalist id="tablesList">
                <c:forEach items="${tableList}" var="t">
				  <option value="<c:out value="${t.getTableName()}"/>">
				  </c:forEach>
				</datalist>
				
</table>


<script>

function myFunction() {


      var menuselect = document.getElementById("menuSelected").value;

      var item = menuselect.substring(0,menuselect.indexOf("--"));

      var start = menuselect.indexOf("Rs.");

      var end = menuselect.indexOf(".00");

      var price = menuselect.substring((start+3),end);

      var table = document.getElementById("menuTable");

    var row = table.insertRow(1);

    var cell1 = row.insertCell(0);

    var cell2 = row.insertCell(1);

    var cell3 = row.insertCell(2);

    //alert(item+" ** "+price);

    var tbl = document.getElementById("menuTable");

   var listName= "levels-list"+(tbl.rows.length-1);

    var itemTextName = "itemText"+(tbl.rows.length-1);

    var priceTextName = "priceText"+(tbl.rows.length-1);

    cell1.innerHTML = '<input type="text" id="'+itemTextName+'" name="'+itemTextName+'" value ="'+item+'" readonly>';

    cell2.innerHTML = '<input type="text" id="'+priceTextName+'" name="'+priceTextName+'" value ="'+price+'" readonly>';

    cell3.innerHTML = '<select id="'+listName+'"><option value="1" id="option-1">1</option><option value="2" id="option-2">2</option><option value="3" id="option-3">3</option><option value="4" id="option-4">4</option></select>';

    document.getElementById("menuSelected").value="";

}

function readTable(){

      var tbl = document.getElementById("menuTable");

    if (tbl != null) {

      //alert(tbl.rows.length);

        for (var i = 1; i < tbl.rows.length; i++) {

            var item = document.getElementById("itemText"+i);

            var price = document.getElementById("priceText"+i);

            var e = document.getElementById("levels-list"+i);

            var text = e.options[e.selectedIndex].text;
			var oldValue = document.getElementById("menuS").value;
            if(i == 1)
             document.getElementById("menuS").value= +item.value+"---"+price.value+"---"+text;
		 else
		 document.getElementById("menuS").value=oldValue + ":" +item.value+"---"+price.value+"---"+text;
        }

    }

}

</script>

<h3>Please select the menu and add it to the table</h3><br>

<table style="border=0px">

<tr>

<td>Select from menu</td>

<td>

<input type="text" list="menulist" name="menuSelected" id="menuSelected" />

</td>

<td> <button type="button" name="addbtn" onclick="myFunction()">ADD</button></td>

</tr>

</table>

<table id="menuTable" border="1">

  <tr>

    <td>Item Selected</td>

    <td>Price of the item</td>

    <td>Quantity</td>

  </tr>
 
                 
              
</table>



<br>

<button type="submit" name="addbtn" onclick="readTable()">Place Reservation</button>

 <input type="text" hidden name="menuS" id="menuS"/>
 </form>
<datalist id="menulist">

  <c:forEach items="${menuList}" var="m">
<option value="<c:out value="${m.getMenuName()}"/>----Rs.<c:out value="${m.getMenuRate()}"/>.00">
</c:forEach>

</datalist>

</body>
</html>

