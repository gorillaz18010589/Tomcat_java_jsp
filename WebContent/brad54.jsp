<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%/*
	<jsp:forward page="brad55_forward.jsp"> //forwad道別頁轉出去,但還是算一頁
		<jsp:param value="123" name="var1"/> //設定參數跟值上去
		<jsp:param value="456" name="var2"/>
	</jsp:forward>
 */%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello,brad54
<hr>
<jsp:forward page="brad55_forward.jsp">
	<jsp:param value="123" name="var1"/>
	<jsp:param value="456" name="var2"/>
</jsp:forward>
</body>
</html>