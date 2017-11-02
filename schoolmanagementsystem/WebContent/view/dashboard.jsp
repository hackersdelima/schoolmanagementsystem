 <%@page import="com.controller.student.classes.StudentOperations" %>
  <%@page import='java.sql.*' %>
<%ResultSet userdetail=(ResultSet)session.getAttribute("userdetail");
StudentOperations s=new StudentOperations(userdetail.getString("companydb"));
String totalstd=s.totalstudents(); %>
<div class="row container">
	<div class="col-md-6">
		<div class="info-box">
			<span class="info-box-icon bg-yellow">
				<i class="fa fa-users"></i>
			</span>
			<div class="info-box-content">
				<span class="info-box-text">Total Admitted Students This Year</span>
				<span class="info-box-number"><%=totalstd%></span>
			</div>
		</div>
	</div>
	
</div>
<div class="row container">
	<div class="col-md-6">
		<div class="info-box">
			<span class="info-box-icon bg-green">
				<i class="fa fa-user"></i>
			</span>
			<div class="info-box-content">
				<span class="info-box-text">Your Detail</span>
				<span class="info-box-number">Username</span>
			</div>
		</div>
	</div>
</div>