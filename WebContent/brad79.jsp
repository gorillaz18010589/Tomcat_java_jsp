<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 這裡是登入頁面,後端在jsp80,登入成功在jsp81 -->
<!-- session介紹 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="brad80.jsp">
帳號:<input type="text" name="account"><br>
密碼:<input type="password" name="passwd">
<br>
<input type="submit" value="Login">
</form>
</body>
</html>