<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Users: <br>
<table id="srcResults">
  <tr>
  	<th></th>
  	<th>Id</th>
    <th>UserName</th>
    <th>Role</th>
  </tr>

  <tr>
  	<td><input type="radio" name="userSel"/></td>
  	<td>1</td>
  	<td>me</td>
  	<td>admin</td>
  </tr>

</table>
<button onClick="EditUser()">Edit Selected User</button>




</body>
</html>