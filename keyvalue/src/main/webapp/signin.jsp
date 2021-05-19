<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">

	<h2>Sign in</h2>

	<form action="signin" method="post">
		<p>Use este formulario para logearse en la aplicación</p>
		<div>
			<label for="email">Email</label> <input id="email" type="email"
				name="email" />
		</div>
		<div>
			<label for="password">Password</label> <input id="password"
				type="password" name="password" />
		</div>
		<div>
			<button>Send</button>
			${error }

		</div>
	</form>

</div>


<%@ include file="/includes/footer.jspf"%>