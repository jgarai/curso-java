<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
<%

String left ="";
String right ="";
String operator = "";

if (request.getParameter("right") != null ) {
	right = request.getParameter("right");
}
if (request.getParameter("left") != null ) {
	left = request.getParameter("left");
}
if (request.getParameter("operator") != null ) {
	operator = request.getParameter("operator");
}
if (request.getParameter("equals") != null) {
	try{
		if (operator.compareTo("+") == 0){
			int r = Integer.parseInt(left) + Integer.parseInt(right);
			right = "" + r;
		} 
		if (operator.compareTo("-") == 0){
			int r = Integer.parseInt(left) - Integer.parseInt(right);
			right = "" + r;
		} 
		if (operator.compareTo("*") == 0){
			int r = Integer.parseInt(left) * Integer.parseInt(right);
			right = "" + r;
		} 
		if (operator.compareTo("/") == 0){
			int r = Integer.parseInt(left) / Integer.parseInt(right);
			right = "" + r;
		} 
		
	} 	catch(NumberFormatException e){
		right = "NaN";
	} catch(ArithmeticException e){
		right = "Division by zero!";
	}
		
	
	
}
if (right != null ) {
	
	if(request.getParameter("0") != null ){
		right = right + "0";
		
	}
	if(request.getParameter("1") != null ){
		right = right + "1";
		
	}
	if(request.getParameter("2") != null ){
		right = right + "2";
		
	}
	if(request.getParameter("3") != null ){
		right = right + "3";
		
	}
	if(request.getParameter("4") != null ){
		right = right + "4";
		
	}
	if(request.getParameter("5") != null ){
		right = right + "5";
		
	}
	if(request.getParameter("6") != null ){
		right = right + "6";
		
	}
	if(request.getParameter("7") != null ){
		right = right + "7";
		
	}
	if(request.getParameter("8") != null ){
		right = right + "8";
		
	}
	if(request.getParameter("9") != null ){
		right = right + "9";
		
	}


}
if (operator != null){
	
	if (request.getParameter("add") != null ) {
		left = right;
		right = "";
		operator = request.getParameter("add");
	}
	if (request.getParameter("sub") != null ) {
		left = right;
		right = "";
		operator = request.getParameter("sub");
	}
	if (request.getParameter("mul") != null ) {
		left = right;
		right = "";
		operator = request.getParameter("mul");
	}
	if (request.getParameter("div") != null ) {
		left = right;
		right = "";
		operator = request.getParameter("div");
	}
}
if (request.getParameter("ce") != null ) {
	right = "";
	left = "";
	operator = "";
}
if (request.getParameter("c") != null ) {
	right = "";

}

%>

<form action="" method="POST">

 <input type="hidden"  name="left" value="<%= left %>">
 <input type="hidden"  name="right" value="<%= right %>">
 <input type="hidden"  name="operator" value="<%= operator %>">
 
 <div class="padding">
<input name="display" type="text" value="<%= right %>">
</div>
<div class="padding"> 
<input name="ce" type="submit" value="ce">
<input name="c" type="submit" value="c">
<input name="del" type="submit" value="del" class="disabled">
<input name="div" type="submit" value="/">
</div>
<div class="padding">
<input name="7" type="submit" value="7">
<input name="8" type="submit" value="8">
<input name="9" type="submit" value="9">
<input name="add" type="submit" value="+">
</div>
<div class="padding">
<input name="4" type="submit" value="4">
<input name="5" type="submit" value="5">
<input name="6" type="submit" value="6">
<input name="sub" type="submit" value="-">

</div>
<div class="padding">
<input name="1" type="submit" value="1">
<input name="2" type="submit" value="2">
<input name="3" type="submit" value="3">
<input name="mul" type="submit" value="*">

</div>
<div class="padding">
<input name="negate" type="submit" value="-" class="disabled">
<input name="0" type="submit" value="0">
<input name="colon" type="submit" value="," class="disabled">
<input name="equals" type="submit" value="=">
</div>

</form>
</body>
</html>