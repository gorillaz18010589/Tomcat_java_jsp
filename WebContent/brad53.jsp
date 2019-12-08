<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.brad.myjva.Member"%>
<%/*
//application.getAttribute("member"): //拿到屬性,且整個伺服器頁面都是範圍
//所以一般不會用在登入,但全域性屬性,使用他的時機在於全站
//1.page:單一頁面
//2.request:兩個頁面
//3.session:通常用在登入帳號
//4.application:活在整個頁面全站
*/ %>

<% Member member = (Member) application.getAttribute("member"); //取得member的參數,轉型成類別

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%= member.getAccount() %>
</body>
</html>