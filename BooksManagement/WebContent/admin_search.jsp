<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div id="searchDiv" style="display: none">
Search/Modify User <br>
<form action="AdminServlet" method="get" id="nameSearch"> 
Search User By: <br>
Username: <input type="text" name="srcName"> <button type="submit" name="nameSearch" >Search</button>
</form>
<form action="AdminServlet" method="get" id="roleSearch">
Role: <input type="text" name="srcRole"> <button name="submit">Search</button>
</form>



</body>
</html>