<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="brad" %>
<%/*
http://localhost:8080/MyjavaEE/brad77_tags.jsp
//2.自訂標籤方式
//*寫標籤的目的在呈現,或是邏輯呈現,最終目的是輸出
//百分比java也可以寫成自訂標籤
//寫標籤要很獨立
1.在web-inf底下創一個follder名子叫tags
2.在tags底下創一個test1.tag就可以自己定義標籤
3.在要寫入的頁面<%@ taglib tagdir="/WEB-INF/tags" prefix="brad" % //設定資料夾,跟prefix名字

<%@ attribute name="user" required="true"%://屬性參數 name="自訂"  是否一定要="true"
	<brad:test1/> 等於我自訂的標籤呼叫
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>大家好</h1>
<brad:test1/>

<br>
<brad:test2 user="hank"></brad:test2>

<brad:test3 x="10" y="3">
10+3 = ${add }<br>
10-3= ${sub }<br>
10*3 = ${mulitiply }<br>
10/3 = ${divide }<br>
</brad:test3>
<hr>
<brad:test4/>
<hr>

<table width="100%" border="1">
	<tr>
		<th>Name</th>
		<th>Price</th>
	</tr>
	<brad:product name="Camera" price="1000" />	
	<brad:product name="Mouse" />	
	<brad:product name="Mobile" price="10000" />	
	
</table>
</body>
</html>