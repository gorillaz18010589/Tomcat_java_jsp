<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="brad47.jsp" %>    
<!-- page errorPage="brad47.jsp"出現錯誤指定到這個頁面 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a , b; a=10; b=0;
		out.print(a/b); //這邊會出錯
	%>
</body>
</html>