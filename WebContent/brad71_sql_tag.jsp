<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%/*

//點下刪除按鈕後參數帶到後方去寫刪除sql
<a href='?delid=${x.id }'> //a href帶參數的方法

//點下去後觸發回傳一個function去conrfi
<a href='?delid=${x.id }'onclick="return delteconfim('${x.cname}')">
<button >Del</button>
</a>

<c:if test="${!empty param.delid}"> //如果刪除安鈕的參數不是空的
<sql:update>
DELETE FROM cust WHERE id = ? //刪除資訊 id是 參數
<sql:param>	${param.delid }</sql:param> //帶上刪除的id參數
</sql:update>
</c:if>
*/ %>
<!-- 這裡是主畫面,案新增拉到72號 -->
<!-- 載入驅動程式 -->
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3305/ii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
/>

<c:if test="${!empty param.delid}">
	<sql:update>
	DELETE FROM cust WHERE id = ?
	<sql:param>	${param.delid }</sql:param>
	</sql:update>
</c:if>

<<sql:query var="result">
	SELECT *From cust
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主畫面</title>
</head>
<body>
<h1>主畫面</h1>
<hr>
<a href="brad72.jsp">Add New</a>
<hr>
<table border="1" width="100%">
	<tr>
		<th>id</th>
		<th>Name</th>
		<th>Phone</th>
		<th>Birthday</th>
		<th>Delte</th>
		<th>Edite</th>
	</tr>
		<!-- 把抓到的資訊印出在頁面上,靠尋訪 -->
	<c:forEach items="${result.rows }" var="x">
		<tr>
			<td>${x.id }</td>
			<td>${x.cname }</td>
			<td>${x.tel }</td>
			<td>${x.birthday }</td>
			<td>
				<script type="text/javascript">
						function delteconfim(cname) {
							return confirm("是否要刪除" + cname +"?");
						}
				</script>
				<a href='?delid=${x.id }'onclick="return delteconfim('${x.cname}')">
					<button >Del</button>
				</a>
			</td>
			
			<td>
				<a href='brad73.jsp?editid=${x.id }'>
				<button >Edit</button>
			</a>
			</td>
		</tr>
	</c:forEach>
		
</table>
</body>
</html>