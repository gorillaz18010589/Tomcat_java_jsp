<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%/*
<c:catch>範圍內放可出例外的%</c:catch>
<c:catch var="error"> //抓到這個例外的錯誤
${error} //顯示錯誤原因
 */%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:catch var="error">
	<% 
	String num = request.getParameter("n"); 
	int n = Integer.parseInt(num); 
	out.print(n); 
	%>
</c:catch>

Hello,沒有錯誤被我擋掉
<br>
錯誤原因:${error} }
</body>
</html>