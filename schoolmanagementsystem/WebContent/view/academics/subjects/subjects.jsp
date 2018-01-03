<%@page import="com.controller.student.classes.StudentOperations"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%
	if ((session.getAttribute("userdetail")) != null) {
		StudentOperations s = new StudentOperations();
		ResultSet subjects = s.selectsubject();
%>
<link rel="import" href="include1.jsp">
<body class="background">

	<div class="breadcrumb-line">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><i class="fa fa-home"
					aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Settings</li>
				<li class="breadcrumb-item active" aria-current="page">Academic</li>
				<li class="breadcrumb-item active" aria-current="page">Subjects</li>
			</ol>
		</nav>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>Add New Subject</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" action="addsubject" id="form" style="width:40%">
					<h5>Subject Name *</h5>
					<input type="text" class="form-control" name="subjectname"
						form="form" required> <br>
					<h5>Subject Type *</h5>
					<select class="form-control" name="subjecttype" form="form"
						required>
						<option value="" selected>Select subject type</option>
						<option value="common">Common</option>
						<option value="optional">Optional</option>
					</select> <br>
					<button type="submit" class="btn btn-success" form="form">
						<i class="fa fa-check"></i> Save
					</button>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>Available Subjects List</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<table id="datatable" class="table table-striped table-bordered"
					style="font-size: 95%;">
						<thead>
							<tr>
								<th>S No.</th>
								<th>Subject Name</th>
								<th>Subject Type</th>
								<th><i class="fa fa-cog" aria-hidden="true"></i></th>
							</tr>
						</thead>
						<tbody>
							<%
								int sno = 1;
									while (subjects.next()) {
							%>
							<tr>
								<td><%=sno%></td>
								<td><%=subjects.getString("subjectname")%></td>
								<td><%=subjects.getString("subjecttype")%></td>
								<td><a href=""><i class="fa fa-pencil-square-o"
										aria-hidden="true" style="color: blue;"></i></a>&nbsp;&nbsp;&nbsp;<a
									href="subject.del?id=<%=subjects.getString("subjectid")%>"
									class="delete"><i class="fa fa-trash" aria-hidden="true"
										style="color: red;"></i></a></td>
							</tr>
							<%
								sno++;
									}
							%>
						</tbody>
					</table>
			</div>
		</div>
	</div>

	
	<jsp:include page="/msgmodal"></jsp:include>
	<script>
		$(document).ready(function() {
	<%if (request.getAttribute("msg") != null) {%>
		$('#myModal').modal('show');
	<%}%>
		});
		$('#form').submit(function() {
			return confirm('CONFIRM SUBJECT SAVE?');
		});
		$('.delete').click(function() {
			return confirm('CONFIRM SUBJECT DELETE?');
		});
		
	</script>
	<%}%>