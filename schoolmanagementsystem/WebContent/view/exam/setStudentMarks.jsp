<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#datatable-buttons input{
	border:none;
	width: 100%;
	}
</style>
<table id="datatable-buttons"
	class="table jambo_table table-striped table-bordered dt-responsive nowrap display"
	cellspacing="0" width="100%" style="font-size: 95%;'">
	<thead>

		<tr class="headings">
			<th>SUBJECT NAME</th>
			<th>SUBJECT TYPE</th>
			<th>TH. MARKS</th>
			<th>PR. MARKS</th>
			<th>FULL MARKS</th>
			<th>PASS MARKS</th>
			<th>MARKS OBTAINED</th>
			<th>GRADE OBTAINED</th>
			<th>REMARKS</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${subjectslist }" var="sublist">
		<tr>
			<td><input type="text" name="subid" value="${sublist.subjectid }" hidden>${sublist.subjectname }</td>
			<td><input type="text" name="subtype" value="${sublist.subjecttype }" hidden>${sublist.subjecttype }</td>
			<td><input type="text" name="thmarks" class="form-control"/></td>
			<td><input type="text" name="prmarks" class="form-control" /></td>
			<td><input type="text" name="fullmarks" class="form-control" /></td>
			<td><input type="text" name="passmarks" class="form-control" /></td>
			<td><input type="text" name="totalmarks" class="form-control" /></td>
			<td><input type="text" name="totalgrade" class="form-control" /></td>
			<td><input type="text" name="remarks" class="form-control" /></td>
		</tr>
	</c:forEach>
	</tbody>
	
</table>