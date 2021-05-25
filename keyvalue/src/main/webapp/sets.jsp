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
				<th class="col-5">Description</th>
				<th class="col-3">Actions</th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sets}" var="set">
			
				<tr>
					<td >${set.id}</td>
					<td >${set.ownerId}</td>
					<td >${set.name}</td>
					<td >${set.description}</td>
					<td ><a class="btn btn-primary btn-sm" href="set/addkey?setid=${set.id}" role="button"> add key</a>
					<a class="btn btn-primary btn-sm" href="set/list?setid=${set.id}" role="button"> list </a>  
						<a class="btn btn-primary btn-sm" href="set/edit?setid=${set.id}" role="button"> edit </a> 
					<a class="btn btn-danger btn-sm" href="set/delete?setid=${set.id}" role="button"> delete </a>
					</td>
		
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="/includes/footer.jspf"%>