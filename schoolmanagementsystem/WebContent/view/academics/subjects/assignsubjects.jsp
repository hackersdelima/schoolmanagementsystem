<%@page import="com.controller.student.classes.StudentOperations"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%if((session.getAttribute("userdetail"))!=null){
	StudentOperations s=new StudentOperations();
	ResultSet subjects=s.selectsubject();
	ResultSet section=s.getsection();%>

<link rel="import" href="include1.jsp">
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
			<form method="" action="" id="form" style="width:60%">
			<button type="submit" class="btn btn-success" form="form" >
					<i class="fa fa-check"></i> Save
				</button>
				<table class="table">
					<tbody>
						<tr>
							<td><h6>Student Admission No. *</h6>
				<input type="text" class="form-control" name="studentid" form="form"
					required></td>
							<td><h6>Subjects</h6>
				<select multiple class="form-control" name="subjectid" form="form">
					<%
					   				while (subjects.next()){  
										%>
					<option value="<%=subjects.getString("subjectid")%>"><%=subjects.getString("subjectname") %></option>
					<%} %>
				</select></td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>STUDENTS DETAIL</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<table id="datatable"
					class="table jambo_table table-striped table-bordered"
					cellspacing="0" width="100%" id="table" style="font-size:95%">
					<thead>
						<tr>
							<th>S.no</th>
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
			int sn=1;
			%>
						<c:forEach items="${slist }" var="s">
							<tr>
								<th scope="row"><%=sn %></th>
								<td>${s.studentname }</td>
								<td>${s.rollno }</td>
								<td>${s.admissionclass }</td>
								<td>${s.section }</td>
								<td>${s.studentid }</td>
								<td></td>
							</tr>
							<%sn++; %>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/msgmodal"></jsp:include>
	<script>
$(document).ready(function() {
	<%if(request.getAttribute("msg")!=null){%>
	   $('#myModal').modal('show');
	   <%}%>
$('#form').submit(function() {
    return confirm('CONFIRM SUBJECT SAVE?'); 
});
</script>
	">
</body>
<%}%>