<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
<style>
.button {
  display: inline-block;
  padding: 15px 25px;
  font-size: 14px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 10px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
</head>
<body>

<h1><center>Book your Hotels</center></h1>
<br>
<marquee>Welcome to our application!!! Easy way to book ur hotel!!! </marquee>
<font color="black">${message}</font>
<br><br><br><br>
<font size="6"><center><a href="login"><button class="button">Login</button></a><center><font size="6">

<br>

<font size="6"><a href="registration"><center><button class="button">Registration</button></center></a>   <br><br>  <font size="6">
   
</body>
</html>