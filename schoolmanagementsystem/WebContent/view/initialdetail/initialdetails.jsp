<%@page import="com.controller.student.classes.StudentOperations" %>
<%@page import="java.sql.*" %>
<%if(session.getAttribute("userdetail")!=null){
%>
<%StudentOperations s=new StudentOperations();
ResultSet language=s.getlanguage();ResultSet section=s.getsection();
ResultSet housegroup=s.gethousegroup();ResultSet caste=s.getcaste(); 
ResultSet specialinterest=s.getspecialinterest();
ResultSet classlist=s.selectclass();
ResultSet examtype=s.selectexamtype();%>
<link rel="import" href="include.jsp">
<div class="background">
<div class="breadcrumb-line">
	<nav aria-label="breadcrumb" role="navigation">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Settings</li>
	    <li class="breadcrumb-item active" aria-current="page">Add/Edit Initial Details</li>
	  </ol>
	</nav>
</div>
<div class="panel panel-default" >
  		<div class="panel-heading">
  		<h4><strong>Add/Edit Initial Registration Form Details</strong></h4>
  		</div>
  		<div class="panel-body">
  			<ul class="nav nav-tabs ">
  				<li class="active"><a data-toggle="tab" data-target="#1" class="clickable">View Added Details</a></li>
			  <li ><a data-toggle="tab" data-target="#2" class="clickable">Add Details</a></li>
			  <li><a data-toggle="tab" data-target="#3" class="clickable">Edit Details</a></li>
			  
			</ul>
			<div class="tab-content">
			  	<div id="1" class="tab-pane fade in active">
			  		<table class="table">
				  		<caption>Inserted Initial Details</caption>
				  		<thead>
				  			<tr>
					  			<th>Languages</th>
					  			<th>Sections</th>
					  			<th>House Groups</th>
					  			<th>Ethnic Groups</th>
					  			<th>Special Interests</th>
					  			<th>Admission Class</th>
					  			<th>Exam Type</th>
				  			</tr>
				  		</thead>
			  			<tbody>
			  				<tr>
			  					<td>
				  					<ol>
					  					<%while(language.next()){ %>
					  					<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
					  					<%=language.getString("languagename") %>
					  					</li>
					  					<%} %>
				  					</ol>
			  					</td>
			  					<td>
			  						<ol>
			  							<%while(section.next()){ %>
			  							<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
			  							<%=section.getString("sectionname") %></li>
			  							<%} %>
			  						</ol>
			  					</td>
			  					<td>
			  						<ol>
			  							<%while(housegroup.next()){ %>
						  				<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
						  				<%=housegroup.getString("housegroupname") %></li>
						  				<%}%>
			  						</ol>
			  					</td>
			  					<td>
			  						<ol>
			  							<%while(caste.next()){ %>
						  				<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
						  				<%=caste.getString("castename") %></li>
						  				<%}%>
			  						</ol>
			  					</td>
			  					<td>
			  						<ol>
			  							<%while(specialinterest.next()){ %>
						  				<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
						  				<%=specialinterest.getString("specialinterestname") %></li>
						  				<%}%>
			  						</ol>
			  					</td>
			  					<td>
			  						<ol>
			  							<%while(classlist.next()){ %>
						  				<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
						  				<%=classlist.getString("classname") %></li>
						  				<%}%>
			  						</ol>
			  					</td>
			  					<td>
			  						<ol>
			  							<%while(examtype.next()){ %>
						  				<li><i class="fa fa-trash-o" aria-hidden="true" style="color:red"></i>
						  				<a href="" data-toggle="tooltip" title="<%=examtype.getString("description") %>" style="color:black;"><%=examtype.getString("examtypename") %></a></li>
						  				<%}%>
			  						</ol>
			  					</td>
			  				</tr>
			  			</tbody>
			  		</table>
			  	</div>
				<div id="2" class="tab-pane fade in">
				<br>
				  	<ul class="nav nav-tabs">
					  <li ><a data-toggle="tab" data-target="#a" class="clickable">Language</a></li>
					  <li><a data-toggle="tab" data-target="#b" class="clickable">Section</a></li>
					  <li><a data-toggle="tab" data-target="#c" class="clickable">House Group</a></li>
					  <li><a data-toggle="tab" data-target="#d" class="clickable">Ethnic Group</a></li>
					  <li><a data-toggle="tab" data-target="#e" class="clickable">Special Interest</a></li>
					   <li><a data-toggle="tab" data-target="#f" class="clickable">Academic Classes</a></li>
					    <li><a data-toggle="tab" data-target="#g" class="clickable">Exam Type</a></li>
					</ul>
					<div class="tab-content">
						<div id="a" class="tab-pane fade in ">
							<form action="initialdetailadd" method="post" style="width:20%;margin-top:10px;" class="form" >
								<h6><strong>Language Name:</strong></h6>
								<input type="text" class="form-control" name="languagename" placeholder="Language name..." required>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
						<div id="b" class="tab-pane fade in ">
							<form action="initialdetailadd" method="post" style="width:20%;margin-top:10px;" class="form">
								<h6><strong>Section Name:</strong></h6>
								<input type="text" class="form-control" name="sectionname" placeholder="Section name..." required>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
						<div id="c" class="tab-pane fade in ">
							<form action="initialdetailadd" method="post" style="width:20%;margin-top:10px;" class="form">
								<h6><strong>House Group Name:</strong></h6>
								<input type="text" class="form-control" name="housegroupname" placeholder="House Group name..." required>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
						<div id="d" class="tab-pane fade in ">
							<form action="initialdetailadd" method="post" style="width:20%;margin-top:10px;" class="form">
								<h6><strong>Ethnic Group Name:</strong></h6>
								<input type="text" class="form-control" name="castename" placeholder="Ethnic group name..." required>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
						<div id="e" class="tab-pane fade in ">
							<form action="initialdetailadd" method="post" style="width:20%;margin-top:10px;" class="form">
								<h6><strong>Special Interest Name:</strong></h6>
								<input type="text" class="form-control" name="specialinterestname" placeholder="Special interest name..." required>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
						<div id="f" class="tab-pane fade in ">
							<form action="initialdetailadd" method="post" style="width:20%;margin-top:10px;" class="form">
								<h6><strong>Academic Class Name:</strong></h6>
								<input type="text" class="form-control" name="classname" placeholder="Academic class name..." required>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
						<div id="g" class="tab-pane fade in ">
							<form action="examtype.add" method="post" style="width:20%;margin-top:10px;" class="form" id="examtypeform">
								<h6><strong>Exam Type Name:</strong></h6>
								<input type="text" class="form-control" name="examtypename" placeholder="Exam type name..." required><br>
								<h6><strong>Exam Type Description:</strong></h6>
								<textarea class="form-control" name="description" form="examtypeform" value="" rows="5"></textarea>
								<br><button type="submit" class="btn btn-success">+ ADD</button>
							</form>
						</div>
				</div>
			  </div>
			  <div id="3" class="tab-pane fade in">
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
<%if(request.getAttribute("msg")!=null){%>
$('#myModal').modal('show');
<%}%>
	$('.form').submit(function() {
	    return confirm('CONFIRM SUBMIT?'); 
	});
	$('[data-toggle="tooltip"]').tooltip();   
	</script>
<%}%>