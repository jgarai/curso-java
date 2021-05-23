<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">
	<h2>Sets</h2>

	<table class="table">
		<caption>List of sets</caption>

		<thead class="table-light">
			<tr>
				<th class="col-1">Id</th>
				<th	class="col-1">Owner</th>
				<th class="col-2">Name</th>
				<th class="col-6">Description</th>
				<th class="col-2">Actions</th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sets}" var="set">
				<tr>
					<td class="col-1">${set.id}</th>
					<td class="col-1">${set.owner_id}</td>
					<td  class="col-2">${set.name}</td>
					<td class="col-6">${set.description}</td>
					<td class="col-2">default | edit | delete</td>
		
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="/includes/footer.jspf"%>