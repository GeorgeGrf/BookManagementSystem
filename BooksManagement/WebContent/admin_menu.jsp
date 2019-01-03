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












<button onClick="ShowFunction(3)">Back</button>
</div>





</body>
</html>