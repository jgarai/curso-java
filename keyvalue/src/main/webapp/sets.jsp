<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">
	<h2>Sets</h2>
	
	<table class="table">
	
		<thead>
			<tr>
				<th>Id</th>
				<th>Owner</th>
				<th>Name</th>
				<th>Description</th>
				<th>Actions</th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sets}" var="set">
				<tr>
					<th>${set.id}</th>
					<td>${set.owner_id}</td>
					<td>${set.name}</td>
					<td>${set.description}</td>
					<td>default | edit | delete</td>
		
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="/includes/footer.jspf"%>