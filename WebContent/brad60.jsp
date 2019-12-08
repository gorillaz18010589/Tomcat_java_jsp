<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/*
<input name="x" value="${param.x }"> <!-- 抓到x參數顯示在此 -->
${param.x + param.y} <!-- 直接抓參數在裡面做運算顯示出來 -->
*/ %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<input name="x" value="${param.x }"> 
	+
	<input name="y" value="${param.y }">
	<input type="submit" value="=">
	${param.x + param.y} 
</form>
</body>
</html>