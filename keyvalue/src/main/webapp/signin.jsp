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

	<h2>Sign in</h2>
	<div class="form-signin">
		<c:if test="${error != null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				${error }
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

		</c:if>

		<form action="signin" method="post">
			<div class="form-floating">
				<input type="email" class="form-control" id="email"
					placeholder="name@example.com" name="email" /> <label
					for="email">Email address</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					placeholder="Password" name="password"> <label
					for="password">Password</label>
			</div>
			<br>

			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
		</form>



		<!-- 		<p>Use este formulario para logearse en la aplicación</p> -->
		<!-- 		<div> -->
		<!-- 			<label for="email">Email</label> <input id="email" type="email" -->
		<!-- 				name="email" /> -->
		<!-- 		</div> -->
		<!-- 		<div> -->
		<!-- 			<label for="password">Password</label> <input id="password" -->
		<!-- 				type="password" name="password" /> -->
		<!-- 			<button>Send</button> -->
		<%-- 			${error } --%>

		<!-- 		</div> -->

	</div>

</div>


<%@ include file="/includes/footer.jspf"%>