<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
/*
<jsp:include page="brad51.jsp"> //include,其他頁近來,還是同一頁
	<jsp:param value="bard" name="name"/>  //自己設定參數上去,走requset
	<jsp:param value="18" name="age"/> 
</jsp:include>

*/
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello brad50</h1>

<jsp:include page="brad51.jsp">
	<jsp:param value="bard" name="name"/> 
	<jsp:param value="18" name="age"/> 
</jsp:include>


</body>
</html>