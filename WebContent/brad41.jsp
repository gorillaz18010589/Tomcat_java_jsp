<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%! int 10:痊癒變數10

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int b =10; %>
<%! int a =10; %>
a= <%= a++%>   <!-- 一值重整都會+,因為!a是static痊癒變數 -->
b= <%= b++%>   <!-- 不會變因為區域變數 -->
</body>
</html>