<jsp:useBean id="lecturer" class="gr.dit.hua.entities.User"></jsp:useBean>

<p>WELCOME ${name}
<br>
Please choose from the list the subject you want to submit books for:
<form action="pickSubject" method="post">
<select id="allsubjects" name="subject">
	<c:forEach items="${courses}" var="course">
		<option value="${course}">${course}</option>
	</c:forEach>
</select>
<button type="submit" id="submit">Submit</button>
</form>
<form action="LogOut" method="post"> 
<Button type="submit">Log Out</Button>
</form>


