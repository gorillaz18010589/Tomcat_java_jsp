<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//抓到43,登入的name參數,顯示在頁面上
	String name= request.getParameter("name"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
歡迎光臨~ <%= name %>
</body>
</html>