<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>
<div class="container">
	<h3>List Keys</h3>
	<table class="table table-striped table-sm">
		<caption>List of Keys</caption>
		<thead class="table-light">
			<tr>
				<th class="col-1">Id</th>
				<th class="col-1">Set</th>
				<th class="col-1">Key</th>
				<th class="col-4">Value</th>
				<th class="col-3">CreatedAt</th>
				<th class="col-2">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${keys}" var="key">
				<tr>
					<td>${key.id}</td>
					<td>${key.setOwnerId}</td>
					<td>${key.key}</td>
					<td>${key.value}</td>
					<td>${key.dateTime()}</td>
					<td><a class="btn btn-primary btn-sm"
						href="set/edit-key?keyid=${key.id}" role="button"> edit</a> <a
						class="btn btn-danger btn-sm" data-bs-toggle="modal"
						data-bs-target="#delete-modal" href="set/delete-key?keyid=${key.id}" role="button">delete</a></td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>

<!-- Modal -->
<div class="modal fade" id="delete-modal" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">Are you sure?</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">This key/value is going to be delete
				from the data base</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">close</button>
				<a href="#" type="button" class="btn btn-danger">delete</a>
			</div>
		</div>
	</div>
</div>

<script>
	var confirmDelete = document.getElementById('delete-modal')
	confirmDelete.addEventListener('show.bs.modal', function(event) {
		var enlace = event.relatedTarget
		var href = enlace.getAttribute('href')
		var a = confirmDelete.querySelector('.modal-footer a')
		a.href = href;
	})
</script>

<%@ include file="/includes/footer.jspf"%>