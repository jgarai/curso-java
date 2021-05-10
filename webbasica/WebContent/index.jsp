<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora</title>
</head>
<body>

${param.left }
${param.right }
<form action="" method="POST">
<input name="left" type="text" value="">
<input name="right" type="text" value="">
<select><option value="+">+</option>
  <option value="-">-</option>
  <option value="*">*</option>
  <option value="//">/</option></select>

<input type="submit" value="Submit">
</form>

</body>
</html>