<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/*
//連接53

<%@ page import="tw.brad.myjva.Member"% ://imporant pakge方式
	application.setAttribute("member", member)://設置屬性上去("名稱",物件))整個伺服器都拿的到參數跟資訊
*/ %>
<%@ page import="tw.brad.myjva.Member"%>
<%
	Member member = new Member("Brad","hank",19); //創了會員的物件實體
	application.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>