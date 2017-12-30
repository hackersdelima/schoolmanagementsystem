 <%@page import="com.controller.student.classes.StudentOperations" %>
  <%@page import='com.school.model.UserModel'%>
<%UserModel userdetail=(UserModel)session.getAttribute("userdetail");
StudentOperations s=new StudentOperations();
String totalstd=s.totalstudents(); %>
<link rel="import" href="../include.jsp">
<link rel="import" href="include.jsp">
<div class="background">
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
					<span class="info-box-number"><%=userdetail.getUsername() %></span>
				</div>
			</div>
		</div>
	</div>
</div>