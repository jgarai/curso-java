<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">

	<h2>Sign up</h2>

	<form action="signup" method="post">
		<p>Use este formulario para registarse</p>
		<div>
			<label for="email">Email</label> <input id="email" type="email"
				name="email" />
		</div>
		<div>
			<label for="password">Password</label> <input id="password"
				type="password" name="password" />
		</div>
		<div>${error }</div>
		<div>
			<button>Send</button>

		</div>
	</form>

</div>

<%@ include file="/includes/footer.jspf"%>