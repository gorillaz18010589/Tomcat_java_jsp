<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- 新增資料 -->

<%/*
<!-- 新增到mysql用parement方式防止名瑪攻擊 -->
<sql:update var="count">
	INSERT INTO cust (cname,tel,birthday) VALUES(?,?,?) //parement敘述句
	<sql:param>${param.cname }</sql:param> //資料庫帶參數
	<sql:param>${param.tel }</sql:param>
	<sql:param>${param.birthday }</sql:param>
</sql:update
*/%>
<!-- 看使用者有沒有打資料上來,如果有資料上來不為空時 -->
<c:if test="${!empty param.cname }">
<!-- 載入驅動程式 -->
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3305/ii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
	/>
	<!-- 新增到mysql用parement方式防止名瑪攻擊 -->
	<sql:update var="count">
		INSERT INTO cust (cname,tel,birthday) VALUES(?,?,?)
		<sql:param>${param.cname }</sql:param>
		<sql:param>${param.tel }</sql:param>
		<sql:param>${param.birthday }</sql:param>
	</sql:update>
	<!-- 新增登入完跳轉頁面 -->
	<c:redirect url="brad71_sql_tag.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add new Customer</h2>

<form action="brad72.jsp">
	Name:<input name="cname"><br>
	Phone:<input name="tel"><br>
	Birthday:<input name="birthday"><br>
	<input type="submit" value="Add"/>
</form>
</body>
</html>