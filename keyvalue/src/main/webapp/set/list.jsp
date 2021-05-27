<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>



<div class="container">

	<h2>List Keys</h2>
	${param.setid }
		<table class="table">
		<caption>List of Keys</caption>

		<thead class="table-light">
			<tr>
				<th class="col-1">Id</th>
				<th	class="col-1">Set</th>
				<th class="col-1">Key</th>
				<th class="col-4">Value</th>
				<th class="col-3">CreatedAt</th>
				<th class="col-2">Actions</th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${keys}" var="key">
			
				<tr>
					<td >${key.id}</td>
					<td >${key.setOwnerId}</td>
					<td >${key.key}</td>
					<td >${key.value}</td>
					<td >${key.dateTime()}</td>
					<td ><a class="btn btn-primary btn-sm" href="key/edit?keyid=${key.id}" role="button"> edit</a>
				
					<a class="btn btn-danger btn-sm" href="key/delete?keyid=${key.id}" role="button"> delete </a>
					</td>
		
				</tr>
			</c:forEach>
		</tbody>
	</table>




</div>

<%@ include file="/includes/footer.jspf"%>