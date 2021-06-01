<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link
	href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css"
	rel="stylesheet" />

<base href="${pageContext.request.contextPath}/" />
</head>
<body>
	<div class="container">
		<header
			class="d-flex flex-wrap  justify-content-md-between py-3 mb-4 border-bottom">
			<ul class="nav col-12 col-md-auto mb-2  mb-md-0">
				<li><a href="" class="nav-link px-2 link-secondary">Inicio</a></li>
			</ul>
			<div class="col-md-5 text-end">
				<a class="btn btn-primary btn-sm" data-bs-toggle="modal"
					data-bs-target="#nuevo-cliente"
					href="crearcliente" role="button">Crear	Cliente</a>

			</div>
		</header>
	</div>
	

<!-- Modal -->
<div class="modal fade" id="nuevo-cliente" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Nuevo cliente</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="crearcliente" method="post">
				  <div class="mb-3">
				    <label for="nombre" class="form-label">Nombre</label>
				    <input type="text" class="form-control" id="nombre" name="nombre">
				  </div>
				  <div class="mb-3">
				    <label for="apellido" class="form-label">Apellido</label>
				    <input type="text" class="form-control" id="apellido" name="apellido">
				  </div>
				  <div class="mb-3">
				    <label for="telefono" class="form-label">Teléfono</label>
				    <input type="text" class="form-control" id="telefono" name="telefono">
				  </div>
				  <div class="mb-3">
				    <label for="email" class="form-label">Correo electrónico</label>
				    <input type="email" class="form-control" id="email" name="email" >
			
				  </div>
				  <div class="mb-3">
				    <label for="saldo" class="form-label">Saldo</label>
				    <input type="text" class="form-control" id="saldo" name="saldo">
				  </div>
		
			
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Enviar</button>
					</form>
				</div>
    </div>
  </div>
</div>