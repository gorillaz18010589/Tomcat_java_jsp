<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!-- 宣告為<%@page isErrorPage="true" %>我是這個錯誤頁面的處理扯 -->
<!--out.print(exception);  抓到exception錯誤例外是隱含物件給我了-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>跑到47號程式的錯誤程式</h1>
<%
	out.print(exception);
%>

</body>
</html>