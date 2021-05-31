<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<style type="text/css" scoped>
.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}
</style>

<div class="container">
	<h3>Dashboard</h3>
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab"
				data-bs-target="#nav-home" type="button" role="tab"
				aria-controls="nav-home" aria-selected="false">Cambiar
				nombre</button>
			<button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab"
				data-bs-target="#nav-profile" type="button" role="tab"
				aria-controls="nav-profile" aria-selected="false">Cerrar
				sesión</button>
			<button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab"
				data-bs-target="#nav-contact" type="button" role="tab"
				aria-controls="nav-contact" aria-selected="false">Borrar
				cuenta</button>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">
			<div class="form-signin">
				<c:if test="${error != null}">
					<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						${error }
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				<form action="dashboard" method="post">
					<div class="form-floating">
						<input type="text" class="form-control" id="email"
							placeholder="nombre de usuario" name="change_name" /> <label
							for="email">Nuevo nombre de usuario</label>
					</div>
					<br>
					<button class="w-100 btn btn-lg btn-primary" type="submit">Send</button>
				</form>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-profile" role="tabpanel"
			aria-labelledby="nav-profile-tab">
			<div class="form-signin">
				<form action="signout" method="post">
					<div class="form-floating">
						<input type="hidden" name="signout" value="true"> <br>
						<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
							Out</button>
					</div>
				</form>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-contact" role="tabpanel"
			aria-labelledby="nav-contact-tab">
			<div class="form-signin">
				<div>${error }</div>
				<div>${message }</div>
				<form action="dashboard" method="post">
					<div class="form-floating">
						<input type="hidden" name="delete" value="true"> <br>
						<button class="w-100 btn btn-lg btn-danger" type="submit">Delete
							User</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="/includes/footer.jspf"%>