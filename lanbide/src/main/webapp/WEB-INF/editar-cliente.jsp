<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<style type="text/css" scoped>
.form-signin {
	width: 100%;
	max-width: 430px;
	padding: 15px;
	margin: auto;
}
</style>
<div class="container">
	<h3 class="display-6">Crear Cliente</h3>
	<c:choose>
		<c:when test="${mensaje != null}">
			<div class="alert alert-info alert-dismissible fade show"
				role="alert">${mensaje }
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
				role="alert">${error }
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<div class="form-signin">
		<form action="editarcliente" method="post">
			<input type="hidden" class="form-control" id="id" name="clienteid"
				value="${cliente.id}">
			<div class="mb-2">
				<label for="nombre" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="nombre" name="nombre"
					value="${cliente.nombre}">
			</div>
			<div class="mb-2">
				<label for="apellido" class="form-label">Apellido</label> <input
					type="text" class="form-control" id="apellido" name="apellido"
					value="${cliente.apellido}">
			</div>
			<div class="mb-2">
				<label for="telefono" class="form-label">Teléfono</label> <input
					type="text" class="form-control" id="telefono" name="telefono"
					value="${cliente.telefono}">
			</div>
			<div class="mb-2">
				<label for="email" class="form-label">Correo electrónico</label> <input
					type="email" class="form-control" id="email" name="email"
					value="${cliente.email}">
			</div>
			<div class="mb-2">
				<label for="saldo" class="form-label">Saldo</label> <input
					type="text" class="form-control" id="saldo" name="saldo"
					value="${cliente.saldo}">
			</div>
			<button type="button" class="btn btn-secondary"
				data-bs-dismiss="modal">Cancelar</button>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>

</div>


<%@ include file="/WEB-INF/includes/footer.jsp"%>