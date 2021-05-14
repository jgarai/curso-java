<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest the Number</title>
</head>
<body >
<div style="text-align: center;">
<h1><a href="guest">Guest!</a></h1>
<h2>Adivina el número del 1 al 100!</h2>
<p>${message}</p>
<form action="guest" method="post">
		<input type="number" name="bet" ${disabled} autofocus >
		<input type="hidden" name="count" value="${tries}" >
		<button ${disabled}>Aceptar</button>
</form>
<p>Número de intentos: ${tries }</p>
<h2><a href="guest?reset=true">Reinicia el juego!</a></h2>
</div>
</body>
</html>