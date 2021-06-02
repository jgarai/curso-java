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
				<a class="btn btn-primary btn-sm" 
					href="crearcliente" role="button">Crear	Cliente</a>

			</div>
		</header>
	</div>
	

