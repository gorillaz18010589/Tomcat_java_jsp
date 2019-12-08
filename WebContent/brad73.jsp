<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- 撈資料,改資料,編輯頁面 -->
<%/*
Name:<input name="cname" value="${result.rows[0].cname }"><br> //把值顯示你查詢資料的rows裡面的地0筆裡面的cname
<input type="hidden" value="${result.rows[0].id }"> 偷偷把id資訊的參數在你輸入時抓到
UPDATE cust SET cname=?,tel=?,birthday=? WHERE id = ? 把檔案改成
		<sql:param>${param.cname }</sql:param> ,改成這個參數名
*/ %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3305/ii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
/>
<!-- 修改資料 -->
<c:if test="${!empty param.updateid }">
	<sql:update>
		UPDATE cust SET cname=?,tel=?,birthday=? WHERE id = ?
		<sql:param>${param.cname }</sql:param>
		<sql:param>${param.tel }</sql:param>
		<sql:param>${param.birthday }</sql:param>
		<sql:param>${param.updateid }</sql:param>	
	</sql:update>
	<c:redirect url="brad71_sql_tag.jsp"/>
</c:if>

<!-- 撈出資料,並且搭配給result,讓值呈現 -->
<sql:query var="result">
	SELECT * FROM cust WHERE id = ?
	<sql:param>${param.editid }</sql:param>
</sql:query>


<!-- 先撈資料讓預設值顯示在頁面上 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>編輯版面</h2>

<form action="brad73.jsp">
	<input type="hidden" name=updateid value="${result.rows[0].id }">
	Name:<input name="cname" value="${result.rows[0].cname }"><br>
	Phone:<input name="tel" value="${result.rows[0].tel }"><br>
	Birthday:<input name="birthday"value="${result.rows[0].birthday }"><br>
	<input type="submit" value="Update"/>
</form>
</body>
</html>