<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#datatable-buttons input{
	border:none;
	width: 100%;
	
	}
	#datatable-buttons th{
	text-align:center}
	caption{
	text-align:center;}
 
</style>
<table id="datatable-buttons"
	class="table table-striped table-bordered dt-responsive nowrap display">
	<thead>
		<tr>
			<th colspan="3" style="text-align:center">SUBJECT</th>
			<th colspan="2">FULL MARKS</th>
			<th colspan="2">PASS MARKS</th>
			<th colspan="3">OBTAINED MARKS</th>
			
			<th rowspan="2">REMARKS</th>
		</tr>
		<tr class="headings">
			<th>Name</th>
			<th>Code</th>
			<th>Type</th>
			
			<th>Th. Marks</th>
			<th>Pr. Marks</th>
			
			<th>Th. Marks</th>
			<th>Pr. Marks</th>
			
			<th>Th. Marks</th>
			<th>Pr. Marks</th>
			<th>Grade</th>
		</tr>
	</thead>
	<tbody>
	<caption>SET MARKS</caption>
	<c:forEach items="${subjectslist }" var="sublist">
		<tr>
			<td><input type="text" name="subid" value="${sublist.subjectid }" hidden>${sublist.subjectname }</td>
			<td>${sublist.subjectcode }</td>
			<td><input type="text" name="subtype" value="${sublist.subjecttype }" hidden>${sublist.subjecttype }</td>
			
			<td><input type="text" name="fullmarks" value="${sublist.fullmarks }"class="form-control" /></td>
				<td><input type="text" name="fullmarks_pr" value="${sublist.fullmarks_pr }"class="form-control" /></td>
				
			<td><input type="text" name="passmarks" value="${sublist.passmarks }" class="form-control" /></td>
			<td><input type="text" name="passmarks_pr" value="${sublist.passmarks_pr }" class="form-control" /></td>
			
			<td><input type="text" name="thmarks" class="form-control"/></td>
			<td><input type="text" name="prmarks" class="form-control" /></td>
			<td><input type="text" name="totalgrade" class="form-control" /></td>
			
			<td><input type="text" name="remarks" class="form-control" /></td>
		</tr>
	</c:forEach>
	</tbody>
	
</table>