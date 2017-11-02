<%@page import="com.controller.student.classes.StudentOperations" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%if((session.getAttribute("userdetail"))!=null){
	ResultSet ud=(ResultSet)session.getAttribute("userdetail");
	StudentOperations s=new StudentOperations(ud.getString("companydb"));
	ResultSet subjects=s.selectsubject();
	ResultSet section=s.getsection();%>
<div class="breadcrumb-line">
	<nav aria-label="breadcrumb" role="navigation">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Academic</li>
	    <li class="breadcrumb-item active" aria-current="page">Subjects</li>
	    <li class="breadcrumb-item active" aria-current="page">Assign Subjects</li>
	  </ol>
	</nav>
</div>
<br>
<div class="row container">
	<div class="col-sm-3">
		<form method="post" action="assignsubjects.add" id="form"></form>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title"><strong>ASSIGN SUBJECT</strong></h4>
			</div>
			<div class="panel-body">
				<input type="hidden" name="companydb" value="<%=ud.getString("companydb")%>" form="form">
				<h5>Student Admission No. *</h5>
			   	<input type="text" class="form-control" name="studentid" form="form" required >
			   	<br>
			   	<h5>Subjects</h5>
			   	<select multiple  class="form-control" name="subjectid" form="form" >
					   				<%
					   				while (subjects.next()){  
										%>
											<option value="<%=subjects.getString("subjectid")%>"><%=subjects.getString("subjectname") %></option>
											<%} %>
			   	</select>
			   	
			   	<br>
			   	<button type="submit" class="btn btn-success" form="form"><i class="fa fa-check"></i> Save</button>
			</div>
		</div>
	</div>
	<div class="col-sm-9">
		<div class="panel panel-default" style="width:90%; margin:auto;">
			<div class="panel-heading">
				<h4 class="panel-title"><strong>STUDENT DETAIL/ASSIGNED SUBJECTS</strong></h4>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover display" cellspacing="0" width="100%" id="table" >
										<thead>
											<tr>
												<th>NAME</th>
												<th>ROLL NO</th>
												<th>CLASS</th>
												<th>SECTION</th>
												<th>ADMISSION NO</th>
												<th>SUBJECTS</th>
											</tr>
										</thead>
										<tbody id="example">
			<%
			ResultSet rs=s.studentDetails();
			while(rs.next())
			{
			%>
											<tr>
												<td><%=rs.getString("studentname") %></td>
												<td><%=rs.getString("rollno") %></td>
												<td><%=rs.getString("admissionclass") %></td>
												<td><%=rs.getString("section") %></td>
												<td><%=rs.getString("studentid") %></td>
												<td></td>
											</tr>
											<%} %>
										</tbody>
				</table>
			</div>
		</div>
	</div>

</div>

<script>
$(document).ready(function() {
	 $('#table').DataTable( {
	        scrollY:        '50vh',
	        scrollCollapse: true,
	        paging:         false
	    } );
} );
$('#form').submit(function() {
    return confirm('CONFIRM SUBJECT SAVE?'); 
});
</script>
<%}%>