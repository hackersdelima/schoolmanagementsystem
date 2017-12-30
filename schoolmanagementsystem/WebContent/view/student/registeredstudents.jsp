<%@page import="com.controller.student.classes.StudentOperations" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<% if((session.getAttribute("userdetail"))!=null){
	%>
<link rel="import" href="include.jsp">
<div class="background">
<div class="breadcrumb-line">
	<nav aria-label="breadcrumb" role="navigation">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Student</li>
	    <li class="breadcrumb-item active" aria-current="page">Student List</li>
	  </ol>
	</nav>
</div>
<div class="row">
<div class="col-sm-2">
<div class="panel panel-default" style="width:100%;">
	<div class="panel-heading"><h4 class="panel-title"><strong>Specific Search</strong></h4></div>
	<div class="panel-body">
		<table cellpadding="3" cellspacing="0" border="0" >
	        <tbody>
	            <tr id="filter_col2" data-column="1">
	                <td align="center"><input type="text" class="column_filter form-control" placeholder="Student Name..." id="col1_filter"><br></td>
	            </tr>
	            <tr id="filter_col3" data-column="2">
	                <td align="center"><input type="text" class="column_filter form-control" placeholder="Roll No..." id="col2_filter"><br></td>
	            </tr>
	            <tr id="filter_col4" data-column="3">
	                <td align="center"><input type="text" class="column_filter form-control" placeholder="Class..." id="col3_filter"></td>
	            </tr>
	        </tbody>
		</table>
	</div>
</div>
</div>
<div class="col-sm-10">
<div class="panel panel-default" style="width:100%;">
	<div class="panel-heading"><h4 class="panel-title"><strong>Student List</strong></h4>
	</div>
	<div class="panel-body">
			<table class="table table-striped table-bordered table-hover display" cellspacing="0" width="100%" id="table" >
										<thead>
											<tr>
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
										<tbody id="example">
			<%
			StudentOperations s=new StudentOperations();
			ResultSet rs=s.studentDetails();
			int sn=1;
			
			while(rs.next())
			{
			%>
											<tr>
												<th scope="row"><%=sn %></th>
												<td><%if (rs.getString("studentname").equals("null")){out.print("");}else{ %><%=rs.getString("studentname") %><%} %></td>
												<td><%if (rs.getString("rollno").equals("null")){out.print("");}else{ %><%=rs.getString("rollno") %><%} %></td>
												<td><%if (rs.getString("admissionclass").equals("null")){out.print("");}else{ %><%=rs.getString("admissionclass") %><%} %></td>
												<td><%if (rs.getString("section").equals("null")){ out.print("");}else{ %><%=rs.getString("section") %><%} %></td>
												<td><%if (rs.getString("studentid").equals("null")){ out.print("");}else{ %><%=rs.getString("studentid") %><%} %></td>
												<td><%=rs.getString("admissiondate") %></td>
												<td><div class="dropdown">
				    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Action
				    <span class="caret"></span></button>
				    <ul class="dropdown-menu">
				      <li><a href="<%-- studentdetail?id=<%=rs.getInt("studentid") %>&db=<%=userdetail.getString("companydb") %> --%>">See Detail</a></li>
				    </ul>
				  </div></td>
												
												</tr>
											<%sn++;}%>
				</tbody>
			</table>
	</div>
</div>
</div>
</div>
</div>
<script>

 
function filterColumn ( i ) {
    $('#table').DataTable().column( i ).search(
        $('#col'+i+'_filter').val(),
        $('#col'+i+'_regex').prop('checked'),
        $('#col'+i+'_smart').prop('checked')
    ).draw();
}
 
$(document).ready(function() {
	 
    $('#table').DataTable();
 
    $('input.global_filter').on( 'keyup click', function () {
        filterGlobal();
    } );
 
    $('input.column_filter').on( 'keyup click', function () {
        filterColumn( $(this).parents('tr').attr('data-column') );
    } );
} );
</script>
<%}%>