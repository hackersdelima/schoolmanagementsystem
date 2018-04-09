<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.controller.student.classes.StudentOperations"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if ((session.getAttribute("userdetail")) != null) {
		StudentOperations s = new StudentOperations();
		ResultSet subjects = s.selectsubject();
		ResultSet section = s.getsection();
		ResultSet classlist = s.selectclass();
%>

<jsp:include page="/includefile"></jsp:include>
<body class="background">
	<div class="breadcrumb-line">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><i class="fa fa-home"
					aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Academic</li>
				<li class="breadcrumb-item active" aria-current="page">Subjects</li>
				<li class="breadcrumb-item active" aria-current="page">Assign
					Subjects</li>
			</ol>
		</nav>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>ASSIGN SUBJECTS</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" action="assignsubjects.add" id="form"
					>
					<button type="submit" class="btn btn-success" form="form">
						<i class="fa fa-check"></i> Save
					</button>
						<div class="col-md-12">
						<div class="col-md-5">
						<h6>Class</h6> <select class="form-control" name="classid" form="form"
									id="class" required>
										<option value="">Select Class</option>
										<%
											while (classlist.next()) {
										%>
										<option value="<%=classlist.getString("classid")%>"><%=classlist.getString("classname")%></option>
										<%
											}
										%>
								</select>
						</div>
						<div class="col-md-7">
							<h6>Subjects</h6> <select multiple class="form-control"
									name="subjectid" form="form">
										<%
											while (subjects.next()) {
										%>
										<option value="<%=subjects.getString("subjectid")%>"><%=subjects.getString("subjectCode")%> - <%=subjects.getString("subjectname")%></option>
										<%
											}
										%>
								</select>
						</div>
						</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/msgmodal"></jsp:include>
	<script>
	<%if (request.getAttribute("msg") != null) {%>
	   $('#myModal').modal('show');
	   <%}%>
$('#form').submit(function() {
    return confirm('CONFIRM SUBJECT SAVE?'); 
});
</script>
</body>
<%
	}
%>