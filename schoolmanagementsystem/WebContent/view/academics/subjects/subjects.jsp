<%@page import="com.controller.student.classes.StudentOperations" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%if((session.getAttribute("userdetail"))!=null){
	StudentOperations s=new StudentOperations();
	ResultSet subjects=s.selectsubject();%>
<link rel="import" href="include.jsp">
<div class="background">
<div class="breadcrumb-line">
	<nav aria-label="breadcrumb" role="navigation">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
	      <li class="breadcrumb-item active" aria-current="page">Settings</li>
	    <li class="breadcrumb-item active" aria-current="page">Academic</li>
	    <li class="breadcrumb-item active" aria-current="page">Subjects</li>
	  </ol>
	</nav>
</div>
<br>
<div class="row ">
	<div class="col-sm-4">
		<form method="post" action="addsubject" id="form"></form>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title"><strong>ADD SUBJECTS</strong></h4>
			</div>
			<div class="panel-body">
				<h5>Subject Name *</h5>
			   	<input type="text" class="form-control" name="subjectname" form="form" required>
			   	<br>
			   	<h5>Subject Type *</h5>
			   	<select class="form-control" name="subjecttype" form="form" required>
			   		<option value="" selected>Select subject type</option>
			   		<option value="common">Common</option>
			   		<option value="optional">Optional</option>
			   	</select>
			   	<br>
			   	<button type="submit" class="btn btn-success" form="form"><i class="fa fa-check"></i> Save</button>
			</div>
		</div>
	</div>
	<div class="col-sm-8">
		<div class="panel panel-default" style="margin-top:15px;">
			<div class="panel panel-heading">
				<h4 class="panel-title"><strong>SUBJECTS LIST</strong></h4>
			</div>
			<div class="panel-body">
				<table class="table display" id="table">
					<thead>
						<tr>
							<th>S No.</th>
							<th>Subject Name</th>
							<th>Subject Type</th>
							<th><i class="fa fa-cog" aria-hidden="true"></i></th>
						</tr>
					</thead>
					<tbody>
						<%int sno=1; while (subjects.next()){ %>
						<tr>
							<td><%=sno %></td>
							<td><%=subjects.getString("subjectname") %></td>
							<td><%=subjects.getString("subjecttype") %></td>
							<td>
							 <a href=""><i class="fa fa-pencil-square-o" aria-hidden="true" style="color:blue;"></i></a>&nbsp;&nbsp;&nbsp;<a href="subject.del?id=<%=subjects.getString("subjectid")%>" class="delete"><i class="fa fa-trash" aria-hidden="true" style="color:red;"></i></a>
							</td>
						</tr>
					<%sno++;} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-body">
          <p>${msg}</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>
<script>
$(document).ready(function() {
	<%if(request.getAttribute("msg")!=null){%>
	   $('#myModal').modal('show');
	   <%}%>
	 $('#table').DataTable( {
	        scrollY:        '50vh',
	        scrollCollapse: true,
	        paging:         false
	    } );
} );
$('#form').submit(function() {
    return confirm('CONFIRM SUBJECT SAVE?'); 
});
$('.delete').click(function() {
    return confirm('CONFIRM SUBJECT DELETE?'); 
});
</script>
<%}%>