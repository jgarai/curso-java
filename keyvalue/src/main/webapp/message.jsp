<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jspf"%>

<div class="container">
	<h2>message</h2>

	<c:choose>
		<c:when test="${message != null}">
			<div class="alert alert-info" role="alert">${message }</div>
		</c:when>

		<c:otherwise>
			<div class="alert alert-danger" role="alert">${error }</div>
		</c:otherwise>
	</c:choose>


</div>

<%@ include file="/includes/footer.jspf"%>