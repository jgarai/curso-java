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
	<h3>Add Key</h3>
	<div class="form-signin">
	<c:if test="${error != null}">
		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			${error }
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<form action="set/add-key" method="post">
		<div class="form-floating">
			<input type="text" class="form-control" id="key"
				placeholder="" name="key" /> <label
				for="floatingInput">Key</label>
		</div>
		<br>
		<div class="form-floating">
			<input type="text" class="form-control" id="value"
				placeholder="" name="value"> <label
				for="password">Value</label>
		</div>
		<br>
		<input type="hidden" name="setid" value="${param.setid }">
		<button class="w-100 btn btn-lg btn-primary" type="submit">Send</button>
	</form>
	</div>
</div>
<%@ include file="/includes/footer.jspf"%>