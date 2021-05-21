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

	<h2>Sign up</h2>
	<div class="form-signin">
	<c:if test="${error != null}">
		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			${error }
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>

	</c:if>

	<form action="signup" method="post">
		<div class="form-floating">
			<input type="email" class="form-control" id="email"
				placeholder="name@example.com" name="email" /> <label
				for="floatingInput">Email address</label>
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
	</div>

	<!-- 	<form action="signup" method="post"> -->
	<!-- 		<p>Use este formulario para registarse</p> -->
	<!-- 		<div> -->
	<!-- 			<label for="email">Email</label> <input id="email" type="email" -->
	<!-- 				name="email" /> -->
	<!-- 		</div> -->
	<!-- 		<div> -->
	<!-- 			<label for="password">Password</label> <input id="password" -->
	<!-- 				type="password" name="password" /> -->
	<!-- 		</div> -->
	<%-- 		<div>${error }</div> --%>
	<!-- 		<div> -->
	<!-- 			<button>Send</button> -->

	<!-- 		</div> -->
	<!-- 	</form> -->

</div>

<%@ include file="/includes/footer.jspf"%>