<p>Here are your book options(please choose 2):
<p>

<form action="pickBooks" method="post">
	<select id="bookchoice1" name="choice1">
		<c:forEach items="${listbooks}" var="book">
		<option value="${book.getTitle()}">${book.getTitle()}</option>
		</c:forEach>
	</select> 
	<select id="bookchoice2" name="choice2">
		<c:forEach items="${listbooks}" var="book">
			<option value="${book.getTitle()}">${book.getTitle()}</option>
		</c:forEach>
	</select>
	<button type="submit" id="submit">Submit</button>
</form>