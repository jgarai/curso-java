<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<h1>Dashboard</h1>


<div>
	<p>Delete user</p>
	<form action="dashboard" method="post">
		<input type="hidden" name="delete" value="true"><br> <input
			type="submit" value="delete user">

		<div>${error }</div>
		<div>${message }</div>
	</form>

	${email } ${password } ${user.email }
</div>



<%@ include file="/includes/footer.jspf"%>