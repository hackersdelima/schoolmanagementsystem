<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table id="datatable-buttons"
	class="table jambo_table table-striped table-bordered dt-responsive nowrap display"
	cellspacing="0" width="100%" style="font-size: 95%;'">
	<thead>

		<tr class="headings">
			<th>SUBJECT NAME</th>
			<th>SUBJECT TYPE</th>
			<th>TH. MARKS</th>
			<th>PR. MARKS</th>
			<th>TOTAL MARKS</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${subjectslist }" var="sublist">
		<tr>
			<td>${sublist.subjectname }</td>
			<td>${sublist.subjecttype }</td>
			<td><input type="text" name="" class="form-control" /></td>
			<td><input type="text" name="" class="form-control" /></td>
			<td><input type="text" name="" class="form-control" /></td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>SUBJECT NAME</th>
			<th>SUBJECT TYPE</th>
			<th>TH. MARKS</th>
			<th>PR. MARKS</th>
			<th>TOTAL MARKS</th>
		</tr>
	</tfoot>
	<tbody>

	</tbody>
</table>