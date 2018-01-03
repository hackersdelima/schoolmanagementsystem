<%@page import="com.controller.student.classes.StudentOperations"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<% if((session.getAttribute("userdetail"))!=null){
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="import" href="include1.jsp">
<html>
<head></head>

<body class="background">
	<div class="breadcrumb-line">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><i class="fa fa-home"
					aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Student</li>
				<li class="breadcrumb-item active" aria-current="page">Student
					List</li>
			</ol>
		</nav>
	</div>
	
		<div class="col-md-12 col-sm-12 col-xs-12">

			<div class="x_panel">
				<div class="x_title">
					<h2>Specific Search</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<table cellpadding="3" cellspacing="0" border="0">
						<tbody>
							<tr id="filter_col2" data-column="1">
								<td align="center"><input type="text"
									class="column_filter form-control"
									placeholder="Student Name..." id="col1_filter"><br></td>
							</tr>
							<tr id="filter_col3" data-column="2">
								<td align="center"><input type="text"
									class="column_filter form-control" placeholder="Roll No..."
									id="col2_filter"><br></td>
							</tr>
							<tr id="filter_col4" data-column="3">
								<td align="center"><input type="text"
									class="column_filter form-control" placeholder="Class..."
									id="col3_filter"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Registered Students</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
				
					<table id="datatable-buttons" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%" style="font-size:95%;'">
						<thead>
							<tr class="headings">
								<th>S No.</th>
								<th>STUDENT NAME</th>
								<th>ROLL NO</th>
								<th>CLASS</th>
								<th>SECTION</th>
								<th>ADMISSION NO</th>
								<th>ADMISSION DATE</th>
								<th><i class="fa fa-cog" aria-hidden="true"></i></th>
							</tr>
						</thead>
						<tbody>
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
									<td>${s.admissiondate }</td>
									<td>
									<div class="btn-group">
                    <button data-toggle="dropdown" class="btn btn-success dropdown-toggle btn-xs" type="button">Action <span class="caret"></span>
                    </button>
                    <ul role="menu" class="dropdown-menu">
                    	<li><a href="">Edit</a></li>
                      <li><a href="student.del?id=${s.studentid }">Remove</a></li>
                      
                    </ul>
                    </div>
									</td>

								</tr>
								<%sn++;%>
							</c:forEach>
						</tbody>
					</table> 
				</div>
			</div>
		</div>
	
	<jsp:include page="/msgmodal"></jsp:include>
	<script>

<%if(request.getAttribute("msg")!=null){%>
$('#myModal').modal('show');
<%}%>
/* function filterColumn ( i ) {
    $('#datatable-responsive').DataTable().column( i ).search(
        $('#col'+i+'_filter').val(),
        $('#col'+i+'_regex').prop('checked'),
        $('#col'+i+'_smart').prop('checked')
    ).draw();
}
 */
$(document).ready(function() {
    $('input.global_filter').on( 'keyup click', function () {
        filterGlobal();
    } );
 
    $('input.column_filter').on( 'keyup click', function () {
        filterColumn( $(this).parents('tr').attr('data-column') );
    } );
} );
</script>
</body>
</html>
<%}%>