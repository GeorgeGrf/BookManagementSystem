<!DOCTYPE html>
<html>
<head>

<style>

td,tr,th {
border-style:solid;
}


</style>


<script type="text/javascript">
function ShowFunction(number) {
	switch (number) {
		case 1:
			document.getElementById("menuDiv").style.display = "none";
			document.getElementById("addDiv").style.display = "block";
			document.getElementById("searchDiv").style.display = "none";
			break;
		case 2:
			document.getElementById("menuDiv").style.display = "none";
			document.getElementById("addDiv").style.display = "none";
			document.getElementById("searchDiv").style.display = "block";
			break;
		case 3:
			document.getElementById("menuDiv").style.display = "block";
			document.getElementById("addDiv").style.display = "none";
			document.getElementById("searchDiv").style.display = "none";
			break;
		case 4:
			document.getElementById("searchDiv").style.display = "none";
			document.getElementById("editDiv").style.display = "block";
			break;
		case 5:
			document.getElementById("searchDiv").style.display = "block";
			document.getElementById("editDiv").style.display = "none";
	}
}


function EditUser(){
	var selected=false;
	var selectedNo;
	var radios=document.getElementsByName("userSel");
	for (var i = 0, length = radios.length; i < length; i++){
		if (radios[i].checked){
			selected=true;
			selectedNo=i;
			break;
		}
		
	}
	if (!selected){
		alert("You need to select a user for editing.");
		return;
	}
	var cells=document.getElementById("srcResults").getElementsByTagName('tr')[selectedNo+1].getElementsByTagName("td");
	var usrId=cells[1].innerHTML;
	var usrName=cells[2].innerHTML;
	var usrRole=cells[3].innerHTML;
	document.getElementById("idEdit").innerHTML=usrId;
	var test1=document.getElementById("nameEdit").getElementsByTagName("input")
	test1[0].value=usrName;
	var nodeL= document.getElementsByName("roleE");
	var roleId;
	switch(usrRole) {
	case("Admin"):
		roleId=0;
		break;
	case("Publisher"):
		roleId=1;
		break;
	case("Professor"):
		roleId=2;
		break;
	case("Secretary"):
		roleId=3;
	}
	nodeL.item(roleId).checked=true;
	ShowFunction(4);
	return;
}



</script>


</head>
<body>


<div id="menuDiv">
Welcome admin <br>

<button onClick="ShowFunction(1)">Add User</button><br>
<button onClick="ShowFunction(2)">Search User</button><br>
<button>Logout</button>



</div>
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




<div id="searchDiv" style="display: none">
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
  
  <tr>
  	<td><input type="radio" name="userSel"/></td>
  	<td>2</td>
  	<td>some</td>
  	<td>secretary</td>
  </tr>
  <tr>
  	<td><input type="radio" name="userSel"/></td>
  	<td>3</td>
  	<td>some</td>
  	<td>publisher</td>
  </tr>
  <tr>
  	<td><input type="radio" name="userSel"/></td>
  	<td>4</td>
  	<td>some</td>
  	<td>professor</td>
  </tr>
</table>
<button onClick="EditUser()">Edit Selected User</button>








<button onClick="ShowFunction(3)">Back</button>
</div>


<div id="editDiv" style="display: none">
<form>
<table>
  <tr>
  	<th>Id</th>
    <th>UserName</th>
    <th>Role</th>
  </tr>

  <tr>
  	<td id="idEdit"></td>
  	<td id="nameEdit"><input type="text"></td>
  	<td id="roleEdit"><input type="radio" name="roleE" id="admin"> Admin 
	<input type="radio" name="roleE" id="publisher"> Publisher 
	<input type="radio" name="roleE" id="professor"> Professor 
	<input type="radio" name="roleE" id="secretary"> Secretary <br></td>
  </tr>
 </table>
</form>
<button>Save</button>  <button onClick="ShowFunction(5)">Cancel</button> <button>Delete</button>

</div>


</body>
</html>