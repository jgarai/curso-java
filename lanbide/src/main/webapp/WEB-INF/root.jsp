<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
	<h3 class="display-8">Clientes</h3>
	<c:choose>
		<c:when test="${mensaje != null}">
			<div class="alert alert-info alert-dismissible fade show"
				role="alert">
				<i class="fas fa-check-square"></i> ${mensaje }
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${error != null}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<i class="fas fa-exclamation-triangle"></i> ${error }
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<table class="table table-striped table-sm ">
		<caption>Lista de clientes</caption>
		<thead class="table-light">
			<tr>
				<th class="col-1">Id</th>
				<th class="col-1">Nombre</th>
				<th class="col-2">Apellido</th>
				<th class="col-1">Teléfono</th>
				<th class="col-1">eMail</th>
				<th class="col-1" style="text-align: center">Saldo</th>
				<th class="col-2" style="text-align: center">Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nombre}</td>
					<td>${cliente.apellido}</td>
					<td>${cliente.telefono}</td>
					<td>${cliente.email}</td>
					<td style="text-align: right">${cliente.saldo}</td>
					<td style="text-align: right"><a
						class="btn btn-primary btn-sm"
						href="crearcliente?clienteid=${cliente.id}" role="button"><i
							class="fas fa-user-edit"></i> Editar</a> <a
						class="btn btn-danger btn-sm" data-bs-toggle="modal"
						data-bs-target="#delete-modal"
						href="borrarcliente?clienteid=${cliente.id}" role="button"><i
							class="fas fa-user-slash"></i> Borrar</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">¿Está seguro
						de la acción a realizar?</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">La ficha de este cliente va a ser
					borrada de la base de datos</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">
						<i class="fas fa-times"></i> Cerrar
					</button>
					<a href="#" type="button" class="btn btn-danger"><i
						class="fas fa-user-slash"></i> Borrar</a>
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
		var tooltipTriggerList = [].slice.call(document
				.querySelectorAll('[data-bs-toggle="tooltip"]'))
		var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
			return new bootstrap.Tooltip(tooltipTriggerEl)
		})
	</script>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>