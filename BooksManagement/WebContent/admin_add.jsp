<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<div id="addDiv" style="display: none">
<form action="AdminServlet" method="post" id="newForm">
Add new user <br>
Username: <input type="text" name="newUsr"> <br>
Password: <input type="text" name="newPwd"> <br>
Role: 
	<input type="radio" name="role" value="Admin"> Admin 
	<input type="radio" name="role" value="Publisher"> Publisher 
	<input type="radio" name="role" value="Professor"> Professor 
	<input type="radio" name="role" value="Secretary"> Secretary <br>
	<br> <button type="submit" name="addUser">Add</button>
</form> <br>
<button onClick="ShowFunction(3)">Back</button>

</div>




</body>
</html>