<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">

	<h2>Dashboard</h2>


	<div>	<p>Cerrar sesión</p>
		<form action="signout" method="post">
			<input type="hidden" name="signout" value="true"><br>
			 <input
				type="submit" value="Sign Out">

			<div>${error }</div>
			<div>${message }</div>
		</form>
		<p>Delete user</p>
		<form action="dashboard" method="post">
			<input type="hidden" name="delete" value="true"><br> <input
				type="submit" value="delete user">

			<div>${error }</div>
			<div>${message }</div>
		</form>

		<div> ${user.email } | ${user.email } | ${user.email } | ${user }
		</div>
	</div>

</div>



<%@ include file="/includes/footer.jspf"%>