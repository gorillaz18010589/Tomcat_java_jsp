<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="tw.brad.beans.Member" %>
 <%/*
 value="${param.id } == request.getParamters方式
 <jsp:setProperty property="id" value="${param.id }" name="member"/> :抓到這個參數的屬性
 <jsp:setProperty property="name" value="${param.name }" name="member"/>
 ${member.id }//:顯示物件屬性的值
 */%>
 
 <jsp:useBean id="member" class="tw.brad.beans.Member"></jsp:useBean>
 <jsp:setProperty property="id" value="${param.id }" name="member"/>
 <jsp:setProperty property="name" value="${param.name }" name="member"/>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:getProperty property="id" name="member"/>:
<jsp:getProperty property="name" name="member"/>
<hr>
hello, ${member.id } ${member.name}   
<br>
</body>
</html>