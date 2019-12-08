<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	//javax.servlet.http.HttpServletRequest.getMethod()://取得用戶的方法(回傳String)
	//javax.servlet.ServletRequest.getRemoteAddr()://取得用戶的ip(回傳String)
	//javax.servlet.http.HttpServletRequest.getQueryString://取得用戶輸入的參數值(回傳String)
  	//method = ${pageContext.request.method } ://取得用戶的方法
	//yourip = ${pageContext.request.queryString }://取得用戶輸入的參數值
	//play = ${pageContext.response.locale.country }://取得用戶本地裡面的國際
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//任何只要從用戶端來的訊息通通來自request
	String method = request.getMethod(); //取得用戶傳來的方法
	out.print(method);
	
	//證明pageContext.的請求 == request是同一個
	HttpServletRequest req = 
			(HttpServletRequest)pageContext.getRequest();
		out.println(req == request);
		out.println("<hr>");
		
		String remote = request.getRemoteAddr(); //取得用戶的ip
		out.print(remote +"+<hr>");
		
		String queryString = request.getQueryString();//取得用戶輸入的參數值
		out.print(queryString +"<hr>");
		
		int a = (int)(Math.random()*5+1);
		
			
%>

method = ${pageContext.request.method } <br>
yourip = ${pageContext.request.queryString }<br>
play = ${pageContext.response.locale.country }<br>
a = <%= a %>
		

</body>
</html>