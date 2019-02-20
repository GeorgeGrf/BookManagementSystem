<jsp:useBean id="lecturer" class="gr.dit.hua.entities.User"></jsp:useBean>

<p>WELCOME ${name}
<br>
Please choose from the list the subject you want to submit books for:
<form action="pickSubject" method="post">
<select id="allsubjects" name="subject">
  <option value="Distributed Systems">Κατανεμημένα Συστήματα</option>
  <option value="Operating Systems">Λειτουργικά Συστήματα</option>
  <option value="Systems Analysis and Software Engineering">Ανάλυση Συστημάτων και Τεχνολογία Λογισμικού</option>
</select>
<button type="submit" id="submit">Submit</button>
</form>


