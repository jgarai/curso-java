<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">
	<h2>Admin - Users</h2>

	<table class="table">
		<caption>List Users</caption>

		<thead class="table-light">
			<tr>
				<th class="col-1">Id</th>
				<th	class="col-2">Email</th>
				<th	class="col-3">Hash</th>
				<th class="col-2">Name</th>
				<th class="col-1">rol</th>
				<th class="col-2">Actions</th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
					
			
				<tr>
					<td >${user.id}</td>
					<td >${user.email}</td>
					<td >${user.password}</td>
					<td >${user.name}</td>
					<td >${user.rol}</td>
					<td >
					<a class="btn btn-primary btn-sm" href="admin/user/edit?id=${user.id}" role="button"> edit </a> 
					<a class="btn btn-danger btn-sm" href="admin/user/delete?id=${user.id}" role="button"> delete </a>
					</td>
		
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="/includes/footer.jspf"%>