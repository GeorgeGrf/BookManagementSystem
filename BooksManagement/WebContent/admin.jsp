<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<p>Welcome admin</p> <br>
<form action="AdminServlet" method="post">
<p> Add new user </p>
<p>Username:</p> <input type="text" name="newUsr">
<p>Password:</p> <input type="text" name="newPwd">
<p>Role:</p> 
	<input type="radio" name="role" value="admin"> Admin<br>
	<input type="radio" name="role" value="publisher"> Publisher<br>
	<input type="radio" name="role" value="proffesor"> Proffesor<br>
	<input type="radio" name="role" value="secretary"> Secretary <br>
	<button type="submit" name="addUser">Add</button>
</form> <br>







</body>
</html>