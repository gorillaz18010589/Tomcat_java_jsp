<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--
<sql:query var="result"></sql:query> //放查詢sql指令  var="查詢的結果放此變數名稱"
select * from gift
select * from gift order by pname limit 10 //列出pname10筆資料
${result.rowCount } =>查詢總比數rowCount

<!- 抓尋資料庫欄位,並且顯示出來-->
<c:forEach items="${ result.rows}" var="x"> //尋訪你查詢裡面的rows(列),存到var裡
	<tr>	
		<td>${x.id }</td>  //顯示資料庫的id
		<td><img src='${x.url }'></td> 顯示資料庫裡的url
	</tr>
	</c:forEach>
	
<!-- 第一句是,如果page參數是空的那page至少1頁否則有的話就是表現出來 -->
<c:set var="page" value="${param.page == null ? 1 : param.page }" />
<c:set var="start" value="${(page - 1) * 10 }" />
<!-- 帶入設定頁數參數 -->
<sql:query var="result">
select * from gift order by id limit ${start },10
</sql:query>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3307/cust?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
/>
<!-- 查詢禮物資料表 -->
<sql:query var="rs1">
select * from gift
</sql:query>

<!-- 第一句是,如果page參數是空的那page至少1頁否則有的話就是表現出來 -->
<c:set var="page" value="${param.page == null ? 1 : param.page }" />
<c:set var="start" value="${(page - 1) * 10 }" />
<!-- 帶入設定頁數參數 -->
<sql:query var="result">
select * from gift order by id limit ${start },10
</sql:query>

<!-- 查詢總比數 -->
Count:${result.rowCount }<br>

<!-- 顯示資料庫抓出來的帳號,密碼,姓名 -->
<table border="1" width="100%">
	<tr>
		<td width="10%">id</td>
		<td width="10%">gid</td>
		<td width="30%">pname</td>
		<td width="30%">feature</td>
		<td >image</td>>
	</tr>
	<c:forEach items="${result.rows}" var="x">
	<tr>	
		<td>${x.id }</td>
		<td>${x.gid }</td>
		<td>${x.pname }</td>
		<td>${x.feature }</td>
		<td><img src='${x.url }'></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>