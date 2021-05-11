<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora</title>
</head>
<body>

<%
String result = "";
if(request.getParameter("operator") != null && request.getParameter("left") != null && request.getParameter("right") != null){
	
	try {
		String operator = request.getParameter("operator");
		String left = request.getParameter("left");
		String right = request.getParameter("right");
		// addition
		if (operator.compareTo("+") == 0){
			int r = Integer.parseInt(left) + Integer.parseInt(right);
			result = "" + r;
		} 
		if (operator.compareTo("-") == 0){
			int r = Integer.parseInt(left) - Integer.parseInt(right);
			result = "" + r;
		} 
		if (operator.compareTo("*") == 0){
			int r = Integer.parseInt(left) * Integer.parseInt(right);
			result = "" + r;
		} 
		if (operator.compareTo("//") == 0){
			int r = Integer.parseInt(left) / Integer.parseInt(right);
			result = "" + r;
		} 
	} catch(NumberFormatException e){
		result = "NaN";
	} catch(ArithmeticException e){
		result = "Division by zero!";
	}
}
%>
<p><%= result %></p>

<form action="" method="POST">
<input name="left" type="text" value="">
<input name="right" type="text" value="">
<select name="operator"><option value="+">+</option>
  <option value="-">-</option>
  <option value="*">*</option>
  <option value="//">/</option></select>

<input type="submit" value="Submit">
</form>

</body>
</html>