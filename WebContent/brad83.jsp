<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
I am brad83.jsp
<hr>
<%
	//四個的範圍設定
	//pageContext:活在一頁之間,直接抓參數沒有特定都是以pageContext
	//request:活在兩頁之間
	//session:活在類似網站記錄,關閉瀏覽器消失
	//application:活在全頁面
	
	//指定呼叫真對的參數方式
	//request:${requestScope.ran } 指定呼叫request的參數
	//session:${sessionScope.ran }  指定呼叫session的參數
	//application:${applicationScope.ran } 指定呼叫applicaion的參數
	
	//還有一個request是傳遞樂透號碼而來1.request 2.pageContext 3.session 4. application
	pageContext.setAttribute("ran", "pageContext");
	session.setAttribute("ran", "session");
	application.setAttribute("ran", "application");
	
%>
顯示出82抓到的樂透參數為:${ran }<hr>
request:${requestScope.ran }<hr>
session:${sessionScope.ran }<hr>
application:${applicationScope.ran }
</body>
</html>