<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% /*

<c:forEach items='${names }' var="x" //尋訪的items="項目"  每一輪尋訪的值存在var裡
 begin="1" end="6" step="2" //從陣列1開始,到6結束,一次跳2個
 varStatus="y">        //宣告這個狀態值去做處理
 

	<td>${y.index }</td>//抓到這個尋訪的index
	<td>${x }</td> //抓到這個尋訪的值
	<td>${y.count }</td> //抓到這個尋訪有幾筆

*/%>
<%

	String[] names = {"Brad","Hank","Merry","LBJ","Kidd","Kobe","catrer","jennief"};
	pageContext.setAttribute("names", names);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
	<tr>
		<th>Index</th>
		<th>Name</th>
		<th>Count</th>
		<th>First</th>
		<th>Last</th>
	</tr>

	<c:forEach items='${names }' var="x"
		begin="1" end="6" step="2"
		varStatus="y">
	<tr bgcolor="
		<c:choose>
			<c:when test="${y.first }">red</c:when>
			<c:when test="${y.last }">blue</c:when>
			<c:otherwise>green</c:otherwise>
		</c:choose>
		">
		<td>${y.index }</td>
		<td>${x }</td>
		<td>${y.count }</td>
		<td>${y.first }</td>
		<td>${y.last }</td>
	</tr>
	
	
	</c:forEach>
	

</table>
</body>
</html>