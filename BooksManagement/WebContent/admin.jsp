<!DOCTYPE html>
<html>
<head>

<style>



form,section {
	background-color: gray;
}

table,th, td{
	width:50%;
	background-color:white;
 	border-style:solid;
}



</style>

</head>
<body>
Welcome admin <br>
<form action="AdminServlet" method="post" id=newForm>
Add new user <br>
Username: <input type="text" name="newUsr"> <br>
Password: <input type="text" name="newPwd"> <br>
Role: 
	<input type="radio" name="role" value="admin"> Admin 
	<input type="radio" name="role" value="publisher"> Publisher 
	<input type="radio" name="role" value="proffesor"> Proffesor 
	<input type="radio" name="role" value="secretary"> Secretary <br>
	<br> <button type="submit" name="addUser">Add</button>
</form> <br>

<section>
Search/Modify User <br>
<form action="AdminServlet" method="get" id="nameSearch"> 
Search User By: <br>
Username: <input type="text" name="srcName"> <button type="submit" >Search</button>
</form>
<form action="AdminServlet" method="get" id="roleSearch">
Role: <input type="text" name="srcRole"> <button name="submit">Search</button>
</form>

Users: <br>
<table id="srcResults">
  <tr>
  	<th>Id</th>
    <th>UserName</th>
    <th>Role</th>
  </tr>
  <tr>
  </tr>
</table>
</section>


</body>
</html>