<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.controller.student.classes.StudentOperations"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%
	if ((session.getAttribute("userdetail")) != null) {
%>
<%
	StudentOperations s = new StudentOperations();
		ResultSet districts = s.districts();
		ResultSet disablelist = s.disabletypelist();
		ResultSet language = s.getlanguage();
		ResultSet caste = s.getcaste();
		ResultSet section = s.getsection();
		ResultSet housegroup = s.gethousegroup();
		ResultSet specialinterest = s.getspecialinterest();
		ResultSet classlist = s.selectclass();
%>
<jsp:include page="/includefile"></jsp:include>
<html>
<head>
</head>
<body class="background">
	<div class="breadcrumb-line">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><i class="fa fa-home"
					aria-hidden="true"></i>&nbsp;<a href="#">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Student</li>
				<li class="breadcrumb-item active" aria-current="page">Student
					Admission</li>
			</ol>
		</nav>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>STUDENT REGISTRATION</h2>

				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
				</ul>
				<form method="post" action="studentregistration" id="form"></form>
				<button type="submit" class="btn btn-success " form="form">
					<i class="fa fa-check"></i> SUBMIT
				</button>
				<div class="clearfix"></div>

			</div>
			<div class="x_content">
				<div class="" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
						<li role="presentation" class="active"><a
							href="#tab_content1" id="home-tab" role="tab" data-toggle="tab"
							aria-expanded="true">Personal Details</a></li>
						<li role="presentation" class=""><a href="#tab_content2"
							role="tab" id="profile-tab" data-toggle="tab"
							aria-expanded="false">Father Details</a></li>
						<li role="presentation" class=""><a href="#tab_content3"
							role="tab" id="profile-tab2" data-toggle="tab"
							aria-expanded="false">Mother Details</a></li>
						<li role="presentation" class=""><a href="#tab_content4"
							role="tab" id="profile-tab3" data-toggle="tab"
							aria-expanded="false">Local Guardian Details</a></li>
						<li role="presentation" class=""><a href="#tab_content5"
							role="tab" id="profile-tab4" data-toggle="tab"
							aria-expanded="false">Academic Details</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade active in"
							id="tab_content1" aria-labelledby="home-tab">
							<table class="table">
								<tbody>
									<tr>
										<td>
											<h6>
												<strong>Student Legacy ID</strong>
											</h6> <input type="text" class="form-control" name="LegacyId"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Student Name</strong>
											</h6> <input type="text" class="form-control" name="studentname"
											id="studentname" form="form" required>
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Sex</strong>
											</h6> <select class="form-control" name="sex" form="form">
												<option value="" selected>Select sex</option>
												<option value="m">Male</option>
												<option value="f">FeMale</option>
												<option value="o">Other</option>
										</select>
										</td>
										<td>
											<h6>
												<strong>Mother Language</strong>
											</h6> <select class="form-control" name="Language" form="form">
												<option value="" selected>Select mother language</option>
												<%
													while (language.next()) {
												%>
												<option value="<%=language.getString(2)%>"><%=language.getString(2)%></option>
												<%
													}
												%>
										</select>
										</td>
										<td>
											<h6>
												<strong>Ethnic Group</strong>
											</h6> <select class="form-control" name="SCast" form="form">
												<option value="" selected>Select ethnic group</option>
												<%
													while (caste.next()) {
												%>
												<option value="<%=caste.getString(2)%>"><%=caste.getString(2)%></option>
												<%
													}
												%>
										</select>
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Religion</strong>
											</h6> <select class="form-control" name="SReligion" form="form">
												<option value="" selected>Select religion</option>
												<option value="Hindu">Hindu</option>
												<option value="Muslim">Muslim</option>
												<option value="Buddhism">Buddhism</option>
												<option value="Christian">Christian</option>
										</select>
										</td>
										<td>
											<h6>
												<strong>Differently-able?</strong>
											</h6> <select class="form-control" name="DisabledYN" form="form">
												<option value="n">No</option>
												<option value="y">Yes</option>
										</select>
										</td>
										<td>
											<h5 style="color: blue">
												<strong>If Differently-able yes</strong>
												</h6>
												<select class="form-control" name="DisableType" form="form">
													<option value="" selected>Select disabled type</option>
													<%
														while (disablelist.next()) {
													%>
													<option value="<%=disablelist.getString(1)%>"><%=disablelist.getString(2)%></option>
													<%
														}
													%>
												</select>
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>DOB(YYYY-MM-DD) B.S.</strong>
											</h6> <input type="text" class="form-control dob" name="dob"
											maxlength="10" id="nepaliDate1" onblur="nepaliToEnglish('.dob','.doben')" form="form"
											placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>DOB(YYYY-MM-DD) A.D.</strong>
											</h6> <input type="text" class="form-control doben" name="doben" onblur="englishToNepali('.dob','.doben')"
											maxlength="10" form="form" id="englishDate1"
											placeholder="1994-11-11">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Admission Date(YYYY-MM-DD) B.S.</strong>
											</h6> <input type="text" class="form-control admdate" name="admissiondate" onblur="nepaliToEnglish('.admdate','.admdateen')"
											maxlength="10" id="nepaliDate14" form="form"
											placeholder="2051-07-25" required>
										</td>
										<td>
											<h6>
												<strong>Admission Date(YYYYMMDD) A.D.</strong>
											</h6> <input type="text" class="form-control admdateen" onblur="englishToNepali('.admdate','.admdateen')"
											name="admissiondateen" maxlength="10" form="form"
											id="englishDate14" placeholder="1994-11-11" required>
										</td>
									</tr>

									<tr>
										<td>
											<h4 style="text-decoration: underline;">
												<strong>Birth Certificate Detail:-</strong>
											</h4>
											<hr>
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Birth Certificate No.</strong>
											</h6> <input type="text" class="form-control"
											name="birthcertificateno" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued By</strong>
											</h6> <input type="text" class="form-control"
											name="birthcertificateissuedby" form="form">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Issued Date(YYYYMMDD) B.S.</strong>
											</h6> <input type="text" class="form-control idate" onblur="nepaliToEnglish('.idate','.idateen')"
											name="birthcertificateissueddate" maxlength="10"
											id="nepaliDate2" form="form" placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>Issued Date(YYYYMMDD) A.D.</strong>
											</h6> <input type="text" class="form-control idateen" onblur="englishToNepali('.idate','.idateen')"
											name="birthcertificateissueddateen" maxlength="10"
											form="form" id="englishDate2" placeholder="1994-11-11">
										</td>
									</tr>
									<tr>
										<td>
											<h4 style="text-decoration: underline;">
												<strong>Contact Details:</strong>
											</h4>
											<hr>
										</td>
									</tr>

									<tr>
										<td>
											<h6>
												<strong>District</strong>
											</h6> <select class="form-control selectpicker district"
											data-show-subtext="true" data-live-search="true"
											name="District" form="form">
												<option value="" selected>Select district</option>
												<%
													while (districts.next()) {
												%>
												<option value="<%=districts.getString(1)%>"><%=districts.getString(2)%></option>
												<%
													}
												%>
										</select>
										</td>
										<td>
											<h6>
												<strong>Municipality or Village Council</strong>
											</h6> <select class="form-control vdcmun" name="VdcMun"
											form="form">
												<option value="" selected>Select muncipality or VDC</option>
										</select>
										</td>
										<td>
											<h6>
												<strong>Ward No.</strong>
											</h6> <select class="form-control wardno" name="WardNo"
											form="form">
												<option value="0" selected>Select ward no.</option>
										</select>
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Tole</strong>
											</h6> <input type="text" class="form-control" name="tole"
											form="form">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Temp. Address</strong>
											</h6> <input type="text" class="form-control" name="tempaddress"
											form="form">
										</td>
									</tr>

								</tbody>
							</table>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab_content2"
							aria-labelledby="profile-tab">
							<table class="table">
								<tbody>
									<tr>
										<td><h4 style="text-decoration: underline">
												<strong>Father's Detail</strong>
											</h4></td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Name</strong>
											</h6> <input type="text" class="form-control" name="fathername"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Address</strong>
											</h6> <input type="text" class="form-control" name="faddress"
											form="form">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Name of Office</strong>
											</h6> <input type="text" class="form-control" name="foffice"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Office Position</strong>
											</h6> <input type="text" class="form-control" name="fposition"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Expected Annual Income</strong>
											</h6> <input type="text" class="form-control" name="fincome"
											value="0" form="form">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Mobile No.</strong>
											</h6> <input type="text" class="form-control" maxlength="10"
											name="fmobile" form="form" value="0">
										</td>
										<td>
											<h6>
												<strong>Telephone No.</strong>
											</h6> <input type="text" class="form-control" maxlength="10"
											name="ftelephone" form="form" value="0">
										</td>
										<td>
											<h6>
												<strong>Email ID</strong>
											</h6> <input type="email" class="form-control" name="femail"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Emergency Contact No.</strong>
											</h6> <input type="text" class="form-control" name="fephone"
											maxlength="10" form="form" value="0">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Citizenship No.</strong>
											</h6> <input type="text" class="form-control"
											name="fcitizenshipno" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued By</strong>
											</h6> <input type="text" class="form-control"
											name="fcitizenshipissuedby" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued Date B.S.</strong>
											</h6> <input type="text" class="form-control idatea" onblur="nepaliToEnglish('.idatea','.idateena')"
											name="fcitizenshipissueddate" maxlength="10" id="nepaliDate3"
											form="form" placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>Issued Date A.D.</strong>
											</h6> <input type="text" class="form-control idateena" onblur="englishToNepali('.idatea','.idateena')"
											name="fcitizenshipissueddateen" maxlength="10" form="form"
											id="englishDate3" placeholder="1994-11-11">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>License No.</strong>
											</h6> <input type="text" class="form-control" name="flicenseno"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Issued By</strong>
											</h6> <input type="text" class="form-control"
											name="flicenseissuedby" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued Date B.S.</strong>
											</h6> <input type="text" class="form-control  ia" onblur="nepaliToEnglish('.ia','.iea')"
											name="flicenseissueddate" maxlength="10" id="nepaliDate4"
											form="form" placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>Issued Date A.D.</strong>
											</h6> <input type="text" class="form-control  iea" onblur="englishToNepali('.ia','.iea')"
											name="flicenseissueddateen" maxlength="10" form="form"
											id="englishDate4" placeholder="1994-11-11">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Official Identity No.</strong>
											</h6> <input type="text" class="form-control" name="fofficialidno"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Issued By</strong>
											</h6> <input type="text" class="form-control"
											name="fofficialidissuedby" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued Date B.S.</strong>
											</h6> <input type="text" class="form-control issueddate3" onblur="nepaliToEnglish('.issueddate3','.issueddateen3')"
											name="fofficialidissueddate" maxlength="10" id="nepaliDate5"
											form="form" placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>Issued Date A.D.</strong>
											</h6> <input type="text" class="form-control  issueddateen3" onblur="englishToNepali('.issueddate3','.issueddateen3')"
											name="fofficialidissueddateen" maxlength="10" form="form"
											id="englishDate5" placeholder="1994-11-11">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Voter ID No.</strong>
											</h6> <input type="text" class="form-control" name="fvoteridno"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Issued By</strong>
											</h6> <input type="text" class="form-control"
											name="fvoteridissuedby" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued Date B.S.</strong>
											</h6> <input type="text" class="form-control issueddate4" onblur="nepaliToEnglish('.issueddate4','.issueddateen4')"
											name="fvoteridissueddate" maxlength="10" id="nepaliDate6"
											form="form" placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>Issued Date A.D.</strong>
											</h6> <input type="text" class="form-control issueddateen4" onblur="englishToNepali('.issueddate4','.issueddateen4')"
											name="fvoteridissueddateen" maxlength="10" form="form"
											id="englishDate6" placeholder="1994-11-11">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Passport No.</strong>
											</h6> <input type="text" class="form-control" name="fpassportno"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Issued By</strong>
											</h6> <input type="text" class="form-control"
											name="fpassportissuedby" form="form">
										</td>
										<td>
											<h6>
												<strong>Issued Date B.S.</strong>
											</h6> <input type="text" class="form-control issueddate5" onblur="nepaliToEnglish('.issueddate5','.issueddateen5')"
											name="fpassportissueddate" maxlength="10" id="nepaliDate7"
											form="form" placeholder="2051-07-25">
										</td>
										<td>
											<h6>
												<strong>Issued Date A.D.</strong>
											</h6> <input type="text" class="form-control issueddateen5" onblur="englishToNepali('.issueddate5','.issueddateen5')"
											name="fpassportissueddateen" maxlength="10" form="form"
											id="englishDate7" placeholder="1994-11-11">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab_content3"
							aria-labelledby="profile-tab">
							<table class="table">
								<tr>
									<td>
										<h4 style="text-decoration: underline;">
											<strong>Mother's Detail</strong>
										</h4>
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Name</strong>
										</h6> <input type="text" class="form-control" name="mothername"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Address</strong>
										</h6> <input type="text" class="form-control" name="maddress"
										form="form">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Name of Office</strong>
										</h6> <input type="text" class="form-control" name="moffice"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Office Position</strong>
										</h6> <input type="text" class="form-control" name="mposition"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Expected Annual Income</strong>
										</h6> <input type="text" class="form-control" name="mincome"
										value="0" form="form">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Mobile No.</strong>
										</h6> <input type="text" class="form-control" maxlength="10"
										name="mmobile" form="form" value="0">
									</td>
									<td>
										<h6>
											<strong>Telephone No.</strong>
										</h6> <input type="text" class="form-control" maxlength="10"
										name="mtelephone" form="form" value="0">
									</td>
									<td>
										<h6>
											<strong>Email ID</strong>
										</h6> <input type="email" class="form-control" name="memail"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Emergency Contact No.</strong>
										</h6> <input type="text" class="form-control" maxlength="10"
										name="mephone" form="form" value="0">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Citizenship No.</strong>
										</h6> <input type="text" class="form-control" name="mcitizenshipno"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Issued By</strong>
										</h6> <input type="text" class="form-control"
										name="mcitizenshipissuedby" form="form">
									</td>
									<td>
										<h6>
											<strong>Issued Date B.S.</strong>
										</h6> <input type="text" class="form-control issueddate6" onblur="nepaliToEnglish('.issueddate6','.issueddateen6')"
										name="mcitizenshipissueddate" maxlength="10" id="nepaliDate8"
										form="form" placeholder="2051-07-25">
									</td>
									<td>
										<h6>
											<strong>Issued Date A.D.</strong>
										</h6> <input type="text" class="form-control issueddateen6" onblur="englishToNepali('.issueddate6','.issueddateen6')"
										name="mcitizenshipissueddateen" maxlength="10" form="form"
										id="englishDate8" placeholder="1994-11-11">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>License No.</strong>
										</h6> <input type="text" class="form-control" name="mlicenseno"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Issued By</strong>
										</h6> <input type="text" class="form-control"
										name="mlicenseissuedby" form="form">
									</td>
									<td>
										<h6>
											<strong>Issued Date B.S.</strong>
										</h6> <input type="text" class="form-control issueddate7" onblur="nepaliToEnglish('.issueddate7','.issueddateen7')"
										name="mlicenseissueddate" maxlength="10" id="nepaliDate9"
										form="form" placeholder="2051-07-25">
									</td>
									<td>
										<h6>
											<strong>Issued Date A.D.</strong>
										</h6> <input type="text" class="form-control issueddateen7" onblur="englishToNepali('.issueddate7','.issueddateen7')"
										name="mlicenseissueddateen" maxlength="10" form="form"
										id="englishDate9" placeholder="1994-11-11">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Official Identity No.</strong>
										</h6> <input type="text" class="form-control" name="mofficialidno"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Issued By</strong>
										</h6> <input type="text" class="form-control"
										name="mofficialidissuedby" form="form">
									</td>
									<td>
										<h6>
											<strong>Issued Date B.S.</strong>
										</h6> <input type="text" class="form-control issueddate8" onblur="nepaliToEnglish('.issueddate8','.issueddateen8')"
										name="mofficialidissueddate" maxlength="10" id="nepaliDate10"
										form="form" placeholder="2051-07-25">
									</td>
									<td>
										<h6>
											<strong>Issued Date A.D.</strong>
										</h6> <input type="text" class="form-control issueddateen8" onblur="englishToNepali('.issueddate8','.issueddateen8')"
										name="mofficialidissueddateen" maxlength="10" form="form"
										id="englishDate10" placeholder="1994-11-11">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Voter ID No.</strong>
										</h6> <input type="text" class="form-control" name="mvoteridno"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Issued By</strong>
										</h6> <input type="text" class="form-control"
										name="mvoteridissuedby" form="form">
									</td>
									<td>
										<h6>
											<strong>Issued Date B.S.</strong>
										</h6> <input type="text" class="form-control issueddate9" onblur="nepaliToEnglish('.issueddate9','.issueddateen9')"
										name="mvoteridissueddate" maxlength="10" id="nepaliDate11"
										form="form" placeholder="2051-07-25">
									</td>
									<td>
										<h6>
											<strong>Issued Date A.D.</strong>
										</h6> <input type="text" class="form-control issueddateen9" onblur="englishToNepali('.issueddate9','.issueddateen9')"
										name="mvoteridissueddateen" maxlength="10" form="form"
										id="englishDate11" placeholder="1994-11-11">
									</td>
								</tr>
								<tr>
									<td>
										<h6>
											<strong>Passport No.</strong>
										</h6> <input type="text" class="form-control" name="mpassportno"
										form="form">
									</td>
									<td>
										<h6>
											<strong>Issued By</strong>
										</h6> <input type="text" class="form-control"
										name="mpassportissuedby" form="form">
									</td>
									<td>
										<h6>
											<strong>Issued Date B.S.</strong>
										</h6> <input type="text" class="form-control issueddate10" onblur="nepaliToEnglish('.issueddate10','.issueddateen10')"
										name="mpassportissueddate" maxlength="10" id="nepaliDate12"
										form="form" placeholder="2051-07-25">
									</td>
									<td>
										<h6>
											<strong>Issued Date A.D.</strong>
										</h6> <input type="text" class="form-control issueddateen10" onblur="englishToNepali('.issueddate10','.issueddateen10')"
										name="mpassportissueddateen" maxlength="10" form="form"
										id="englishDate12" placeholder="1994-11-11">
									</td>
								</tr>
								</tbody>
							</table>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab_content4"
							aria-labelledby="profile-tab">
							<table class="table">
								<tbody>
									<tr>
										<td>
											<h6>
												<strong>Name 1</strong>
											</h6> <input type="text" class="form-control" name="local1"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Relation Type 1</strong>
											</h6> <select class="form-control" name="relationtype1"
											form="form">
												<option value="" selected>Select relation type</option>
												<option value="Grand Father">Grand Father</option>
												<option value="Grand Mother">Grand Mother</option>
												<option value="Aunt">Aunt</option>
												<option value="Uncle">Uncle</option>
												<option value="Sister">Sister</option>
												<option value="Brother">Brother</option>
												<option value="Cousin">Cousin</option>
												<option value="Nephew">Nephew</option>
												<option value="Sister in law">Sister in law</option>
												<option value="Brother in law">Brother in law</option>
												<option value="Daughter in law">Daughter in law</option>
												<option value="Son in law">Son in law</option>
										</select>
										</td>
										<td>
											<h6>
												<strong>Address 1</strong>
											</h6> <input type="text" class="form-control" name="localadd1"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Mobile No. 1</strong>
											</h6> <input type="text" class="form-control" maxlength="10"
											name="localmob1" form="form" value="0">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Name 2</strong>
											</h6> <input type="text" class="form-control" name="local2"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Relation Type 2</strong>
											</h6> <select class="form-control" name="relationtype2"
											form="form">
												<option selected value="">Select relation type</option>
												<option value="Grand Father">Grand Father</option>
												<option value="Grand Mother">Grand Mother</option>
												<option value="Aunt">Aunt</option>
												<option value="Uncle">Uncle</option>
												<option value="Sister">Sister</option>
												<option value="Brother">Brother</option>
												<option value="Cousin">Cousin</option>
												<option value="Nephew">Nephew</option>
												<option value="Sister in law">Sister in law</option>
												<option value="Brother in law">Brother in law</option>
												<option value="Daughter in law">Daughter in law</option>
												<option value="Son in law">Son in law</option>
										</select>
										</td>
										<td>
											<h6>
												<strong>Address 2</strong>
											</h6> <input type="text" class="form-control" name="localadd2"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Mobile No. 2</strong>
											</h6> <input type="text" class="form-control" maxlength="10"
											name="localmob2" form="form" value="0">
										</td>
									</tr>

								</tbody>
							</table>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab_content5"
							aria-labelledby="profile-tab">
							<table class="table">
								<tbody>
									<tr>
										<td>
											<h6>
												<strong>Admission Class</strong>
											</h6> <select class="form-control" name="admissionclass"
											form="form" required>
												<option selected value="">Select admission class</option>
												<%
													while (classlist.next()) {
												%>
												<option value="<%=classlist.getString("classname")%>"><%=classlist.getString("classname")%></option>
												<%
													}
												%>
										</select>
										</td>
										<td>
											<h6>
												<strong>Section</strong>
											</h6> <select class="form-control" name="section" form="form">
												<option selected value="">Select section</option>
												<%
													while (section.next()) {
												%>
												<option value="<%=section.getString(2)%>"><%=section.getString(2)%></option>
												<%
													}
												%>
										</select>
										</td>
										<td>
											<h6>
												<strong>Roll No.</strong>
											</h6> <input type="text" class="form-control" name="rollno"
											form="form">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>House Group</strong>
											</h6> <select class="form-control" name="housegroup" form="form">
												<option value="" selected>Select house group</option>
												<%
													while (housegroup.next()) {
												%>
												<option value="<%=housegroup.getString(2)%>"><%=housegroup.getString(2)%></option>
												<%
													}
												%>
										</select>
										</td>
										<td>
											<h6>
												<strong>Previous School</strong>
											</h6> <input type="text" class="form-control" name="oldschool"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Reason For Leaving</strong>
											</h6> <input type="text" class="form-control" name="reasonleav"
											form="form">
										</td>
									</tr>
									<tr>
										<td>
											<h6>
												<strong>Hobby</strong>
											</h6> <input type="text" class="form-control" name="hobby"
											form="form">
										</td>
										<td>
											<h6>
												<strong>Special Interest</strong>
											</h6> <select class="form-control" name="specialinterest"
											form="form">
												<option value="" selected>Select special interest</option>
												<%
											while (specialinterest.next()) {
										%>
												<option value="<%=specialinterest.getString(2)%>"><%=specialinterest.getString(2)%></option>
												<%
											}
										%>
										</select>
										</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<jsp:include page="/msgmodal"></jsp:include>
	<script>
		
	<%if (request.getAttribute("msg") != null) {%>
		$('#myModal').modal('show');
	<%}%>
		$('#form').submit(function() {

			return confirm('CONFIRM REGISTRATION?'); // return false to cancel form action
		});
	</script>
</body>
</html>


<%
	}
%>