<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- 撈資料,改資料,編輯頁面 -->
<%/*
<c:catch>
<sql:transaction>
	<sql:update var="n1">
		INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)
		<sql:param>Eric</sql:param>
		<sql:param>1234567</sql:param>
		<sql:param>1987-09-08</sql:param>
	</sql:update>	

	<sql:query var="lastid">
		SELECT last_insert_id() as newid
	</sql:query>
	
	<sql:update var="n2">
		UPDATE cust SET tel = ? WHERE id = ?
		<sql:param>777</sql:param>
		<sql:param>88888</sql:param>
	</sql:update>	
</sql:transaction>	
<c:if test="${n1 > 0 }">
LastId : ${lastid.rows[0].newid }
</c:if>

</c:catch>
*/ %>


<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3305/ii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
/>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:catch>
	<sql:transaction>
		<sql:update var="n1">
			INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)
			<sql:param>Eric</sql:param>
			<sql:param>1234567</sql:param>
			<sql:param>1987-09-08</sql:param>
		</sql:update>	
	
		<sql:query var="lastid">
			SELECT last_insert_id() as newid
		</sql:query>
		
		<sql:update var="n2">
			UPDATE cust SET tel = ? WHERE id = ?
			<sql:param>777</sql:param>
			<sql:param>88888</sql:param>
		</sql:update>	
	</sql:transaction>	
	<c:if test="${n1 > 0 }">
	最後一筆單號 : ${lastid.rows[0].newid }
	</c:if>

</c:catch>


</body>
</html>