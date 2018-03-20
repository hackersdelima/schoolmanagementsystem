<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="import" href="include1.jsp">
<html>
<head>

<style>
.borderless tfoot tr td {
	border: none
}
</style>
</head>
<body class="container background">
	<div>
		<table class="table">
			<caption style="text-align: center">
				<h2>BRITISH MODAL COLLEGE</h2>
				<h4>Thapathali, Kathmandu (9856477854)</h4>
				<h4>
					<strong>1st Term Examination (2018)</strong>
				</h4>
			</caption>
			<tbody>
				<tr>
					<td>Name of Student: <strong>${stdDetail.studentname }</strong></td>
					<td>Class: <strong>${stdDetail.admissionclass }</strong></td>
					<td>Section: <strong>${stdDetail.section }</strong></td>
				</tr>
				<tr>
					<td>Roll No: <strong>${stdDetail.rollno }</strong>
					<td>
					<td>Admission No: <strong>${stdDetail.studentid }</strong></td>

					<td></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div>

		<table class="table table-striped table-bordered borderless">
			<thead>
				<tr>
					<th>Subject Name</th>
					<th>Subject Code</th>
					<th>Th. Marks</th>
					<th>Pr. Marks</th>
					<th>Total Marks</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>English</td>
					<td>EN1001</td>
					<td>60/75</td>
					<td>10/25</td>
					<td>70/100</td>
					<td>B+</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td>Result : <strong>Pass</strong></td>
					<td>Total: <strong>500/1000</strong></td>
				</tr>
				<tr>
					<td>Percentage : <strong>50.32%</strong></td>
					<td>Rank: <strong>NA</strong></td>
				</tr>
				<tr>
					<td>Date of Issue : <strong>2018-11-01</strong></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>