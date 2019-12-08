<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//<%@ inclide file="brad49.jsp" % :用include方式把其他頁面頰近來
//request.setAttribute("who","brad"): //request.設置屬性上去("物件","自訂名") 遊走在兩夜之間
//為什麼要用jsp夾 因為,要讓48的參數還可以讓49號玩
//requset是兩頁之間的事情,但include其實是把別頁夾近來,還是在48頁
//因為pageContext.setAttribute("value1", "cc");//pageContext.設置屬性上去("物件","自訂名")在一頁page之間
//49頁抓的到,所以證明include是把49夾近來,但還是在同一頁
%>
<%
	pageContext.setAttribute("value1", "cc");//pageContext.設置屬性上去("物件","自訂名")在一頁page之間
	request.setAttribute("who","brad"); //request.設置屬性上去("物件","自訂名") 遊走在兩夜之間
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>48號程式</h1>
<hr>
<%@ include file="brad49.jsp" %>
<hr>
</body>
</html>