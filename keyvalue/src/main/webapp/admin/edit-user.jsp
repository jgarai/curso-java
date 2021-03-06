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

	<h2>ADMIN -> Edit USer</h2>
	<div class="form-signin">
		<c:if test="${error != null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				${error }
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

		</c:if>

		<form action="admin/edit-user" method="post" autocomplete="off">

			<input type="hidden" class="form-control" id="id" name="id"
				value="${user.id }" />
			<div class="form-floating">
				<input type="email" class="form-control" id="email"
					placeholder="name@example.com" name="email" value="${user.email }" />
				<label for="floatingInput">Email address</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					placeholder="Password" name="password" value="${user.password }" autocomplete="off">
				<label for="password">Password</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="text" class="form-control" id="name" placeholder="name"
					name="name" value="${user.name }"> <label for="name">Name</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="text" class="form-control" id="rol" placeholder="rol"
					name="rol" value="${user.rol }"> <label for="rol">Rol</label>
			</div>
			<br>

			<button class="w-100 btn btn-lg btn-primary" type="submit">Send</button>
		</form>
	</div>

</div>




</div>

<%@ include file="/includes/footer.jspf"%>