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
	<h3>Edit Set</h3>
	<div class="form-signin">
		<c:if test="${error != null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				${error }
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>
		<form action="set/edit-set" method="post">
			<input type="hidden" id="setid" name="setid" value="${setid }" />
			<div class="form-floating">
				<input type="text" class="form-control" id="setname" placeholder=""
					name="setname" value="${set.name }" /> <label for="floatingInput">Set's
					name</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="text" class="form-control" id="setdescription"
					placeholder="" name="setdescription" value="${set.description }">
				<label for="password">Description</label>
			</div>
			<br>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Send</button>
		</form>
	</div>
</div>
<%@ include file="/includes/footer.jspf"%>