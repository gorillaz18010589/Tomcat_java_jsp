<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.berry.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%--
<sql:setDataSource/ 設定連接資料庫
	driver="com.mysql.cj.jdbc.Driver" //連接mysql驅動程式
	url="jdbc:mysql://localhost:3307/ii?serverTimezone=Asia/Taipei" //時區用餐數帶
	user="root"
	password="root"
>:

<sql:update> //括弧內設置sql語法
	INSERT INTO member (account,passwd,realname) VALUES('ad','1234','cuzmaz')
</sql:update>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:catch var="error">
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3307/ii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
/>

<sql:update>
	INSERT INTO member (account,passwd,realname) VALUES('ad','1234','cuzmaz')
</sql:update>
</c:catch>
${error }

</body>
</html>