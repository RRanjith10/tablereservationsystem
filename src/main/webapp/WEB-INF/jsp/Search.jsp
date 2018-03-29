<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchPage</title>
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
<form action="searchHotels" method="post">  


 <font color="black" size="4">Logged in as : ${validuserName}</font><br>
<br><br><br><br><br>

            <table align="center" >  
            	<tr>  
                    <td>Enter the City to search</td>  
                    <td><input type="text" class="inputtext" list="cities" name="searchbycity" required="required" /></td>  
                </tr>  
                  
               
                <tr>  
                    <td><input type="submit" value="Go and search Hotels>>" /></td>  
                </tr> 
                <datalist id="cities">
				  <c:forEach items="${citieslist}" var="t">
				  <option value="<c:out value="${t}"/>">
				  </c:forEach>
				</datalist> 
            </table>  
    </form>  
</body>
</html>